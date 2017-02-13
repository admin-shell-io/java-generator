package de.fraunhofer.iais.eis.demo;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import org.apache.jena.graph.impl.LiteralLabel;
import org.apache.jena.graph.impl.LiteralLabelFactory;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.impl.LiteralImpl;

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
    }

    public Demo() throws ConstraintViolationException {
        Literal label = ResourceFactory.createLangLiteral("somelabel", "en");
        Parameter param = new ParameterBuilder().paramLabel(label).paramName("huhu").dataType(ParameterDataType.XSD_INT).build();
        param.toRdf();

        //new OperationBuilder().input()

        //DataService dataService = new DataServiceBuilder().build();

        //new DataEndpointBuilder().offers(dataService).build();

        //new DatasetBuilder().coversIndustry(ISICIndustry.GROWING_OF_BEVERAGE_CROPS);

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
