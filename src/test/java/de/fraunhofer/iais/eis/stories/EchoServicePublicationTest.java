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

    public EchoServicePublicationTest() throws MalformedURLException {}

    @Test
    public void createOffering() throws DatatypeConfigurationException, ConstraintViolationException, MalformedURLException, URISyntaxException {
        Connector connector = describeConnectorWithDataOffering();
        String rdf = connector.toRdf();

        Connector deser = (Connector) VocabUtil.fromRdf(rdf);
        Assert.assertNotNull(deser);
    }

    private Connector describeConnectorWithDataOffering() throws DatatypeConfigurationException, ConstraintViolationException, MalformedURLException, URISyntaxException {
        return new ConnectorBuilder(CONNECTOR_URL)
                .owner(PARTICIPANT_URL)
                .operator(PARTICIPANT_URL)
                .entityNames(Arrays.asList(new PlainLiteral("Official IDS Connector of companyA", "en")))
                .provides(Arrays.asList(describeEchoEndpoint1(), describeEchoEndpoint2()))
                .build();
    }

    private DataEndpoint describeEchoEndpoint1() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        return new DataEndpointBuilder()
                .entityNames(Arrays.asList(new PlainLiteral("Endpoint providing my revenue dataset", "en")))
                .operations(Arrays.asList(describeEchoOperation1()))
                .providedBy(CONNECTOR_URL)
                .build();
    }

    private DataEndpoint describeEchoEndpoint2() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        return null;
    }

    private Operation describeEchoOperation1() throws ConstraintViolationException {
        return new ReadOperationBuilder()
                .opLabels(Arrays.asList(new PlainLiteral("Echo JSON")))
                .opDescriptions(Arrays.asList(new PlainLiteral("Basic echo service, just replays the input")))
                .inputs(Arrays.asList(createJsonInputParameter()))
                .outputs(Arrays.asList(createJsonOutputParameter()))
                .bindings(Arrays.asList(createEchoOperationBinding()))
                .build();
    }

    private InputParameter createJsonInputParameter() throws ConstraintViolationException {
        return new InputParameterBuilder()
                .paramName("jsonStr")
                .representation(createJsonRepresentation())
                .build();
    }

    private Representation createJsonRepresentation() throws ConstraintViolationException {
        return new RepresentationBuilder()
                .mediaType(IANAMediaType.APPLICATION_JSON)
                .dataType(ParameterDataType.XSD_STRING)
                .build();
    }

    private OutputParameter createJsonOutputParameter() throws ConstraintViolationException {
        return new OutputParameterBuilder().representation(createJsonRepresentation()).build();
    }

    private OperationBinding createEchoOperationBinding() {
        //new OperationBindingBuilder().parameterBindings()
        return null;
    }

}
