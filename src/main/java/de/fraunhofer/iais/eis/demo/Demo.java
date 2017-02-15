package de.fraunhofer.iais.eis.demo;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import org.apache.jena.graph.impl.LiteralLabel;
import org.apache.jena.graph.impl.LiteralLabelFactory;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.impl.LiteralImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by christian on 08.02.17.
 */
public class Demo {

    public static void main(String[] args) {
        try {
            new Demo();
        }
        catch (ConstraintViolationException e) {
            e.printStackTrace();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public Demo() throws ConstraintViolationException, MalformedURLException {

        //todo: does not yet validate - data endpoint object can be obtained from backend system
        DataEndpoint permittedEndpoint = new DataEndpointBuilder().build();

        Read modifyAction = new ReadBuilder().build();

        // the permission to modify a certain endpoint
        Permission permission = new PermissionBuilder()
                .targetDataEndpoint(permittedEndpoint)
                .action(Arrays.asList(modifyAction))
            .build();

        UsagePolicy policy = new UsagePolicyBuilder()
                .permission(Arrays.asList(permission))
                .prohibition(Collections.emptyList())
            .build();

        System.out.println(policy.toRdf());

        //-----
        Literal germanLabel = ResourceFactory.createLangLiteral("Stahlgüte", "de");
        Literal englishLabel = ResourceFactory.createLangLiteral("steel quality", "en");

        Parameter param = new ParameterBuilder()
                .paramLabel(Arrays.asList(germanLabel, englishLabel))
                .paramName("qualityType")
                .dataType(ParameterDataType.XSD_STRING)
                .semanticType(new URL("http://european-standards.org/manufactoring/steel#steelgrade"))
                .paramMediaType(IANAMediaType.APPLICATION_CDMI_OBJECT)
                .paramDescription(ResourceFactory.createLangLiteral("steel quality quality according to european standard", "en"))
            .build();
        System.out.println(param.toRdf());

        /*
        Connector sourceConnector = new ConnectorBuilder().build();
        Connector targetConnector = new ConnectorBuilder().build();

        DataEndpoint sender = new DataEndpointBuilder().providedBy(sourceConnector).build();
        DataEndpoint receiver = new DataEndpointBuilder().providedBy(targetConnector).build();

        TransferredDataset builder = new TransferredDatasetBuilder()
            .sender(sender)
            .receiver(receiver)
            .creationDate(new XMLGregorianCalendarImpl(new GregorianCalendar()))
            .build();
            */
    }




}
