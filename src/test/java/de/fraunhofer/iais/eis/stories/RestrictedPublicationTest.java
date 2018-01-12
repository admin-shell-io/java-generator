package de.fraunhofer.iais.eis.stories;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.datatypes.xsd.impl.XSDFloat;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.rdf.model.Literal;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class RestrictedPublicationTest {
    /** As an IDS participant I want to provide my data offering to a restricted group of partners. Each partner is
     *  obliged to pay either 500eur one-time, 100eur per 100kb or 200eur per week and must not redistribute it to
     *  third parties and delete it after 12 months.
     */

    // these SHOULD be resolvable
    private final URL CONNECTOR_URL = new URL("http://companyA.com/IDS/connector1");
    private final URL DATA_ENDPOINT_URL = new URL("http://industrialdataspace.org/connector1/endpoint1");
    private final URL PARTNER1_URL = new URL("http://industrialdataspace.org/participants/companyB");
    private final URL PARTNER2_URL = new URL("http://industrialdataspace.org/participants/companyC");

    // this does not need to be resolvable, it is needed here fore ODRL compatibility
    private final URL OPERATION_URL = new URL("http://industrialdataspace.org/connector1/endpoint1/service/getDataOp");

    private final StoryUtil storyUtil;

    public RestrictedPublicationTest() throws MalformedURLException {
        storyUtil = new StoryUtil();
        storyUtil.setOperationUrl(OPERATION_URL);
    }

    @Test
    public void createOffering() throws MalformedURLException, ConstraintViolationException, URISyntaxException {
        DataEndpoint endpoint = describeDataEndpoint();
        String rdf = endpoint.toRdf();

        DataEndpoint deser = (DataEndpoint) VocabUtil.fromRdf(rdf);
        Assert.assertNotNull(deser);
    }

    private DataEndpoint describeDataEndpoint() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        return new DataEndpointBuilder(DATA_ENDPOINT_URL)
                .entityNames(Arrays.asList(new PlainLiteral("Endpoint providing my revenue dataset", "en")))
                .offers(storyUtil.describeDataService())
                .providedBy(CONNECTOR_URL)
                .usagePolicies(Arrays.asList(describeServiceContract()))
                .build();
    }

    private OfferedContract describeServiceContract() throws MalformedURLException, ConstraintViolationException {
        return new OfferedContractBuilder()
            .permission(Arrays.asList(describeInvokeOperationPermission()))
            .prohibition(Arrays.asList(describeGrantUseProhibition()))
            .build();
    }

    private Permission describeInvokeOperationPermission() throws ConstraintViolationException {
        Collection<Duty> duties = new ArrayList<>();
        duties.addAll(describePaymentDuties());
        duties.add(describeDeletionDuty());

        return new PermissionBuilder()
            .action(Action.INVOKE_OPERATION)
            .target(OPERATION_URL)
            .assignees(getPartnerUrls())
            .duties(duties)
            .build();
    }

    private Collection<URL> getPartnerUrls() {
        return Arrays.asList(PARTNER1_URL, PARTNER2_URL);
    }

    private Collection<Duty> describePaymentDuties() throws ConstraintViolationException {



        Duty payOnceDuty = new DutyBuilder()
            .action(createOneTimePaymentAction())
            .build();

        Duty payPerVolumeDuty = new DutyBuilder()
            .action(describeVolumePaymentConstraint())
            .build();

        Duty payPeriodicallyDuty = new DutyBuilder()
            .action(describePeriodicPaymentConstraint())
            .build();

        return Arrays.asList(payOnceDuty, payPerVolumeDuty, payPeriodicallyDuty);
    }

    private Action createOneTimePaymentAction() throws ConstraintViolationException {
        Literal amount = (Literal) NodeFactory.createLiteral("500", new XSDFloat("xsd:float")).getLiteral();
        Constraint moneyConstraint = new ConstraintBuilder()
                .leftOperand(LeftOperand.PAY_AMOUNT)
                .operator(BinaryOperator.EQUALS)
                .rightOperand(amount)
                .unit(Unit.EUR.getId()).build();
        return new PaymentActionBuilder().refinements(Arrays.asList(moneyConstraint)).build();
    }

    private Action describeVolumePaymentConstraint() throws ConstraintViolationException {
        Literal amount = (Literal) NodeFactory.createLiteral("100", new XSDFloat("xsd:float")).getLiteral();
        Constraint moneyConstraint = new ConstraintBuilder()
                .leftOperand(LeftOperand.PAY_AMOUNT)
                .operator(BinaryOperator.EQUALS)
                .rightOperand(amount)
                .unit(Unit.EUR.getId()).build();

        Literal quantity = (Literal) NodeFactory.createLiteral("100", new XSDFloat("xsd:float")).getLiteral();
        Constraint quantityConstraint = new ConstraintBuilder()
                .leftOperand(LeftOperand.QUANTITY)
                .operator(BinaryOperator.EQUALS)
                .rightOperand(quantity)
                .unit(Unit.KB.getId()).build();

        return new PaymentActionBuilder().refinements(Arrays.asList(moneyConstraint, quantityConstraint)).build();
    }

    private Action describePeriodicPaymentConstraint() throws ConstraintViolationException {
        Literal amount = (Literal) NodeFactory.createLiteral("200", new XSDFloat("xsd:float")).getLiteral();
        Constraint moneyConstraint = new ConstraintBuilder()
                .leftOperand(LeftOperand.PAY_AMOUNT)
                .operator(BinaryOperator.EQUALS)
                .rightOperand(amount)
                .unit(Unit.EUR.getId()).build();

        Literal times = (Literal) NodeFactory.createLiteral("1", new XSDFloat("xsd:float")).getLiteral();
        Constraint recurrenceConstraint = new ConstraintBuilder()
                .leftOperand(LeftOperand.RECURRENCE_RATE)
                .operator(BinaryOperator.EQUALS)
                .rightOperand(times)
                .unit(Unit.WEEK.getId()).build();

        return new PaymentActionBuilder().refinements(Arrays.asList(moneyConstraint, recurrenceConstraint)).build();
    }

    private Duty describeDeletionDuty() throws ConstraintViolationException {
        new DeleteActionBuilder().refinements(describeDeletionConstraint())

        return new DutyBuilder()
            .action(Action.DELETE)
            .constraint(Arrays.asList(describeDeletionConstraint()))
            .build();
    }

    private Constraint describeDeletionConstraint() throws ConstraintViolationException {
        return new ConstraintBuilder()
            .dateTime("P12M")
            .build();
    }

    private Prohibition describeGrantUseProhibition() throws ConstraintViolationException {
        return new ProhibitionBuilder()
            .action(Action.DISTRIBUTE)
            .target(OPERATION_URL)
            .assignees(getPartnerUrls())
            .build();
    }

}
