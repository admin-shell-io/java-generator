package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class DatasetBuilder {

	private Dataset dataset;

	public DatasetBuilder() {
		dataset = new DatasetImpl();
	}

	final public DatasetBuilder mediaType(@org.hibernate.validator.constraints.URL String mediaType) {
		dataset.setMediaType(mediaType);
		return this;
	}
	

	final public DatasetBuilder creationDate(@javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar creationDate) {
		dataset.setCreationDate(creationDate);
		return this;
	}
	

	final public DatasetBuilder format(String format) {
		dataset.setFormat(format);
		return this;
	}
	

	final public DatasetBuilder version(String version) {
		dataset.setVersion(version);
		return this;
	}
	


	public final Dataset build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(dataset);
		validationHook();
		dataset.setReadOnly();
		return dataset;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
