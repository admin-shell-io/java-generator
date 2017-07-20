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
     * As a data owner I want to provide a service that publishes data of a sensor (RDF data using the SSN ontology)
     * with a certain id and which should be accessible at <http://opcua-ids-connector:8080/sensors/{sensorId}> so that
     * it can be directly invoked by other participants.
     */

    private Operation readSensorDataOperation;
    private Parameter sensorIdParam, sensorValuesParam;

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

        sensorIdParam = new InputParameterBuilder()
            .paramName("sensorId")
            .representation(intType)
            .build();
        return (InputParameter) sensorIdParam;
    }

    private OutputParameter createOutputParameter() throws ConstraintViolationException, MalformedURLException {
        Representation rdfSsnType = new RepresentationBuilder()
            .mediaType(IANAMediaType.APPLICATION_RDF_XML)
            .conformsToStandard(new URL("http://purl.oclc.org/NET/ssnx/ssn"))
            .build();

        sensorValuesParam = new OutputParameterBuilder()
            .representation(rdfSsnType)
            .build();
        return (OutputParameter) sensorValuesParam;
    }

    private ProtocolBinding createProtocolBinding() throws ConstraintViolationException {
        return new ProtocolBindingBuilder()
            .operationBindings(Arrays.asList(createOperationBinding()))
            .build();
    }

    // Specifies an URL (uriTemplate) to invoke the service
    private OperationBinding createOperationBinding() throws ConstraintViolationException {
        return new OperationHttpBindingBuilder()
            .boundOperation(readSensorDataOperation)
            .httpMethod(HttpMethod.HTTP_GET)
            .uriTemplate("http://opcua-ids-connector:8080/sensors/{sensorId}")
            .parameterBindings(Arrays.asList(createInputParamBinding(), createOutputParameterBinding()))
            .build();
    }

    // Binds the input parameter description to the invocation URL using the parameter's name "sensorId"
    private ParameterBinding createInputParamBinding() throws ConstraintViolationException {
        BindingApproach bindingApproach = new UriTemplateBindingApproachBuilder().build();

        return new ParameterBindingBuilder()
            .boundParameter(sensorIdParam)
            .bindingApproach(bindingApproach)
            .build();
    }

    // Binds the output parameter description to the HTTP response body of the operation.
    private ParameterBinding createOutputParameterBinding() throws ConstraintViolationException {
        BindingApproach bindingApproach = new HttpBodyBindingApproachBuilder().build();

        return new ParameterBindingBuilder()
            .boundParameter(sensorValuesParam)
            .bindingApproach(bindingApproach)
            .build();
    }
}
