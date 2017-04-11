package de.fraunhofer.iais.eis.demo;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.Currency;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.ResourceFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Created by christian on 08.02.17.
 */
public class Demo {

    public static void main(String[] args) throws ConstraintViolationException, MalformedURLException, DatatypeConfigurationException {
        Demo demo = new Demo();

        demo.objectCreation();
        //demo.objectSerialization();
        demo.objectDeserialization();
    }

    private void objectCreation() throws MalformedURLException, ConstraintViolationException, DatatypeConfigurationException {
        // create a data transfer between two connectors
        createDataTransfer();

        // create objects for communicating with the broker
        createBrokerRequests();

        // describe a data assed
        createDataAsset();

        // create a data endpoint description
        createDataEndpoint();
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

    private DataAsset createDataAsset() throws ConstraintViolationException, MalformedURLException {
        GeoPoint frankfurt = new GeoPointBuilder().latitude(50.1156f).longitude(8.70314f).build();

        Instant beginning = new InstantBuilder().inXSDDateTime(new XMLGregorianCalendarImpl(new GregorianCalendar())).build();
        Instant end = new InstantBuilder().inXSDDateTime(new XMLGregorianCalendarImpl(new GregorianCalendar())).build();

        Interval interval = new IntervalBuilder()
                .beginning(beginning)
                .end(end)
                .build();

        DataAsset dataAsset = new DataAssetBuilder()
                .dataAssetNames(Arrays.asList(ResourceFactory.createLangLiteral("Development of hop prices 1903-2015", "en")))
                .dataAssetDescriptions(Arrays.asList(ResourceFactory.createLangLiteral("Historic records, incomplete", "en")))
                .origin(new URL("http://example.org/company/"))
                .licenseDocument(LicenseDocument.CC_BY_NC_ND_2_0)
                .coversTemporal(Arrays.asList(interval))
                .coversSpatial(Arrays.asList(frankfurt))
                .build();

        return dataAsset;
    }

    private DataEndpoint createDataEndpoint() throws ConstraintViolationException, MalformedURLException {
        ServiceContract serviceContract = new ServiceContractBuilder().usagePolicy(createPolicy()).build();

        Operation operation = new OperationBuilder()
            .opLabel(ResourceFactory.createLangLiteral("retrieve dump operation", "en"))
            .outputs(Arrays.asList(createOutputParameter())).build();

        DataService dataService = new DataServiceBuilder()
            .coversIndustry(ISICIndustry.GROWING_OF_BEVERAGE_CROPS)
            .operations(Arrays.asList(operation))
            .usageConditions(Arrays.asList(serviceContract))
            .build();

        DataEndpoint dataEndpoint = new DataEndpointBuilder().offers(dataService).build();
        return dataEndpoint;
    }

    private OutputParameter createOutputParameter() throws ConstraintViolationException, MalformedURLException {

        Representation representation = new RepresentationBuilder()
                .conformsToStandard(new URL("http://example.org/GS1"))
                //.dataType(ParameterDataType.XSD_INT)
                .mediaType(IANAMediaType.APPLICATION_CDMI_OBJECT)
                .build();

        OutputParameter outputParameter = new OutputParameterBuilder()
                .paramLabels(Arrays.asList(ResourceFactory.createLangLiteral("whole dataset dump", "en")))
                .paramName("dataset")
                .paramDescription(ResourceFactory.createLangLiteral("default output parameter", "en"))

                .semanticType(new URL("http://european-standards.org/manufactoring/steel#steelgrade"))
                .representation(representation)
                .build();

        return outputParameter;
    }

    private UsagePolicy createPolicy() throws ConstraintViolationException {
        // the permission to read after paying a certain amount of money

        Price price = new PriceBuilder().currency(Currency.EUR).currencyValue(10.5f).build();

        Duty duty = new PaymentDutyBuilder()
                .action(Arrays.asList(new ReadBuilder().build()))
                .paymentModality(new PayPerUseBuilder().build())
                .price(price)
                .build();

        UsagePolicy policy = new UsagePolicyBuilder()
                .duty(Arrays.asList(duty))
                .build();

        return policy;
    }

    private void objectSerialization() throws MalformedURLException, ConstraintViolationException, DatatypeConfigurationException {
        System.out.println(createDataTransfer().toRdf());
    }

    private void objectDeserialization() throws MalformedURLException, ConstraintViolationException, DatatypeConfigurationException {
        /*
        DataTransfer transfer = createDataTransfer();
        String rdf = transfer.toRdf();
        DataTransfer obj = (DataTransfer) VocabUtil.fromRdf(rdf);
        */

        /*
        String rdf = createDataEndpoint().toRdf();
        System.out.println(rdf);
        Object obj = VocabUtil.fromRdf(rdf);
        */

        String rdf = createOutputParameter().toRdf();
        System.out.println(rdf);
        Object obj = VocabUtil.fromRdf(rdf);


        System.out.println("xx");
    }

}
