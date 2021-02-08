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

	"Certificate provided as BLOB."@en */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:BlobCertificate")
public class BlobCertificateImpl implements Serializable, BlobCertificate {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@javax.validation.constraints.NotNull URI id;

	//List of all labels of this class
	@JsonIgnore
	java.util.List<TypedLiteral> label = Arrays.asList(new TypedLiteral("Blob Certificate", ""));
	//List of all comments of this class
	@JsonIgnore
	java.util.List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("Certificate provided as BLOB.", "en"));

	// all classes have a generic property array
	@JsonIgnore
	java.util.Map<String,Object> properties;

	// instance fields as derived from information model

	/**
	"Blob Certificate"

	"Certificate as BLOB."@en
	*/
	@JsonAlias({"ids:blobCertificate", "blobCertificate"})
	 java.util.ArrayList<? extends Byte> _blobCertificate;


	/**
	"contains extension"

	"Extensions contained in the certificate."@en
	*/
	@JsonAlias({"ids:containedExtension", "containedExtension"})
	 java.util.ArrayList<? extends Reference> _containedExtension;


	/**
	"is last certificate"

	"Denotes whether this certificate is the certificated that fast added last."@en
	*/
	@JsonAlias({"ids:lastCertificate", "lastCertificate"})
	 java.util.ArrayList<? extends Boolean> _lastCertificate;


	/**
	"has policy administration point"

	"The access control administration policy point of the AAS."@en
	*/
	@NotNull@JsonAlias({"ids:policyAdministrationPoint", "policyAdministrationPoint"})
	 PolicyAdministrationPoint _policyAdministrationPoint;


	// no manual construction
	BlobCertificateImpl() {
		id = VocabUtil.getInstance().createRandomUrl("blobCertificate");
	}

	@JsonProperty("@id")
	final public URI getId() {
		return id;
	}

	public String toRdf() {
		return VocabUtil.getInstance().toRdf(this);
	}

	public java.util.List<TypedLiteral> getLabel() {
		return this.label;
	}

	public java.util.List<TypedLiteral> getComment() {
		return this.comment;
	}

	// getter and setter for generic property map
	@JsonAnyGetter
	public java.util.Map<String,Object> getProperties() {
		if (this.properties == null) return null;
		Iterator<String> iter = this.properties.keySet().iterator();
		java.util.Map<String,Object> resultset = new HashMap<String, Object>();
		while (iter.hasNext()) {
			String key = iter.next();
			resultset.put(key,urifyObjects(this.properties.get(key)));
		}
		return resultset ;
	}

	public Object urifyObjects(Object value) {
		if (value instanceof String && value.toString().startsWith("http")) {
			try {
				value = new URI(value.toString());
			} catch (Exception e) { /* do nothing */ }
		} else if (value instanceof ArrayList) {
			ArrayList<Object> result_array = new ArrayList<Object>();
			((ArrayList) value).forEach(x -> result_array.add(urifyObjects(x)));
			return result_array;
		} else if (value instanceof java.util.Map) {
			java.util.Map<String, Object> result_map = new HashMap<String, Object>();
			((java.util.Map) value).forEach((k,v) -> result_map.put(k.toString(), urifyObjects(v)));
			return result_map;
		}
		return value;
	}

	@JsonAnySetter
	public void setProperty(String property, Object value) {
	if (this.properties == null) this.properties = new java.util.HashMap<String,Object>();
	if (property.startsWith("@")) {return ;};
	this.properties.put(property, value) ;
	}
	// accessor method implementations as derived from information model

	final public 
	
	
	@JsonProperty("ids:blobCertificate")
	java.util.ArrayList<? extends Byte> getBlobCertificate() {
		return _blobCertificate;
	}

	final public void setBlobCertificate (java.util.ArrayList<? extends Byte> _blobCertificate_) {
		this._blobCertificate = _blobCertificate_;
	}

	final public 
	
	
	@JsonProperty("ids:containedExtension")
	java.util.ArrayList<? extends Reference> getContainedExtension() {
		return _containedExtension;
	}

	final public void setContainedExtension (java.util.ArrayList<? extends Reference> _containedExtension_) {
		this._containedExtension = _containedExtension_;
	}

	final public 
	
	
	@JsonProperty("ids:lastCertificate")
	java.util.ArrayList<? extends Boolean> getLastCertificate() {
		return _lastCertificate;
	}

	final public void setLastCertificate (java.util.ArrayList<? extends Boolean> _lastCertificate_) {
		this._lastCertificate = _lastCertificate_;
	}

	final public 
	
	@NotNull
	@JsonProperty("ids:policyAdministrationPoint")
	PolicyAdministrationPoint getPolicyAdministrationPoint() {
		return _policyAdministrationPoint;
	}

	final public void setPolicyAdministrationPoint (PolicyAdministrationPoint _policyAdministrationPoint_) {
		this._policyAdministrationPoint = _policyAdministrationPoint_;
	}
}
