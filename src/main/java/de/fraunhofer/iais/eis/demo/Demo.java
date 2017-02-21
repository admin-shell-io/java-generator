package de.fraunhofer.iais.eis.demo;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.ResourceFactory;

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

        demo.objectCreation();
        demo.objectSerialization();
        demo.objectDeserialization();
    }

    private void objectCreation() throws MalformedURLException, ConstraintViolationException {
        // create a data transfer between two connectors
        createDataTransfer();

        // create objects for communicating with the broker
        createBrokerRequests();

        // create a dataset description (metadata)
        createDataset();

        // create a usage policy that can be attached to a data endpoint
        createPolicy();

        // create a parameter that controls a service operation
        createParameter();
    }

    private DataTransfer createDataTransfer() throws ConstraintViolationException, MalformedURLException {
        // note here that sender and receiver are checked to be valid URLs by the build() method

        DataTransfer transfer = new DataTransferBuilder()
                .sender(new URL("http://companyA.com/connector"))
                .receiver(new URL("http://companyB.com/connector"))
                .transferCreatedAt(new XMLGregorianCalendarImpl(new GregorianCalendar()))
                .build();
        return transfer;
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

    private UsagePolicy createPolicy() throws ConstraintViolationException {
        Read modifyAction = new ReadBuilder().build();

        // the permission to modify a certain endpoint
        Permission permission = new PermissionBuilder()
                .action(Arrays.asList(modifyAction))
                .build();

        UsagePolicy policy = new UsagePolicyBuilder()
                .permission(Arrays.asList(permission))
                .prohibition(Collections.emptyList())
                .build();
        return policy;
    }

    private Parameter createParameter() throws MalformedURLException, ConstraintViolationException {
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
        return param;
    }

    private void objectSerialization() throws MalformedURLException, ConstraintViolationException {
        DataTransfer transfer = createDataTransfer();
        System.out.println(transfer.toRdf());
    }

    private void objectDeserialization() throws MalformedURLException, ConstraintViolationException {
        DataTransfer transfer = createDataTransfer();
        String rdf = transfer.toRdf();
        DataTransfer obj = (DataTransfer) VocabUtil.fromRdf(rdf);
    }

}
