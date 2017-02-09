package de.fraunhofer.iais.eis.util.demo;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;

import java.util.GregorianCalendar;

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
        Connector sourceConnector = new ConnectorBuilder().build();
        Connector targetConnector = new ConnectorBuilder().build();

        DataEndpoint sender = new DataEndpointBuilder().providedBy(sourceConnector).build();
        DataEndpoint receiver = new DataEndpointBuilder().providedBy(targetConnector).build();

        TransferredDataset builder = new TransferredDatasetBuilder()
            .sender(sender)
            .receiver(receiver)
            .creationDate(new XMLGregorianCalendarImpl(new GregorianCalendar()))
            .build();
    }




}
