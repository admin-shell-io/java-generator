package de.fraunhofer.iais.eis;

/* Dataset on the Industrial Dataspace. May be a data offering, a subset of a dataset that is in the state of being transfered or an aggregation of multiple other datasets. */

@de.fhg.iais.jrdfb.annotation.RdfType("http://industrialdataspace.org/2016/10/idsv/core#Dataset")
public interface Dataset {

	// standard methods

	@de.fhg.iais.jrdfb.annotation.RdfId
	@javax.validation.constraints.NotNull java.net.URL getId();

	// accessor methods as derived from vocabulary

	@de.fhg.iais.jrdfb.annotation.RdfProperty("http://industrialdataspace.org/2016/10/idsv/core#mediaType")
	@org.hibernate.validator.constraints.URL String getMediaType();

	@de.fhg.iais.jrdfb.annotation.RdfProperty("http://industrialdataspace.org/2016/10/idsv/core#creationDate")
	@javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar getCreationDate();

	@de.fhg.iais.jrdfb.annotation.RdfProperty("http://industrialdataspace.org/2016/10/idsv/core#format")
	String getFormat();

	@de.fhg.iais.jrdfb.annotation.RdfProperty("http://industrialdataspace.org/2016/10/idsv/core#version")
	String getVersion();
}
