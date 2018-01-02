package de.fraunhofer.iais.eis.stories;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
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
    public void createOffering() throws MalformedURLException, ConstraintViolationException {
        DataEndpoint endpoint = describeDataEndpoint();
        String rdf = endpoint.toRdf();

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
            .action(Action.PAY_ONCE)
            .constraint(Arrays.asList(describeOneTimePaymentConstraint()))
            .build();
        Duty payPerVolumeDuty = new DutyBuilder()
            .action(Action.PAY_PER_VOLUME)
            .constraint(Arrays.asList(describeVolumePaymentConstraint()))
            .build();
        Duty payPeriodicallyDuty = new DutyBuilder()
            .action(Action.PAY_PERIODICALLY)
            .constraint(Arrays.asList(describePeriodicPaymentConstraint()))
            .build();

        return Arrays.asList(payOnceDuty, payPerVolumeDuty, payPeriodicallyDuty);
    }

    private Constraint describeOneTimePaymentConstraint() throws ConstraintViolationException {
        return new PayOnceConstraintBuilder()
            .payAmount(500f)
            .paymentUnit(Unit.EUR.getId())
            .build();
    }

    private Constraint describeVolumePaymentConstraint() throws ConstraintViolationException {
        return new PayPerVolumeConstraintBuilder()
            .payAmount(100f)
            .paymentUnit(Unit.EUR.getId())
            .volumeAmount(100f)
            .volumeUnit(Unit.KB.getId())
            .build();
    }

    private Constraint describePeriodicPaymentConstraint() throws ConstraintViolationException {
        return new PayPeriodicallyConstraintBuilder()
            .payAmount(200f)
            .paymentUnit(Unit.EUR.getId())
            .recurrenceRate(RecurrenceRate.WEEKLY)
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
