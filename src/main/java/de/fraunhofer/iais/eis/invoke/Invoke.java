package de.fraunhofer.iais.eis.invoke;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import de.fraunhofer.iais.eis.handcrafted.Dataset;
import de.fraunhofer.iais.eis.handcrafted.impl.ConstraintViolationException;
import de.fraunhofer.iais.eis.handcrafted.impl.DatasetBuilder;

/**
 * Created by christian on 19.01.17.
 */
public class Invoke {

    public static void main(String[] args) {
        DatasetBuilder datasetBuilder = new DatasetBuilder();
        try {
            Dataset ds = datasetBuilder.creationDate(null).build();
            //ds.setFormat("bla");
        } catch (ConstraintViolationException e) {
            e.printStackTrace();
        }

    }

}
