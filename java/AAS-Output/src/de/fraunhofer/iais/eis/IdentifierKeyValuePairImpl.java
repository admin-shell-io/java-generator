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

	"An IdentifierKeyValuePair describes a generic identifier as key-value pair."@en */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:IdentifierKeyValuePair")
public class IdentifierKeyValuePairImpl implements Serializable, IdentifierKeyValuePair {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@javax.validation.constraints.NotNull URI id;

	//List of all labels of this class
	@JsonIgnore
	java.util.List<TypedLiteral> label = Arrays.asList(new TypedLiteral("identifier key value pair", ""));
	//List of all comments of this class
	@JsonIgnore
	java.util.List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("An IdentifierKeyValuePair describes a generic identifier as key-value pair.", "en"));

	// all classes have a generic property array
	@JsonIgnore
	java.util.Map<String,Object> properties;

	// instance fields as derived from information model

	/**
	"has semantic ID"

	"Points to the Expression Semantic of the Submodels"@en

	"The semantic id might refer to an external information source, which explains the formulation of the submodel (for example an PDF if a standard)."@en
	*/
	@JsonAlias({"ids:semanticId", "semanticId"})
	 Reference _semanticId;


	/**
	"has IdentifierKeyValuePair.externalSubjectId"

	"The (external) subject the key belongs to or has meaning to."@en
	*/
	@NotNull@JsonAlias({"ids:externalSubjectId", "externalSubjectId"})
	 Reference _externalSubjectId;


	/**
	"has IdentifierKeyValuePair.key"

	"Key of the identifier."@en
	*/
	@NotNull@JsonAlias({"ids:key", "key"})
	 String _key;


	/**
	"has IdentifierKeyValuePair.value"

	"The value of the identifier with the corresponding key."@en
	*/
	@NotNull@JsonAlias({"ids:value", "value"})
	 String _value;


	// no manual construction
	IdentifierKeyValuePairImpl() {
		id = VocabUtil.getInstance().createRandomUrl("identifierKeyValuePair");
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
	@JsonProperty("ids:key")
	String getKey() {
		return _key;
	}

	final public void setKey (String _key_) {
		this._key = _key_;
	}

	final public 
	
	@NotNull
	@JsonProperty("ids:value")
	String getValue() {
		return _value;
	}

	final public void setValue (String _value_) {
		this._value = _value_;
	}

	final public 
	
	@NotNull
	@JsonProperty("ids:externalSubjectId")
	Reference getExternalSubjectId() {
		return _externalSubjectId;
	}

	final public void setExternalSubjectId (Reference _externalSubjectId_) {
		this._externalSubjectId = _externalSubjectId_;
	}

	final public 
	
	
	@JsonProperty("ids:semanticId")
	Reference getSemanticId() {
		return _semanticId;
	}

	final public void setSemanticId (Reference _semanticId_) {
		this._semanticId = _semanticId_;
	}
}
