package de.fraunhofer.iais.eis.invoke;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import de.fraunhofer.iais.eis.Dataset;
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
        Dataset dataset = new DatasetImpl();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Dataset>> constraintViolations = validator.validate(dataset);
    }

}
