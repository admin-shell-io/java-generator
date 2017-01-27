package de.fraunhofer.iais.eis.handcrafted.impl;

import de.fraunhofer.iais.eis.handcrafted.Dataset;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Set;

/**
 * Created by christian on 19.01.17.
 */
public class DatasetBuilder {

    private Dataset dataset;

    public DatasetBuilder() {
        dataset = new DatasetImpl();
    }

    public DatasetBuilder creationDate(XMLGregorianCalendar creationDate) {
        dataset.setCreationDate(creationDate);
        return this;
    }

    public DatasetBuilder version(String version) {
        dataset.setVersion(version);
        return this;
    }

    public DatasetBuilder format(String format) {
        dataset.setFormat(format);
        return this;
    }

    public DatasetBuilder mediaType(String mediaType) {
        dataset.setMediaType(mediaType);
        return this;
    }

    public Dataset build() throws ConstraintViolationException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Dataset>> constraintViolations = validator.validate(dataset);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException();
        }
        dataset.setReadOnly();
        return dataset;
    }

}
