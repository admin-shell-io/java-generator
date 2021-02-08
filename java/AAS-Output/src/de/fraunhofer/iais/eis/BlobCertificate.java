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
	"Blob Certificate"

	"Certificate provided as BLOB."@en*/
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type")
@JsonSubTypes({
@JsonSubTypes.Type(value = BlobCertificateImpl.class),})
public interface BlobCertificate {

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
	"Blob Certificate"

	"Certificate as BLOB."@en
	*/
	
	
	@JsonProperty("ids:blobCertificate")
	java.util.ArrayList<? extends Byte> getBlobCertificate();
	/**
	"contains extension"

	"Extensions contained in the certificate."@en
	*/
	
	
	@JsonProperty("ids:containedExtension")
	java.util.ArrayList<? extends Reference> getContainedExtension();
	/**
	"is last certificate"

	"Denotes whether this certificate is the certificated that fast added last."@en
	*/
	
	
	@JsonProperty("ids:lastCertificate")
	java.util.ArrayList<? extends Boolean> getLastCertificate();
}
