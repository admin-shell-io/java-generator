package de.fraunhofer.iais.eis.demo;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
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
import java.util.GregorianCalendar;

/**
 * Created by christian on 08.02.17.
 */
public class Demo {

    public static void main(String[] args) throws ConstraintViolationException, MalformedURLException {
        Demo demo = new Demo();

        // create a data transfer between two connectors
        demo.createDataTransfer();

        // create objects for communicating with the broker
        demo.createBrokerRequests();

        // create a dataset description (metadata)
        demo.createDataset();

        // create a usage policy that can be attached to a data endpoint
        demo.createPolicy();

        // create a parameter that controls a service operation
        demo.createParameter();
    }

    private void createDataTransfer() throws ConstraintViolationException, MalformedURLException {
        DataTransfer transfer = new DataTransferBuilder()
                .sender("http://companyA.com/connector")
                .receiver("http://companyB.com/connector")
                .transferCreatedAt(new XMLGregorianCalendarImpl(new GregorianCalendar()))
                .build();
    }

    private void createBrokerRequests() throws ConstraintViolationException {
        new BrokerQueryRequestBuilder()
                .queryRequestAction(BrokerQueryRequestAction.GET)
                .queryScope(BrokerQueryMessageScope.ACTIVE)
                .messageContent("test")
                .build();
    }

    private void createDataset() throws ConstraintViolationException, MalformedURLException {
        Participant datasetCreator = new ParticipantBuilder()
                .name(ResourceFactory.createPlainLiteral("Historic data GmbH"))
                .build();

        new DatasetBuilder()
                .datasetTitle(ResourceFactory.createLangLiteral("Development of hop prices 1903-2015", "en"))
                .datasetDescription(ResourceFactory.createLangLiteral("Historic records, incomplete", "en"))
                .contentCreator(datasetCreator)
                .conformsTo(new URL("http://who.unitednations.org/datapublication/standards/prices"))
                .coversIndustry(ISICIndustry.GROWING_OF_BEVERAGE_CROPS)
                .licenseDocument(LicenseDocument.CC_BY_NC_ND_2_0)
                .build();
    }

    private void createPolicy() throws ConstraintViolationException {
        Read modifyAction = new ReadBuilder().build();

        // the permission to modify a certain endpoint
        Permission permission = new PermissionBuilder()
                .action(Arrays.asList(modifyAction))
                .build();

        UsagePolicy policy = new UsagePolicyBuilder()
                .permission(Arrays.asList(permission))
                .prohibition(Collections.emptyList())
                .build();

        System.out.println(policy.toRdf());
    }

    private void createParameter() throws MalformedURLException, ConstraintViolationException {
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
    }

}
