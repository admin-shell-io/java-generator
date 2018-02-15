package de.fraunhofer.iais.eis.stories;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.datatypes.xsd.impl.XSDFloat;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.ResourceFactory;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ControlledPublicationTest {
    /** As an IDS participant I want to provide my data under the conditions to either  to pay 500eur one-time,
     * 100eur per 100kb or 200eur per week and must not redistribute it to third parties and delete it after 12 months.
     * todo: this example currently only uses plain literals for right operands, it should be typed literals
     */

    private final URL DATA_ENDPOINT_URL = new URL("http://industrialdataspace.org/connector1/endpoint1");
    private final URL OPERATION_URL = new URL("http://industrialdataspace.org/connector1/endpoint1/service/getDataOp");

    public ControlledPublicationTest() throws MalformedURLException {
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
                .operations(Arrays.asList(describeOperation()))
                .publishes(describeDataAsset())
                .usagePolicies(Arrays.asList(describeServiceContract()))
                .build();
    }

    private Operation describeOperation() throws ConstraintViolationException {
        return new ReadOperationBuilder(OPERATION_URL)
                .opLabels(Arrays.asList(new PlainLiteral("Retrieve the whole dataset", "en")))
                .outputs(Arrays.asList(describeOutput()))
                .build();
    }

    private OutputParameter describeOutput() throws ConstraintViolationException {
        return new OutputParameterBuilder()
                .representation(describeRepresentation())
                .build();
    }

    private Representation describeRepresentation() throws ConstraintViolationException {
        return new RepresentationBuilder()
                .mediaType(IANAMediaType.APPLICATION_XML)
                .build();
    }

    public DataAsset describeDataAsset() throws MalformedURLException, ConstraintViolationException, URISyntaxException {
        return new DataAssetBuilder()
                .entityNames(Arrays.asList(new PlainLiteral("Development of company revenue", "en")))
                .coversCategories(Arrays.asList(new URI("http://dbpedia.org/resource/Category:Finance")))
                .build();
    }

    private OfferedContract describeServiceContract() throws MalformedURLException, ConstraintViolationException {
        return new OfferedContractBuilder()
            .permission(Arrays.asList(describeInvokeOperationPermission()))
            .prohibition(Arrays.asList(describeDistributeProhibition()))
            .build();
    }

    private Permission describeInvokeOperationPermission() throws ConstraintViolationException {
        Collection<Duty> duties = new ArrayList<>();
        duties.addAll(describePaymentDuties());
        duties.add(describeDeletionDuty());

        return new PermissionBuilder()
            .action(new InvokeOperationActionBuilder().build())
            .target(OPERATION_URL)
            .duties(duties)
            .build();
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
        Constraint moneyConstraint = new ConstraintBuilder()
                .leftOperand(LeftOperand.PAY_AMOUNT)
                .operator(BinaryOperator.EQUALS)
                .rightOperand(ResourceFactory.createStringLiteral("500"))
                .unit(Unit.EUR.getId()).build();
        return new PaymentActionBuilder().refinements(Arrays.asList(moneyConstraint)).build();
    }

    private Action describeVolumePaymentConstraint() throws ConstraintViolationException {
        Constraint moneyConstraint = new ConstraintBuilder()
                .leftOperand(LeftOperand.PAY_AMOUNT)
                .operator(BinaryOperator.EQUALS)
                .rightOperand(ResourceFactory.createStringLiteral("100"))
                .unit(Unit.EUR.getId()).build();

        Constraint quantityConstraint = new ConstraintBuilder()
                .leftOperand(LeftOperand.QUANTITY)
                .operator(BinaryOperator.EQUALS)
                .rightOperand(ResourceFactory.createStringLiteral("100"))
                .unit(Unit.KB.getId()).build();

        return new PaymentActionBuilder().refinements(Arrays.asList(moneyConstraint, quantityConstraint)).build();
    }

    private Action describePeriodicPaymentConstraint() throws ConstraintViolationException {
        Constraint moneyConstraint = new ConstraintBuilder()
                .leftOperand(LeftOperand.PAY_AMOUNT)
                .operator(BinaryOperator.EQUALS)
                .rightOperand(ResourceFactory.createStringLiteral("200"))
                .unit(Unit.EUR.getId()).build();

        Constraint recurrenceConstraint = new ConstraintBuilder()
                .leftOperand(LeftOperand.RECURRENCE_RATE)
                .operator(BinaryOperator.EQUALS)
                .rightOperand(ResourceFactory.createStringLiteral("1"))
                .unit(Unit.WEEK.getId()).build();

        return new PaymentActionBuilder().refinements(Arrays.asList(moneyConstraint, recurrenceConstraint)).build();
    }

    private Duty describeDeletionDuty() throws ConstraintViolationException {
        Action deleteAction = new DeleteActionBuilder().refinements(Arrays.asList(describeDeletionConstraint())).build();

        return new DutyBuilder()
            .action(deleteAction)
            .build();
    }

    private Constraint describeDeletionConstraint() throws ConstraintViolationException {
        return new ConstraintBuilder()
            .leftOperand(LeftOperand.TIME_INTERVAL)
            .operator(BinaryOperator.EQUALS)
            .rightOperand(ResourceFactory.createStringLiteral("P12M"))
            .build();
    }

    private Prohibition describeDistributeProhibition() throws ConstraintViolationException {
        return new ProhibitionBuilder()
            .action(new DistributeActionBuilder().build())
            .target(OPERATION_URL)
            .build();
    }

}
