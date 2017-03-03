package de.fraunhofer.iais.eis.demo;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.ResourceFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;

/**
 * Created by christian on 08.02.17.
 */
public class Demo {

    public static void main(String[] args) throws ConstraintViolationException, MalformedURLException, DatatypeConfigurationException {
        Demo demo = new Demo();

        demo.objectCreation();
        demo.objectSerialization();
        demo.objectDeserialization();
    }

    private void objectCreation() throws MalformedURLException, ConstraintViolationException, DatatypeConfigurationException {
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

    private DataTransfer createDataTransfer() throws ConstraintViolationException, MalformedURLException, DatatypeConfigurationException {
        // note here that sender and receiver are checked to be valid URLs by the build() method

        DataTransfer transfer = new DataTransferBuilder()
                .sender(new URL("http://companyA.com/connector"))
                .receiver(new URL("http://companyB.com/connector"))
                .transferCreatedAt(new XMLGregorianCalendarImpl(new GregorianCalendar()))
                .build();
        return transfer;
    }

    private void createBrokerRequests() throws ConstraintViolationException {
        BrokerQueryRequest request = new BrokerQueryRequestBuilder()
                .queryRequestAction(BrokerQueryRequestAction.GET)
                .queryScope(BrokerQueryMessageScope.ACTIVE)
                .messageContent("test")
                .build();
    }

    private void createDataset() throws ConstraintViolationException, MalformedURLException {
        GeoPoint zooOfFrankfurt = new GeoPointBuilder().latitude(50.1156f).longitude(8.70314f).build();

        Instant beginning = new InstantBuilder().inXSDDateTime(new XMLGregorianCalendarImpl(new GregorianCalendar())).build();
        Instant end = new InstantBuilder().inXSDDateTime(new XMLGregorianCalendarImpl(new GregorianCalendar())).build();

        Interval interval = new IntervalBuilder()
                .beginning(beginning)
                .end(end)
                .build();

        new DatasetBuilder()
                .datasetTitle(Arrays.asList(ResourceFactory.createLangLiteral("Development of hop prices 1903-2015", "en")))
                .datasetDescription(Arrays.asList(ResourceFactory.createLangLiteral("Historic records, incomplete", "en")))
                .contentCreator(new URL("http://example.org/company/"))
                .conformsTo(new URL("http://who.unitednations.org/datapublication/standards/prices"))
                .coversIndustry(ISICIndustry.GROWING_OF_BEVERAGE_CROPS)
                .licenseDocument(LicenseDocument.CC_BY_NC_ND_2_0)
                .coversTemporal(Arrays.asList(interval))
                .coversSpatial(Arrays.asList(zooOfFrankfurt))
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
        Literal description = ResourceFactory.createLangLiteral("parameter description", "en");

        Parameter param = new ParameterBuilder()
                .paramLabel(Arrays.asList(germanLabel, englishLabel))
                .paramName("qualityType")
                .paramDescription(description)
                .dataType(ParameterDataType.XSD_STRING)
                .semanticType(new URL("http://european-standards.org/manufactoring/steel#steelgrade"))
                .paramMediaType(IANAMediaType.APPLICATION_CDMI_OBJECT)
                .paramDescription(ResourceFactory.createLangLiteral("steel quality quality according to european standard", "en"))
                .build();

        System.out.println(param.toRdf());

        return param;
    }

    private void objectSerialization() throws MalformedURLException, ConstraintViolationException, DatatypeConfigurationException {
        DataTransfer transfer = createDataTransfer();
        System.out.println(transfer.toRdf());
    }

    private void objectDeserialization() throws MalformedURLException, ConstraintViolationException, DatatypeConfigurationException {
        DataTransfer transfer = createDataTransfer();
        String rdf = transfer.toRdf();
        System.out.println(rdf);

        // does not work so far, fix in progress
        //DataTransfer obj = (DataTransfer) VocabUtil.fromRdf(rdf);
    }

}
