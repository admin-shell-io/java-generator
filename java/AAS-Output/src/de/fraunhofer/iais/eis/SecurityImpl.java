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
	"Security"

	"Container for security relevant information of the AAS."@en */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:Security")
public class SecurityImpl implements Serializable, Security {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@javax.validation.constraints.NotNull URI id;

	//List of all labels of this class
	@JsonIgnore
	java.util.List<TypedLiteral> label = Arrays.asList(new TypedLiteral("Security", ""));
	//List of all comments of this class
	@JsonIgnore
	java.util.List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("Container for security relevant information of the AAS.", "en"));

	// all classes have a generic property array
	@JsonIgnore
	java.util.Map<String,Object> properties;

	// instance fields as derived from information model

	/**
	"has access control policy points"

	"Access control policy points of the AAS."@en
	*/
	@NotNull@JsonAlias({"ids:accessControlPolicyPoints", "accessControlPolicyPoints"})
	 PolicyAdministrationPoint _accessControlPolicyPoints;


	/**
	"has certificate"

	"Certificates of the AAS."@en
	*/
	@JsonAlias({"ids:certificate", "certificate"})
	 java.util.ArrayList<? extends Certificate> _certificate;


	/**
	"has required certificate extension"

	"Certificate extensions as required by the AAS."@en
	*/
	@JsonAlias({"ids:requiredCertificateExtension", "requiredCertificateExtension"})
	 java.util.ArrayList<? extends Reference> _requiredCertificateExtension;


	// no manual construction
	SecurityImpl() {
		id = VocabUtil.getInstance().createRandomUrl("security");
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
	
	@NotNull
	@JsonProperty("ids:accessControlPolicyPoints")
	PolicyAdministrationPoint getAccessControlPolicyPoints() {
		return _accessControlPolicyPoints;
	}

	final public void setAccessControlPolicyPoints (PolicyAdministrationPoint _accessControlPolicyPoints_) {
		this._accessControlPolicyPoints = _accessControlPolicyPoints_;
	}

	final public 
	
	
	@JsonProperty("ids:certificate")
	java.util.ArrayList<? extends Certificate> getCertificate() {
		return _certificate;
	}

	final public void setCertificate (java.util.ArrayList<? extends Certificate> _certificate_) {
		this._certificate = _certificate_;
	}

	final public 
	
	
	@JsonProperty("ids:requiredCertificateExtension")
	java.util.ArrayList<? extends Reference> getRequiredCertificateExtension() {
		return _requiredCertificateExtension;
	}

	final public void setRequiredCertificateExtension (java.util.ArrayList<? extends Reference> _requiredCertificateExtension_) {
		this._requiredCertificateExtension = _requiredCertificateExtension_;
	}
}
