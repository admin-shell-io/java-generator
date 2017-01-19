package de.fraunhofer.iais.eis.invoke;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import de.fraunhofer.iais.eis.Dataset;
import de.fraunhofer.iais.eis.impl.ConstraintViolationException;
import de.fraunhofer.iais.eis.impl.DatasetBuilder;
import de.fraunhofer.iais.eis.impl.DatasetImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

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
