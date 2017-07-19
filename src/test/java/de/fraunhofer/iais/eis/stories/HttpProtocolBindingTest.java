package de.fraunhofer.iais.eis.stories;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

public class HttpProtocolBindingTest {
    /**
     * As a data owner I want to provide a service that publishes data of a sensor with a certain id and which should be
     * accessible at <http://opcua-ids-connector:8080/sensors/{sensorId}> so that it can be directly invoked by other participants.
     */

    @Test
    public void createEndpointWithProtocolBinding() throws ConstraintViolationException, MalformedURLException {
        new DataEndpointBuilder()
            .offers(createOffering())
            .protocolBinding(createProtocolBinding())

            // mandatory fields
            .providedBy(new URL("http://industrialdataspace.org/participants/companyA"))
            .entityNames(Arrays.asList(new PlainLiteral("Sensor Connector Endpoint", "en")))
            .build();
    }

    private DataService createOffering() throws ConstraintViolationException {
        return new DataServiceBuilder()
            .operations(Arrays.asList(createOperation()))
            .build();
    }

    private Operation createOperation() throws ConstraintViolationException {
        return new ReadOperationBuilder()
            .inputs(Arrays.asList(createInputParameter()))
            .outputs(Arrays.asList(createOutputParameter()))

            .opLabels(Arrays.asList(new PlainLiteral("Retrieve data of a single sensor", "en")))
            .build();
    }

    private InputParameter createInputParameter() throws ConstraintViolationException {
        Representation intType = new RepresentationBuilder()
            .dataType(ParameterDataType.XSD_INT)
            .build();

        return new InputParameterBuilder()
            .paramName("sensorId")
            .representation(intType)
            .build();
    }

    private OutputParameter createOutputParameter() throws ConstraintViolationException {
        return new OutputParameterBuilder()
                .continuehere
                .build();
    }


    private ProtocolBinding createProtocolBinding() {
        return null;
    }
}
