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
	"Administrative Information"

	"Every Identifiable may have administrative information. Administrative information includes for example  Information about the version of the element  Information about who created or who made the last change to the element  Information about the languages available in case the element contains text, for translating purposed also themmaster or default language may be definedIn the first version of the AAS metamodel only version information as defined by IEC 61360 is defined. In later versions additional attributes may be added."@en */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:AdministrativeInformation")
public class AdministrativeInformationImpl implements Serializable, AdministrativeInformation {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@javax.validation.constraints.NotNull URI id;

	//List of all labels of this class
	@JsonIgnore
	java.util.List<TypedLiteral> label = Arrays.asList(new TypedLiteral("Administrative Information", ""));
	//List of all comments of this class
	@JsonIgnore
	java.util.List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("Every Identifiable may have administrative information. Administrative information includes for example  Information about the version of the element  Information about who created or who made the last change to the element  Information about the languages available in case the element contains text, for translating purposed also themmaster or default language may be definedIn the first version of the AAS metamodel only version information as defined by IEC 61360 is defined. In later versions additional attributes may be added.", "en"));

	// all classes have a generic property array
	@JsonIgnore
	java.util.Map<String,Object> properties;

	// instance fields as derived from information model

	/**
	"has revision"

	"Revision of the element."@en
	*/
	@JsonAlias({"ids:revision", "revision"})
	 String _revision;


	/**
	"has version"

	"Version of the element."@en
	*/
	@JsonAlias({"ids:version", "version"})
	 String _version;


	/**
	"has Data Specification"

	"Global reference to the data specification template used by the element."@en
	*/
	@JsonAlias({"ids:dataSpecification", "dataSpecification"})
	 java.util.ArrayList<? extends Reference> _dataSpecification;


	// no manual construction
	AdministrativeInformationImpl() {
		id = VocabUtil.getInstance().createRandomUrl("administrativeInformation");
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
	
	
	@JsonProperty("ids:version")
	String getVersion() {
		return _version;
	}

	final public void setVersion (String _version_) {
		this._version = _version_;
	}

	final public 
	
	
	@JsonProperty("ids:revision")
	String getRevision() {
		return _revision;
	}

	final public void setRevision (String _revision_) {
		this._revision = _revision_;
	}

	final public 
	
	
	@JsonProperty("ids:dataSpecification")
	java.util.ArrayList<? extends Reference> getDataSpecification() {
		return _dataSpecification;
	}

	final public void setDataSpecification (java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this._dataSpecification = _dataSpecification_;
	}
}
