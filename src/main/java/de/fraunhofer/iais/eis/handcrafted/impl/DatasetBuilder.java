package de.fraunhofer.iais.eis.handcrafted.impl;

import de.fraunhofer.iais.eis.handcrafted.Dataset;
import de.fraunhofer.iais.eis.util.VocabUtil;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by christian on 19.01.17.
 */
public class DatasetBuilder {

    private Dataset dataset;

    public DatasetBuilder() {
        dataset = new DatasetImpl();
    }

    public final DatasetBuilder creationDate(XMLGregorianCalendar creationDate) {
        dataset.setCreationDate(creationDate);
        return this;
    }

    public final DatasetBuilder version(String version) {
        dataset.setVersion(version);
        return this;
    }

    public final DatasetBuilder format(String format) {
        dataset.setFormat(format);
        return this;
    }

    public final DatasetBuilder mediaType(String mediaType) {
        dataset.setMediaType(mediaType);
        return this;
    }

    public final Dataset build() throws ConstraintViolationException {
        VocabUtil.validate(dataset);
        validationHook();

        dataset.setReadOnly();
        return dataset;
    }

    public void validationHook() throws ConstraintViolationException {
        // override me!
    }

}
