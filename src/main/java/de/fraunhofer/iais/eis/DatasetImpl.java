package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

/* Dataset on the Industrial Dataspace. May be a data offering, a subset of a dataset that is in the state of being transfered or an aggregation of multiple other datasets. */
public class DatasetImpl implements Dataset {

	java.net.URL url;

	// instance fields as derived from vocabulary

	@org.hibernate.validator.constraints.URL String mediaType;

	@javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar creationDate;

	String format;

	String version;


	// no manual construction
	DatasetImpl() {
		url = VocabUtil.createRandomUrl("dataset");
	}

	@Override
	final public java.net.URL getId() {
		return url;
	}

	// accessor method implementations as derived from vocabulary

	final public @org.hibernate.validator.constraints.URL String getMediaType() {
		return mediaType;
	}
	

	final public @javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar getCreationDate() {
		return creationDate;
	}
	

	final public String getFormat() {
		return format;
	}
	

	final public String getVersion() {
		return version;
	}
	

}
