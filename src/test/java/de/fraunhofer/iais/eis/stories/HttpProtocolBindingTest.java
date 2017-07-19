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

    private Operation readSensorDataOperation;

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

    private DataService createOffering() throws ConstraintViolationException, MalformedURLException {
        return new DataServiceBuilder()
            .operations(Arrays.asList(createOperation()))
            .build();
    }

    private Operation createOperation() throws ConstraintViolationException, MalformedURLException {
        readSensorDataOperation = new ReadOperationBuilder()
            .inputs(Arrays.asList(createInputParameter()))
            .outputs(Arrays.asList(createOutputParameter()))

            .opLabels(Arrays.asList(new PlainLiteral("Retrieve data of a single sensor", "en")))
            .build();
        return readSensorDataOperation;
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

    private OutputParameter createOutputParameter() throws ConstraintViolationException, MalformedURLException {
        Representation rdfSsnType = new RepresentationBuilder()
                .mediaType(IANAMediaType.APPLICATION_RDF_XML)
                .conformsToStandard(new URL("http://purl.oclc.org/NET/ssnx/ssn"))
                .build();

        return new OutputParameterBuilder()
            .representation(rdfSsnType)
            .build();
    }


    private ProtocolBinding createProtocolBinding() throws ConstraintViolationException {
        return new ProtocolBindingBuilder()
                .operationBindings(Arrays.asList(createOperationBinding()))
                .build();
    }

    private OperationBinding createOperationBinding() throws ConstraintViolationException {
        return new OperationHttpBindingBuilder()
                .boundOperation(readSensorDataOperation)
                .parameterBindings()
                .build();
    }
}
