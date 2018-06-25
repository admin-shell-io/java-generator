package de.fraunhofer.iais.eis.stories;

import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.junit.Assert;
import org.junit.Test;
import de.fraunhofer.iais.eis.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

public class EchoServicePublicationTest {
    private final URL CONNECTOR_URL = new URL("http://companyA.com/IDS/connector1");
    private final URL PARTICIPANT_URL = new URL("http://industrialdataspace.org/participants/companyA");

    public EchoServicePublicationTest() throws MalformedURLException {}

    @Test
    public void createOffering() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        Assert.fail();
        /*
        Connector connector = describeConnectorWithDataOffering();
        String rdf = connector.toRdf();

        Connector deser = (Connector) VocabUtil.getInstance().fromRdf(rdf);
        Assert.assertNotNull(deser);
        */
    }

    private Connector describeConnectorWithDataOffering() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        // the starting point of the connector description
        return new ConnectorBuilder(CONNECTOR_URL)
                .contentResponsibility(PARTICIPANT_URL)
                .technicalResponsibility(PARTICIPANT_URL)
                .entityNames(Arrays.asList(new PlainLiteral("Official IDS Connector of companyA", "en")))

                // the DataAssets which are provided by the Connector
                .provides(Arrays.asList(describeEchoDataAsset()))

                .build();
    }

    private DataAsset describeEchoDataAsset() throws ConstraintViolationException, MalformedURLException, URISyntaxException {
        return null;
        /*
        return new DataAssetBuilder()
                .entityNames(Arrays.asList(new PlainLiteral("Endpoint providing my echo service", "en")))

                // a DataEndpoint defines a couple of Operations that may be invoked by the communication partner to receive the provided data
                .kinds(Arrays.asList(createUnspecifiedKind()))

                // the Interfaces to retrieve the DataAssets
                .retrievableBy(Arrays.asList(createServiceInterface()))

                .build();
                */
    }

    private Kind createUnspecifiedKind() throws ConstraintViolationException {
        return new ValueBuilder()
                .representations(Arrays.asList(createJsonRepresentation()))
                .build();
    }

    private Operation describeEchoOperation() throws ConstraintViolationException {
        // the echo operation is described as a read operation because there is no "underlying" data provided by the connector that it would change
        return new OperationBuilder()
                .opLabels(Arrays.asList(new PlainLiteral("Echo JSON")))
                .opDescriptions(Arrays.asList(new PlainLiteral("Basic echo service, just replays the input")))

                // the operation takes a JSON argument as input
                .inputs(Arrays.asList(createJsonInputParameter()))

                // the operation produces a JSON string
                .outputs(Arrays.asList(createJsonOutputParameter()))

                .build();
    }

    private InputParameter createJsonInputParameter() throws ConstraintViolationException {
        InputParameter param = new InputParameterBuilder()
                .paramName("jsonStr")
                .dataType(ParameterDataType.XSD_STRING)
                .build();
        return param;
    }

    private Representation createJsonRepresentation() throws ConstraintViolationException {
        return new RepresentationBuilder()
                .mediaType(IANAMediaType.APPLICATION_JSON)
                .build();
    }

    private ServiceInterface createServiceInterface() throws ConstraintViolationException {
        ApiDocument apiDocument = new ApiDocumentBuilder()
                .content("empty test document")
                .build();

        ProtocolBinding binding = new HttpProtocolBindingBuilder()
                .apiDocument(apiDocument)
                .build();

        return new ServiceInterfaceBuilder()
            .operation(describeEchoOperation())
//            .binding(binding)
            .build();
    }

    private OutputParameter createJsonOutputParameter() throws ConstraintViolationException {
        OutputParameter param = new OutputParameterBuilder()
                .dataType(ParameterDataType.XSD_STRING)
                .build();
        return param;
    }

}
