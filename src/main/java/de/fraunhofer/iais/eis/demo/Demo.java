package de.fraunhofer.iais.eis.demo;

import de.fraunhofer.iais.eis.DataEndpointBuilder;
import de.fraunhofer.iais.eis.DataService;
import de.fraunhofer.iais.eis.DataServiceBuilder;
import de.fraunhofer.iais.eis.OperationBuilder;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;

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
