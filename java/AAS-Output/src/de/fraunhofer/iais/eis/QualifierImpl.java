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
	"Qualifier"

	"A qualifier is a type-value pair that makes additional statements w.r.t. the value of the element."@en */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:Qualifier")
public class QualifierImpl implements Serializable, Qualifier {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@javax.validation.constraints.NotNull URI id;

	//List of all labels of this class
	@JsonIgnore
	java.util.List<TypedLiteral> label = Arrays.asList(new TypedLiteral("Qualifier", ""));
	//List of all comments of this class
	@JsonIgnore
	java.util.List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("A qualifier is a type-value pair that makes additional statements w.r.t. the value of the element.", "en"));

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
	"has qualifier type"

	"The qualifier type describes the type of the qualifier that is applied to the element."@en
	*/
	@NotNull@JsonAlias({"ids:type", "type"})
	 String _type;


	/**
	"The qualifier value is the value of the qualifier."@en
	*/
	@JsonAlias({"ids:value", "value"})
	 de.fraunhofer.iais.eis.util.TypedLiteral _value;


	/**
	"Reference to the global unqiue id of a coded value."@en
	*/
	@JsonAlias({"ids:valueId", "valueId"})
	 Reference _valueId;


	// no manual construction
	QualifierImpl() {
		id = VocabUtil.getInstance().createRandomUrl("qualifier");
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
	@JsonProperty("ids:type")
	String getType() {
		return _type;
	}

	final public void setType (String _type_) {
		this._type = _type_;
	}

	final public 
	
	
	@JsonProperty("ids:value")
	de.fraunhofer.iais.eis.util.TypedLiteral getValue() {
		return _value;
	}

	final public void setValue (de.fraunhofer.iais.eis.util.TypedLiteral _value_) {
		this._value = _value_;
	}

	final public 
	
	
	@JsonProperty("ids:valueId")
	Reference getValueId() {
		return _valueId;
	}

	final public void setValueId (Reference _valueId_) {
		this._valueId = _valueId_;
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
