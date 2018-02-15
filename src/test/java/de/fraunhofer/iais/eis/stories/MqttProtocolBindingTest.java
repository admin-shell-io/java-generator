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
import java.net.URL;
import java.util.Arrays;

public class MqttProtocolBindingTest {
    /**
     * As a data owner I want to provide a service that (1) clients can subscribe to get information about sensor values
     * and (2) clients can publish their own observations for consumptions by other clients
     */

    private Operation subscribeSensorDataOperation;
    private Parameter subscriptionOutputParam;

    @Test
    public void createEndpointWithProtocolBinding() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        DataEndpoint endpoint = createEndpoint();
        String rdf = endpoint.toRdf();
        DataEndpoint deser = (DataEndpoint) VocabUtil.fromRdf(rdf);

        Assert.assertFalse(deser.getOperations().isEmpty());
        Assert.assertFalse(deser.getOperations().iterator().next().getBindings().isEmpty());

        OperationBinding opBinding = deser.getOperations().iterator().next().getBindings().iterator().next();
        Assert.assertTrue(opBinding instanceof OperationMqttBinding);
    }

    private DataEndpoint createEndpoint() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        return new DataEndpointBuilder()
            .operations(Arrays.asList(createSubscribeOperation()))

            // mandatory fields
            .providedBy(new URL("http://industrialdataspace.org/participants/companyA"))
            .entityNames(Arrays.asList(new PlainLiteral("Sensor Connector Endpoint", "en")))
            .build();
    }

    private Operation createSubscribeOperation() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        // define a subscribe method to be notified on sensor values of a specific type of sensor
        return new SubscribeOperationBuilder()
                .opLabels(Arrays.asList(new PlainLiteral("Subscription operation for data of a sensor of a certain type.", "en")))

                .inputs(Arrays.asList(createSubscriptionInputParameter()))
                .outputs(Arrays.asList(createSubscriptionOutputParameter()))
                .bindings(Arrays.asList(createOperationBinding()))
                .build();
    }

    private InputParameter createSubscriptionInputParameter() throws ConstraintViolationException, MalformedURLException, URISyntaxException {

        Representation stringIdentifier = new RepresentationBuilder()
            .dataType(ParameterDataType.XSD_STRING)
            .conformsToStandard(new URI("http://sensorcompany/sensorTypes"))
            .build();

        Parameter sensorIdParam = new InputParameterBuilder()
            .paramName("sensorType")
            .representation(stringIdentifier)
            .build();
        return (InputParameter) sensorIdParam;
    }

    private OutputParameter createSubscriptionOutputParameter() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        Representation rdfSsnType = new RepresentationBuilder()
            .mediaType(IANAMediaType.APPLICATION_RDF_XML)
            .conformsToStandard(new URI("http://purl.oclc.org/NET/ssnx/ssn"))
            .build();

        subscriptionOutputParam = new OutputParameterBuilder()
            .representation(rdfSsnType)
            .build();
        return (OutputParameter) subscriptionOutputParam;
    }


    private OperationBinding createOperationBinding() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        return new OperationMqttBindingBuilder()
            .mqttBrokerUri(new URI("tcp://www.ids-participant/connector/mqttbroker:1883"))
            .parameterBindings(Arrays.asList(createOutputParameterBinding()))
            .build();
    }

    private ParameterBinding createOutputParameterBinding() throws ConstraintViolationException {
        BindingApproach bindingApproach = new MqttParamControlledTopicBindingApproachBuilder()
                .mqttTopicName("topic/{sensorType}")
                .build();

        return new ParameterBindingBuilder()
            .bindingApproach(bindingApproach)
            .build();
    }
}
