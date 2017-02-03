package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

/* Dataset on the Industrial Dataspace. May be a data offering, a subset of a dataset that is in the state of being transfered or an aggregation of multiple other datasets. */
public class DatasetImpl implements Dataset {

	private java.net.URL url;
	private boolean readOnly;

	// instance fields as derived from vocabulary

	private @org.hibernate.validator.constraints.URL String mediaType;

	private @javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar creationDate;

	private String format;

	private String version;


	// no manual construction
	DatasetImpl() {
		url = VocabUtil.createRandomUrl("dataset");
	}

	@Override
	final public java.net.URL getId() {
		return url;
	}

	@Override
	final public void setId(@javax.validation.constraints.NotNull java.net.URL url) {
		assertModifiable();
		this.url = url;
	}

	final public void setReadOnly() {
		readOnly = true;
	}

	private void assertModifiable() {
		if (readOnly) {
			throw new RuntimeException("object has been built and cannot be modified anymore");
		}
	}

	// accessor method implementations as derived from vocabulary

	final public @org.hibernate.validator.constraints.URL String getMediaType() {
		return mediaType;
	}
	final public void setMediaType(@org.hibernate.validator.constraints.URL String mediaType) {
		assertModifiable();
		this.mediaType = mediaType;
	}
	

	final public @javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar getCreationDate() {
		return creationDate;
	}
	final public void setCreationDate(@javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar creationDate) {
		assertModifiable();
		this.creationDate = creationDate;
	}
	

	final public String getFormat() {
		return format;
	}
	final public void setFormat(String format) {
		assertModifiable();
		this.format = format;
	}
	

	final public String getVersion() {
		return version;
	}
	final public void setVersion(String version) {
		assertModifiable();
		this.version = version;
	}
	

}
