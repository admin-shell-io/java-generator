package de.fraunhofer.iais.eis.stories;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class MqttProtocolBindingTest {
    /**
     * todo: align with logistics use case
     * As a data owner I want to provide a service that (1) clients can subscribe to get information about sensor values
     * and (2) clients can publish their own observations for consumptions by other clients
     */

    private Operation readSensorDataOperation;

    @Test
    public void createEndpointWithProtocolBinding() throws ConstraintViolationException, MalformedURLException {
        DataEndpoint endpoint = createEndpoint();
        Assert.fail();
    }

    private DataEndpoint createEndpoint() throws ConstraintViolationException, MalformedURLException {
        return new DataEndpointBuilder()
            .offers(createOffering())
            .protocolBinding(createProtocolBinding())

            // mandatory fields
            .providedBy(new URL("http://industrialdataspace.org/participants/companyA"))
            .entityNames(Arrays.asList(new PlainLiteral("Sensor Connector Endpoint", "en")))
            .build();
    }

    private DataService createOffering() throws ConstraintViolationException, MalformedURLException {
        return new DataServiceBuilder()
            .operations(Arrays.asList(createSubscribeOperation()))
            .build();
    }

    private Operation createSubscribeOperation() throws ConstraintViolationException, MalformedURLException {
        // define a subscribe method to be notified on sensor values of a specific type of sensor
        return new SubscribeOperationBuilder()
                .inputs(Arrays.asList(createSubscriptionInputParameter()))
                .outputs(Arrays.asList(createSubscriptionOutputParameter()))
                .build();
    }

    private InputParameter createSubscriptionInputParameter() throws ConstraintViolationException, MalformedURLException {

        Representation stringIdentifier = new RepresentationBuilder()
            .dataType(ParameterDataType.XSD_STRING)
            .conformsToStandard(new URL("http://sensorcompany/sensorTypes"))
            .build();

        Parameter sensorIdParam = new InputParameterBuilder()
            .paramName("sensorType")
            .representation(stringIdentifier)
            .build();
        return (InputParameter) sensorIdParam;
    }

    private OutputParameter createSubscriptionOutputParameter() throws ConstraintViolationException, MalformedURLException {
        Representation rdfSsnType = new RepresentationBuilder()
            .mediaType(IANAMediaType.APPLICATION_RDF_XML)
            .conformsToStandard(new URL("http://purl.oclc.org/NET/ssnx/ssn"))
            .build();

        Parameter sensorValuesParam = new OutputParameterBuilder()
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
        return new OperationMqttBindingBuilder()
                .boundOperation()
        /*
        return new OperationHttpBindingBuilder()
            .boundOperation(readSensorDataOperation)
            .httpMethod(HTTPMethod.HTTP_GET)
            .uriTemplate("http://opcua-ids-connector:8080/sensors/{sensorId}")
            .parameterBindings(Arrays.asList(createInputParamBinding(), createOutputParameterBinding()))
            .build();

        subscribeSensorDataOperation
                .outputs() <- describes message payload, e.g. basic type or json

        publishSensorDataOperation
                .input() <- describes message payload, e.g. basic type or json

        new OperationMqttBindingBuilder()
                .boundOperation(subscribeSensorDataOperation)
                .brokerUrl("tcp://broker.mqttdashboard.com:1883")
                .topic("home/temp")


        new OperationMqttBindingBuilder()
                .boundOperation(publishSensorDataOperation)
                .brokerUrl("tcp://broker.mqttdashboard.com:1883")
                .topic("home/temp")
        */
        return null;
    }

    // Binds the input parameter description to the invocation URL using the parameter's name "sensorId"
    private ParameterBinding createInputParamBinding() throws ConstraintViolationException {
        /*
        BindingApproach bindingApproach = new UriTemplateBindingApproachBuilder().build();

        return new ParameterBindingBuilder()
            .boundParameter(sensorIdParam)
            .bindingApproach(bindingApproach)
            .build();
            */
        return null;
    }

    // Binds the output parameter description to the HTTP response body of the operation.
    private ParameterBinding createOutputParameterBinding() throws ConstraintViolationException {
        /*
        BindingApproach bindingApproach = new HttpResponseBodyBindingApproachBuilder().build();

        return new ParameterBindingBuilder()
            .boundParameter(sensorValuesParam)
            .bindingApproach(bindingApproach)
            .build();
            */
        return null;
    }
}
