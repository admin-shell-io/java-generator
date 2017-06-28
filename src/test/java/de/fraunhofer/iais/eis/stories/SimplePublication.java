package de.fraunhofer.iais.eis.stories;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class SimplePublication {
    /** As an IDS participant I want to advertise the fact that I can provide xml data of the company's revenue development
     *
     *  To do this, the participant has to describe his connector, the data it provides, and in what way (format) it is provided.
     *  This test illustrates this description process by making use of the Java convenience classes of the IDS Information Model.
     *
     *  Not covered by this test:
     *  - The connector description returned by describeConnectorWithDataOffering() is transferred to the Broker
     *
     *  Not relevant for this test, but important for the intagration scenario:
     *  - The final URLs in this class SHOULD be resolvable. Reasons:
     *      - the Connector will provide the information assembled here using a "self-disclosure" service so that no Broker is required for communication
     *      - each data transfer on the IDS holds information about the origin/destination of a transfer, referencing the involved endpoint URIs. When dereferencing
     *        these URIs it is therefore possible to find out the container that hosts the endpoint, the participant that owns the container,...
     * */

    // these SHOULD be resolvable
    private final URL CONNECTOR_URL = new URL("http://companyA.com/IDS/connector1");
    private final URL DATA_ENDPOINT_URL = new URL("http://industrialdataspace.org/connector1/endpoint1");
    private final URL PARTICIPANT_URL = new URL("http://industrialdataspace.org/participants/companyA");

    public SimplePublication() throws MalformedURLException {}

    @Test
    public void createOffering() throws DatatypeConfigurationException, ConstraintViolationException, MalformedURLException {
        Connector connector = describeConnectorWithDataOffering();
        String rdf = connector.toRdf();

        Connector deser = (Connector) VocabUtil.fromRdf(rdf);
        Assert.assertNotNull(deser);
    }

    private Connector describeConnectorWithDataOffering() throws DatatypeConfigurationException, ConstraintViolationException, MalformedURLException {
        return new ConnectorBuilder(CONNECTOR_URL)
                .owner(PARTICIPANT_URL)
                .operator(PARTICIPANT_URL)
                .generationActivity(describeConnectorCreation())
                .entityNames(Arrays.asList(new PlainLiteral("Official IDS Connector of companyA", "en")))
                .provides(Arrays.asList(describeDataEndpoint()))
                .build();
    }

    private CreationActivity describeConnectorCreation() throws DatatypeConfigurationException, ConstraintViolationException {
        return new CreationActivityBuilder()
                .startedAt(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()))
                .startedBy(PARTICIPANT_URL)
                .build();
    }

    private DataEndpoint describeDataEndpoint() throws ConstraintViolationException, MalformedURLException {
        return new DataEndpointBuilder(DATA_ENDPOINT_URL)
                .entityNames(Arrays.asList(new PlainLiteral("Endpoint providing my revenue dataset", "en")))
                .offers(describeDataService())
                .providedBy(CONNECTOR_URL)
                .build();
    }

    private DataService describeDataService() throws ConstraintViolationException, MalformedURLException {
        return new DataServiceBuilder()
                .operations(Arrays.asList(describeOperation()))
                .publishes(describeDataAsset())
                .build();
    }

    private DataAsset describeDataAsset() throws MalformedURLException, ConstraintViolationException {
        return new DataAssetBuilder()
                .entityNames(Arrays.asList(new PlainLiteral("Development of company revenue", "en")))
                .coversCategories(Arrays.asList(new URL("http://dbpedia.org/resource/Category:Finance")))
                .build();
    }

    private Operation describeOperation() throws ConstraintViolationException {
        return new ReadOperationBuilder()
                .opLabels(Arrays.asList(new PlainLiteral("Retrieve the whole dataset", "en")))
                .outputs(Arrays.asList(describeOutput()))
                .build();
    }

    private OutputParameter describeOutput() throws ConstraintViolationException {
        return new OutputParameterBuilder()
                .representation(describeRepresentation())
                .build();
    }

    private Representation describeRepresentation() throws ConstraintViolationException {
        return new RepresentationBuilder()
                .mediaType(IANAMediaType.APPLICATION_XML)
                .build();
    }

}
