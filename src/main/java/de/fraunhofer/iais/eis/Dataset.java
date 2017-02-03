package de.fraunhofer.iais.eis;

/* Dataset on the Industrial Dataspace. May be a data offering, a subset of a dataset that is in the state of being transfered or an aggregation of multiple other datasets. */
public interface Dataset {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

	@org.hibernate.validator.constraints.URL String getMediaType();
	void setMediaType(@org.hibernate.validator.constraints.URL String mediaType);
	

	@javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar getCreationDate();
	void setCreationDate(@javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar creationDate);
	

	String getFormat();
	void setFormat(String format);
	

	String getVersion();
	void setVersion(String version);
	
}
