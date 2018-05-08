package de.fraunhofer.iais.eis.stories;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class HttpProtocolBindingTest {
    /**
     * As a data owner I want to provide a service that publishes data of a sensor (RDF data using the SSN ontology)
     * with a certain id and which should be accessible at <http://opcua-ids-connector:8080/sensors/{sensorId}> so that
     * it can be directly invoked by other participants.
     */

    private Operation readSensorDataOperation;
    private Parameter sensorIdParam, sensorValuesParam;

    @Test
    public void createEndpointWithProtocolBinding() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        DataEndpoint endpoint = createEndpoint();
        String rdf = endpoint.toRdf();

        DataEndpoint deser = (DataEndpoint) VocabUtil.fromRdf(rdf);
        Assert.assertNotNull(deser);

        // test correct mapping of input and output parameter

        // extract the param definitions
        Operation opDefinition = deser.getOperations().iterator().next();
        Parameter inputParam = opDefinition.getInputs().iterator().next();
        Parameter outputParam = opDefinition.getOutputs().iterator().next();

        // extract the mappings and ensure they refer to the respective parameter definition
        OperationBinding opBinding = opDefinition.getBindings().iterator().next();

        for (ParameterBinding parameterBinding : opBinding.getParameterBindings()) {
            Assert.assertNotNull(parameterBinding.getBindingApproach());
        }
    }

    private DataEndpoint createEndpoint() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        return new DataEndpointBuilder()
            .operations(Arrays.asList(createOperation()))

            // mandatory fields
            .entityNames(Arrays.asList(new PlainLiteral("Sensor Connector Endpoint", "en")))
            .build();
    }

    private Operation createOperation() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        readSensorDataOperation = new ReadOperationBuilder()
            .inputs(Arrays.asList(createInputParameter()))
            .outputs(Arrays.asList(createOutputParameter()))
            .bindings(Arrays.asList(createOperationBinding()))

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

    private OutputParameter createOutputParameter() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        Representation rdfSsnType = new RepresentationBuilder()
            .mediaType(IANAMediaType.APPLICATION_RDF_XML)
            .conformsToStandard(new URI("http://purl.oclc.org/NET/ssnx/ssn"))
            .build();

        sensorValuesParam = new OutputParameterBuilder()
            .representation(rdfSsnType)
            .build();
        return (OutputParameter) sensorValuesParam;
    }



    // Specifies an URL (uriTemplate) to invoke the service
    private OperationBinding createOperationBinding() throws ConstraintViolationException {
        return new OperationHttpBindingBuilder()
            .httpMethod(HTTPMethod.HTTP_GET)
            .urlTemplate("http://opcua-ids-connector:8080/sensors/{sensorId}")
            .parameterBindings(Arrays.asList(createInputParamBinding(), createOutputParameterBinding()))
            .build();
    }

    // Binds the input parameter description to the invocation URL using the parameter's name "sensorId"
    private ParameterBinding createInputParamBinding() throws ConstraintViolationException {
        BindingApproach bindingApproach = new HttpUrlTemplateBindingApproachBuilder().build();

        return new ParameterBindingBuilder()
            .boundParameter(sensorIdParam.getId())
            .bindingApproach(bindingApproach)
            .build();
    }

    // Binds the output parameter description to the HTTP response body of the operation.
    private ParameterBinding createOutputParameterBinding() throws ConstraintViolationException {
        BindingApproach bindingApproach = new HttpResponseBodyBindingApproachBuilder().build();

        return new ParameterBindingBuilder()
            .boundParameter(sensorValuesParam.getId())
            .bindingApproach(bindingApproach)
            .build();
    }
}
