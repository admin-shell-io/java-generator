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
	"Extensions"

	"Single extension of an element."@en */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:Extension")
public class ExtensionImpl implements Serializable, Extension {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@javax.validation.constraints.NotNull URI id;

	//List of all labels of this class
	@JsonIgnore
	java.util.List<TypedLiteral> label = Arrays.asList(new TypedLiteral("Extensions", ""));
	//List of all comments of this class
	@JsonIgnore
	java.util.List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("Single extension of an element.", "en"));

	// all classes have a generic property array
	@JsonIgnore
	java.util.Map<String,Object> properties;

	// instance fields as derived from information model

	/**
	"has extension name"

	"An extension of the element."@en
	*/
	@JsonAlias({"ids:name", "name"})
	 java.util.ArrayList<? extends String> _name;


	/**
	"has extension reference to"

	"Reference to an element the extension refers to."@en
	*/
	@JsonAlias({"ids:refersTo", "refersTo"})
	 java.util.ArrayList<? extends Reference> _refersTo;


	/**
	"has extension value"

	"Value of the extension."@en
	*/
	@JsonAlias({"ids:value", "value"})
	 java.util.ArrayList<? extends String> _value;


	/**
	"has extension value type"

	"Type of the value of the extension."@en
	*/
	@JsonAlias({"ids:valueType", "valueType"})
	 java.util.ArrayList<? extends String> _valueType;


	/**
	"has semantic ID"

	"Points to the Expression Semantic of the Submodels"@en

	"The semantic id might refer to an external information source, which explains the formulation of the submodel (for example an PDF if a standard)."@en
	*/
	@JsonAlias({"ids:semanticId", "semanticId"})
	 Reference _semanticId;


	// no manual construction
	ExtensionImpl() {
		id = VocabUtil.getInstance().createRandomUrl("extension");
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
	
	
	@JsonProperty("ids:name")
	java.util.ArrayList<? extends String> getName() {
		return _name;
	}

	final public void setName (java.util.ArrayList<? extends String> _name_) {
		this._name = _name_;
	}

	final public 
	
	
	@JsonProperty("ids:valueType")
	java.util.ArrayList<? extends String> getValueType() {
		return _valueType;
	}

	final public void setValueType (java.util.ArrayList<? extends String> _valueType_) {
		this._valueType = _valueType_;
	}

	final public 
	
	
	@JsonProperty("ids:value")
	java.util.ArrayList<? extends String> getValue() {
		return _value;
	}

	final public void setValue (java.util.ArrayList<? extends String> _value_) {
		this._value = _value_;
	}

	final public 
	
	
	@JsonProperty("ids:refersTo")
	java.util.ArrayList<? extends Reference> getRefersTo() {
		return _refersTo;
	}

	final public void setRefersTo (java.util.ArrayList<? extends Reference> _refersTo_) {
		this._refersTo = _refersTo_;
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
