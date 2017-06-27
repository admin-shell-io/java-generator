package de.fraunhofer.iais.eis.stories;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
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
    /** As an IDS participant I want to advertise that I can provide xml data of the company's revenue development */

    // these SHOULD be resolvable
    private URL CONNECTOR_URL = new URL("http://companyA.com/IDS/connector1");
    private URL DATA_ENDPOINT_URL = new URL("http://industrialdataspace.org/connector1/endpoint1");
    private URL PARTICIPANT_URL = new URL("http://industrialdataspace.org/participants/companyA");

    public SimplePublication() throws MalformedURLException {
    }

    @Test
    public void createDescription() throws DatatypeConfigurationException, ConstraintViolationException, MalformedURLException {
        // 1. create endpoint description

        // 1.1 describe service

        // 1.1.1.2 describe output parameter representation
        Representation representation = new RepresentationBuilder()
                .mediaType(IANAMediaType.APPLICATION_XML)
                .build();

        // 1.1.1 describe output parameter
        OutputParameter outputParam = new OutputParameterBuilder()
                .representation(representation)
                .build();


        // 1.1.1.1 describe operation
        Operation operation = new ReadOperationBuilder()
                .opLabels(Arrays.asList(new PlainLiteral("Retrieve the whole dataset", "en")))
                .outputs(Arrays.asList(outputParam))
                .build();



        // 1.1.2 describe data asset
        DataAsset dataAsset = new DataAssetBuilder()
                .entityNames(Arrays.asList(new PlainLiteral("Development of company revenue", "en")))
                .coversCategories(Arrays.asList(new URL("http://dbpedia.org/resource/Category:Finance")))
                .build();

        DataService dataService = new DataServiceBuilder()
                .operations(Arrays.asList(operation))
                .publishes(dataAsset)
                .build();

        DataEndpoint dataEndpoint = new DataEndpointBuilder(DATA_ENDPOINT_URL)
                .entityNames(Arrays.asList(new PlainLiteral("Endpoint providing my special dataset", "en")))
                .offers(dataService)
                .providedBy(CONNECTOR_URL)
                .build();



        // 2. create and describe the connector

        // 2.1 create creation activity
        CreationActivity creationActivity = new CreationActivityBuilder()
                .startedAt(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()))
                .startedBy(PARTICIPANT_URL)
                .build();

        Connector connector = new ConnectorBuilder(CONNECTOR_URL)
                .owner(PARTICIPANT_URL)
                .operator(PARTICIPANT_URL)
                .generationActivity(creationActivity)
                .entityNames(Arrays.asList(new PlainLiteral("Official IDS Connector of companyA", "en")))
                .provides(Arrays.asList(dataEndpoint))
                .build();

        // 3. publish connector description to broker



        System.out.println(connector.toRdf());
        Assert.fail();
    }

}
