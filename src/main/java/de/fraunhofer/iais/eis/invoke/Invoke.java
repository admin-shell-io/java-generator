package de.fraunhofer.iais.eis.invoke;

import de.fraunhofer.iais.eis.handcrafted.impl.ConstraintViolationException;
import de.fraunhofer.iais.eis.handcrafted.impl.DatasetBuilder;

/**
 * Created by christian on 19.01.17.
 */
public class Invoke {

    public static void main(String[] args) {
        DatasetBuilder datasetBuilder = new DatasetBuilder();
        try {
            datasetBuilder.creationDate(null).build();
        } catch (ConstraintViolationException e) {
            e.printStackTrace();
        }

    }

}
