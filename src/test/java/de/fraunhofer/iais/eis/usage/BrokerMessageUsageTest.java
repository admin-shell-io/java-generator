package de.fraunhofer.iais.eis.usage;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import de.fraunhofer.iais.eis.util.VocabUtil;
import de.fraunhofer.iais.eis.general.TestUtil;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by christian on 22.05.17.
 */
public class BrokerMessageUsageTest {

    @Test
    public void brokerMessageSerialization() throws ConstraintViolationException, MalformedURLException {
        String brokerMessage = createBrokerDataRequest().toRdf();

        Model model = TestUtil.createModelFromRdf(brokerMessage);
        Resource transfer = model.createResource("http://example.org/brokerdatarequest/1");
        Property coveredEntityProperty = model.createProperty("http://industrialdataspace.org/2016/10/ids/core#coveredEntity");
        Property dataRequestActionProperty = model.createProperty("http://industrialdataspace.org/2016/10/ids/core#dataRequestAction");
        Property msgContentProperty = model.createProperty("http://industrialdataspace.org/2016/10/ids/core#messageContent");

        for (Property property : Arrays.asList(coveredEntityProperty, dataRequestActionProperty, msgContentProperty)) {
            Assert.assertTrue(model.listObjectsOfProperty(transfer, property).hasNext());
        }
    }

    @Test
    public void brokerMessageDeserialization() throws ConstraintViolationException, MalformedURLException {
        String brokerMessage = createBrokerDataRequest().toRdf();
        BrokerDataRequest brokerDataRequest = (BrokerDataRequest) VocabUtil.fromRdf(brokerMessage);

        Assert.assertEquals(brokerDataRequest.getDataRequestAction(), BrokerDataRequestAction.REGISTER);
        Assert.assertEquals(brokerDataRequest.getCoveredEntity(), EntityCoveredByDataRequest.DATA_ENDPOINT);
        Assert.assertFalse(brokerDataRequest.getMessageContent().isEmpty());

        DataEndpoint dataEndpoint = (DataEndpoint) VocabUtil.fromRdf(brokerDataRequest.getMessageContent());

        // test only a sample of all fields

        // "direct" properties of a data endpoint
        Assert.assertFalse(dataEndpoint.getEntityNames().isEmpty());
        Assert.assertNotNull(dataEndpoint.getProvidedBy());
        Assert.assertNotNull(dataEndpoint.getOffers());

        // format of the dataset the endpoint offers
        Assert.assertEquals(
            dataEndpoint.getOffers().getOperations().iterator().next().getOutputs().iterator().next().getRepresentation().getMediaType(),
            IANAMediaType.APPLICATION_ZIP);
    }

    private BrokerDataRequest createBrokerDataRequest() throws ConstraintViolationException, MalformedURLException {
        return new BrokerDataRequestBuilder(new URL("http://example.org/brokerdatarequest/1"))
            .dataRequestAction(BrokerDataRequestAction.REGISTER)
            .messageContent(createDataEndpoint().toRdf())
            .coveredEntity(EntityCoveredByDataRequest.DATA_ENDPOINT)
            .build();
    }

    private DataEndpoint createDataEndpoint() throws ConstraintViolationException, MalformedURLException {
        return new DataEndpointBuilder()
            .entityNames(Arrays.asList(new PlainLiteral("My Data Endpoint Name", "en")))
            .providedBy(new URL("http://companyA.com/ids/connector"))
            .offers(createDataService())
            .entityDescriptions(Arrays.asList(new PlainLiteral("desc1", "en"), new PlainLiteral("desc2")))
            .build();
    }

    private DataService createDataService() throws ConstraintViolationException {
        Operation operation = new ReadOperationBuilder()
            .opLabels(Arrays.asList(new PlainLiteral("label")))
            .outputs(Arrays.asList(createOutputParameter())).build();

        return new DataServiceBuilder()
            .operations(Arrays.asList(operation))
            .publishes(createDataAsset())
            .build();
    }

    private OutputParameter createOutputParameter() throws ConstraintViolationException {
        return new OutputParameterBuilder()
            .paramLabels(Arrays.asList(new PlainLiteral("whole dataset dump", "en")))
            .paramName("dump")
            .representation(createRepresentation())
            .build();
    }

    private Representation createRepresentation() throws ConstraintViolationException {
        return new RepresentationBuilder()
            .mediaType(IANAMediaType.APPLICATION_ZIP)
            .build();
    }

    private DataAsset createDataAsset() throws ConstraintViolationException {
        return new DataAssetBuilder()
            .entityNames(Arrays.asList(new PlainLiteral("Dataset short name", "en")))
            .build();
    }

    @Test
    public void brokerDataResponseSerialization() throws MalformedURLException, ConstraintViolationException {
        URL requestId = createBrokerDataRequest().getId();

        /*
        new BrokerDataResponseBuilder()
                .messageContent()
                .correlationId(requestId)
        */
    }

    @Test
    public void brokerQueryRequestSerialization() {

    }

    @Test
    public void brokerQueryResponseSerialization() {

    }

}
