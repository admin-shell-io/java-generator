package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class DatasetBuilder {

	private DatasetImpl dataset;

	public DatasetBuilder() {
		dataset = new DatasetImpl();
		dataset.url = VocabUtil.createRandomUrl("dataset");
	}

	public DatasetBuilder(@javax.validation.constraints.NotNull java.net.URL url) {
		this();
		dataset.url = url;
	}

	final public DatasetBuilder mediaType(@org.hibernate.validator.constraints.URL String mediaType) {
		dataset.mediaType = mediaType;
		return this;
	}
	

	final public DatasetBuilder creationDate(@javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar creationDate) {
		dataset.creationDate = creationDate;
		return this;
	}
	

	final public DatasetBuilder format(String format) {
		dataset.format = format;
		return this;
	}
	

	final public DatasetBuilder version(String version) {
		dataset.version = version;
		return this;
	}
	

	public final Dataset build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		creationHook(dataset);
		VocabUtil.validate(dataset);
		return dataset;
	}

	public void creationHook(Dataset dataset) throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
