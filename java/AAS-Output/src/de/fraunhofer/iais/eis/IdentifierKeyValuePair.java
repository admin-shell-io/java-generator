package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.*;
import de.fraunhofer.iais.eis.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.String;
import java.math.BigInteger;
import java.net.URL;
import java.net.URI;
import java.util.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.io.Serializable;

import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;

/**
	"identifier key value pair"

	"An IdentifierKeyValuePair describes a generic identifier as key-value pair."@en*/
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type")
@JsonSubTypes({
@JsonSubTypes.Type(value = IdentifierKeyValuePairImpl.class),})
public interface IdentifierKeyValuePair {

	// standard methods

	@JsonProperty("@id")
	@javax.validation.constraints.NotNull URI getId();
	java.util.List<TypedLiteral> getLabel();
	java.util.List<TypedLiteral> getComment();
	String toRdf();

	// getter and setter for generic property map
	public java.util.Map<String,Object> getProperties();
	public void setProperty(String property, Object value);

	// accessor methods as derived from information model
	/**
	"has IdentifierKeyValuePair.key"

	"Key of the identifier."@en
	*/
	
	@NotNull
	@JsonProperty("ids:key")
	String getKey();
	/**
	"has IdentifierKeyValuePair.value"

	"The value of the identifier with the corresponding key."@en
	*/
	
	@NotNull
	@JsonProperty("ids:value")
	String getValue();
	/**
	"has IdentifierKeyValuePair.externalSubjectId"

	"The (external) subject the key belongs to or has meaning to."@en
	*/
	
	@NotNull
	@JsonProperty("ids:externalSubjectId")
	Reference getExternalSubjectId();
}
