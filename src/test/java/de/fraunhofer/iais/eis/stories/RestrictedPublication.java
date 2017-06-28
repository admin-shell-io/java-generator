package de.fraunhofer.iais.eis.stories;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

public class RestrictedPublication {
    /** As an IDS participant I want to provide my data offering to a restricted group of partners. Each partner is
     *  obliged to pay 500eur for downloading the dataset, must not redistribute it to third parties and delete it
     *  after 12 months.
     */

    // these SHOULD be resolvable
    private final URL CONNECTOR_URL = new URL("http://companyA.com/IDS/connector1");
    private final URL DATA_ENDPOINT_URL = new URL("http://industrialdataspace.org/connector1/endpoint1");
    private final URL PARTNER1_URL = new URL("http://industrialdataspace.org/participants/companyB");
    private final URL PARTNER2_URL = new URL("http://industrialdataspace.org/participants/companyC");

    // this does not need to be resolvable, it is needed here fore ODRL compatibility
    private final URL OPERATION_URL = new URL("http://industrialdataspace.org/connector1/endpoint1/service/getDataOp");

    private final StoryUtil storyUtil;

    public RestrictedPublication() throws MalformedURLException {
        storyUtil = new StoryUtil();
        storyUtil.setOperationUrl(OPERATION_URL);
    }

    @Test
    public void createOffering() throws MalformedURLException, ConstraintViolationException {
        DataEndpoint endpoint = describeDataEndpoint();
        String rdf = endpoint.toRdf();

        System.out.println(rdf);

        DataEndpoint deser = (DataEndpoint) VocabUtil.fromRdf(rdf);
        Assert.assertNotNull(deser);
    }

    private DataEndpoint describeDataEndpoint() throws ConstraintViolationException, MalformedURLException {
        return new DataEndpointBuilder(DATA_ENDPOINT_URL)
                .entityNames(Arrays.asList(new PlainLiteral("Endpoint providing my revenue dataset", "en")))
                .offers(storyUtil.describeDataService())
                .providedBy(CONNECTOR_URL)
                .usagePolicies(Arrays.asList(describeServiceContract()))
                .build();
    }

    private ServiceContract describeServiceContract() throws MalformedURLException, ConstraintViolationException {
        return new ServiceContractBuilder()
            .permission(Arrays.asList(describeInvokeOperationPermission()))
            .prohibition(Arrays.asList(describeGrantUseProhibition()))
            .build();
    }

    private Permission describeInvokeOperationPermission() throws ConstraintViolationException {
        return new PermissionBuilder()
            .action(Action.INVOKE_OPERATION)
            .target(OPERATION_URL)
            .assignees(getPartnerUrls())
            .duties(Arrays.asList(describePaymentDuty(), describeDeletionDuty()))
            .build();
    }

    private Collection<URL> getPartnerUrls() {
        return Arrays.asList(PARTNER1_URL, PARTNER2_URL);
    }

    private Duty describePaymentDuty() throws ConstraintViolationException {
        return new DutyBuilder()
            .action(Action.PAY_ONCE)
            .constraint(Arrays.asList(describePaymentConstraint()))
            .build();
    }

    private Constraint describePaymentConstraint() throws ConstraintViolationException {
        return new ConstraintBuilder()
            .payAmount(500f)
            .operator(BinaryOperator.EQUALS)
            .unit(Unit.EUR)
            .build();
    }

    private Duty describeDeletionDuty() throws ConstraintViolationException {
        return new DutyBuilder()
            .action(Action.DELETE)
            .constraint(Arrays.asList(describeDeletionConstraint()))
            .build();
    }

    private Constraint describeDeletionConstraint() throws ConstraintViolationException {
        return new ConstraintBuilder()
            .dateTime("P12M")
            .operator(BinaryOperator.EQUALS)
            .unit(Unit.EUR)
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
