package marshalling;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;

/**
 * Created by christian on 19.05.17.
 */
public class MarshalBeans {

    @Test
    public void participantHasProperties() throws MalformedURLException, ConstraintViolationException {
        String rdf = createParticipant().toRdf();
        //System.out.println(rdf);

        Model model = createModelFromRdf(rdf);
        Property descProperty = model.createProperty("http://industrialdataspace.org/2016/10/ids/core#entityDescription");
        Property nameProperty = model.createProperty("http://industrialdataspace.org/2016/10/ids/core#entityName");
        Resource participant = model.createResource("http://www.isst.fraunhofer.de");

        Assert.assertFalse(model.listObjectsOfProperty(participant, descProperty).toList().isEmpty());
        Assert.assertFalse(model.listObjectsOfProperty(participant, nameProperty).toList().isEmpty());
    }

    private Participant createParticipant() throws MalformedURLException, ConstraintViolationException {
        return new ParticipantBuilder(new URL("http://www.isst.fraunhofer.de"))
                .entityNames(Arrays.asList((new PlainLiteral("Fraunhofer ISST"))))
                .entityDescriptions(Arrays.asList(new PlainLiteral("Fraunhofer ISST - Dortmund - Germany")))
                .build();
    }

    @Test
    public void connectorHasProperties() throws MalformedURLException, ConstraintViolationException {
        Participant participant = createParticipant();

        Collection<URL> dataEndpoints = new ArrayList<>();
        dataEndpoints.add(new URL("http://www.isst.fraunhofer.de/Broker/EndpointBrokerQueryRequest"));
        dataEndpoints.add(new URL("http://www.isst.fraunhofer.de/Broker/EndpointBrokerDataRequest"));
        CreationActivityBuilder creationActivityBuilder = new CreationActivityBuilder();
        CreationActivity creationActivity = creationActivityBuilder
                .activityDescription(new PlainLiteral("Lorem ipsum."))
                .startedBy(participant.getId())
                .startedAt(new XMLGregorianCalendarImpl(new GregorianCalendar()))
                .endedBy(participant)
                .endedAt(new XMLGregorianCalendarImpl(new GregorianCalendar()))
                .build();
        ConnectorBuilder connectorBuilder = new ConnectorBuilder(new URL("http://www.isst.fraunhofer.de/Broker"))
                .operator(participant.getId())
                .maintainer(participant.getId())
                .owner(participant.getId())
                .generationActivity(creationActivity)
                .lifecycleActivities(Arrays.asList(creationActivity))
                .provides(dataEndpoints)
                .entityNames(Arrays.asList(new PlainLiteral("Broker")))
                .entityDescriptions(Arrays.asList((new PlainLiteral("Broker API implementation for demonstration.", "en"))));

        Connector connector = connectorBuilder.build();
        String rdf = connector.toRdf();
        //System.out.println(rdf);

        Model model = createModelFromRdf(rdf);
        Property operatorProperty = model.createProperty("http://industrialdataspace.org/2016/10/ids/core#operator");
        Property providesProperty = model.createProperty("http://industrialdataspace.org/2016/10/ids/core#provides");
        Resource broker = model.createResource("http://www.isst.fraunhofer.de/Broker");

        // test for some sample properties
        Assert.assertFalse(model.listObjectsOfProperty(broker, operatorProperty).toList().isEmpty());
        Assert.assertFalse(model.listObjectsOfProperty(broker, providesProperty).toList().isEmpty());
    }

    private Model createModelFromRdf(String rdfTTL) {
        Model model = ModelFactory.createDefaultModel();
        model.read(new ByteArrayInputStream(rdfTTL.getBytes()), null, "TURTLE");
        return model;
    }
}
