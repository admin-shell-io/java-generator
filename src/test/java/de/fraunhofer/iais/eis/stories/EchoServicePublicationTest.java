package de.fraunhofer.iais.eis.stories;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

public class EchoServicePublicationTest {
    private final URL CONNECTOR_URL = new URL("http://companyA.com/IDS/connector1");
    private final URL PARTICIPANT_URL = new URL("http://industrialdataspace.org/participants/companyA");

    private URL jsonInputParam, jsonOutputParam;

    public EchoServicePublicationTest() throws MalformedURLException {}

    @Test
    public void createOffering() throws DatatypeConfigurationException, ConstraintViolationException, MalformedURLException, URISyntaxException {
        Connector connector = describeConnectorWithDataOffering();
        String rdf = connector.toRdf();

        Connector deser = (Connector) VocabUtil.fromRdf(rdf);
        Assert.assertNotNull(deser);
    }

    private Connector describeConnectorWithDataOffering() throws DatatypeConfigurationException, ConstraintViolationException, MalformedURLException, URISyntaxException {
        // the starting point of the connector description
        return new ConnectorBuilder(CONNECTOR_URL)
                .owner(PARTICIPANT_URL)
                .operator(PARTICIPANT_URL)
                .entityNames(Arrays.asList(new PlainLiteral("Official IDS Connector of companyA", "en")))

                // the DataEndpoints which are provided by the Connector
                .provides(Arrays.asList(describeEchoEndpoint()))
                .build();
    }

    private DataEndpoint describeEchoEndpoint() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        return new DataEndpointBuilder()
                .entityNames(Arrays.asList(new PlainLiteral("Endpoint providing my echo service", "en")))

                // a DataEndpoint defines a couple of Operations that may be invoked by the communication partner to receive the provided data
                .operations(Arrays.asList(describeEchoOperation()))

                .build();
    }

    private Operation describeEchoOperation() throws ConstraintViolationException {
        // the echo operation is described as a read operation because there is no "underlying" data provided by the connector that it would change
        return new ReadOperationBuilder()
                .opLabels(Arrays.asList(new PlainLiteral("Echo JSON")))
                .opDescriptions(Arrays.asList(new PlainLiteral("Basic echo service, just replays the input")))

                // the operation takes a JSON argument as input
                .inputs(Arrays.asList(createJsonInputParameter()))

                // the operation produces a JSON string
                .outputs(Arrays.asList(createJsonOutputParameter()))

                // here we describe the binding, i.e. how the 2 parameters above are actually invoked using a specific protocol
                .bindings(Arrays.asList(createEchoOperationBinding()))
                .build();
    }

    private InputParameter createJsonInputParameter() throws ConstraintViolationException {
        InputParameter param = new InputParameterBuilder()
                .paramName("jsonStr")

                // each parameter may have a certain kind of representation, in that case a JSON String
                .representation(createJsonRepresentation())
                .build();

        jsonInputParam = param.getId();
        return param;
    }

    private Representation createJsonRepresentation() throws ConstraintViolationException {
        return new RepresentationBuilder()
                .mediaType(IANAMediaType.APPLICATION_JSON)
                .dataType(ParameterDataType.XSD_STRING)
                .build();
    }

    private OutputParameter createJsonOutputParameter() throws ConstraintViolationException {
        // since this is an echo service, the output parameter has the same representation than the input parameter
        OutputParameter param = new OutputParameterBuilder().representation(createJsonRepresentation()).build();
        jsonOutputParam = param.getId();
        return param;
    }

    private OperationBinding createEchoOperationBinding() throws ConstraintViolationException {
        return new OperationHttpBindingBuilder()
                // the HTTP method that must be used to send the request
                .httpMethod(HTTPMethod.HTTP_POST)

                // we need two bindings, one for the input, one for the output
                .parameterBindings(Arrays.asList(createInputParameterBinding(), createOutputParameterBinding()))
                .build();
    }

    private ParameterBinding createInputParameterBinding() throws ConstraintViolationException {
        return new ParameterBindingBuilder()
                // the input parameter should be transfered in the request body
                .bindingApproach(new HttpRequestBodyBindingApproachBuilder().build())

                // here we refer to the actual parameter that is bound
                .boundParameter(jsonInputParam)
                .build();
    }

    private ParameterBinding createOutputParameterBinding() throws ConstraintViolationException {
        return new ParameterBindingBuilder()
                // the output parameter should be sent back in the response body
                .bindingApproach(new HttpResponseBodyBindingApproachBuilder().build())

                // here again the reference to the parameter, not really elegant and will be reconsidered in future infomodel versions
                .boundParameter(jsonOutputParam)
                .build();
    }

}
