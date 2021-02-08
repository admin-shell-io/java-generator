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
	"Property"

	"A property is a data element that has a single value."@en */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:Property")
public class PropertyImpl implements Serializable, Property {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@javax.validation.constraints.NotNull URI id;

	//List of all labels of this class
	@JsonIgnore
	java.util.List<TypedLiteral> label = Arrays.asList(new TypedLiteral("Property", ""));
	//List of all comments of this class
	@JsonIgnore
	java.util.List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("A property is a data element that has a single value.", "en"));

	// all classes have a generic property array
	@JsonIgnore
	java.util.Map<String,Object> properties;

	// instance fields as derived from information model

	/**
	"has Data Specification"

	"Global reference to the data specification template used by the element."@en
	*/
	@JsonAlias({"ids:dataSpecification", "dataSpecification"})
	 java.util.ArrayList<? extends Reference> _dataSpecification;


	/**
	"has kind"

	"ModelingKind of the element: either type or instance."@en
	*/
	@JsonAlias({"ids:kind", "kind"})
	 ModelingKind _kind;


	/**
	"has semantic ID"

	"Points to the Expression Semantic of the Submodels"@en

	"The semantic id might refer to an external information source, which explains the formulation of the submodel (for example an PDF if a standard)."@en
	*/
	@JsonAlias({"ids:semanticId", "semanticId"})
	 Reference _semanticId;


	/**
	"has property category"

	"The following categories are defined for properties and multi-language properties: CONSTANT, PARAMETER, and VARIABLE."@en
	*/
	@JsonAlias({"ids:propertyCategory", "propertyCategory"})
	 java.util.ArrayList<? extends Category> _propertyCategory;


	/**
	"has property value"

	"The value of the property instance."@en
	*/
	@JsonAlias({"ids:value", "value"})
	 de.fraunhofer.iais.eis.util.TypedLiteral _value;


	/**
	"has property value id"

	"Reference to the global unique id of a coded value."@en
	*/
	@JsonAlias({"ids:valueId", "valueId"})
	 Reference _valueId;


	/**
	"has qualifier"

	"Additional qualification of a qualifiable element."@en
	*/
	@JsonAlias({"ids:qualifier", "qualifier"})
	 java.util.ArrayList<? extends Constraint> _qualifier;


	/**
	"has description"

	"Description or comments on the element. The description can be provided in several languages."@en
	*/
	@JsonAlias({"ids:description", "description"})
	 java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description;


	/**
	"has display name"

	"Display name. Can be provided in several languages."@en
	*/
	@JsonAlias({"ids:displayName", "displayName"})
	 de.fraunhofer.iais.eis.util.TypedLiteral _displayName;


	/**
	"has short id"

	"Identifying string of the element within its name space."@en
	*/
	@NotNull@JsonAlias({"ids:idShort", "idShort"})
	 String _idShort;


	/**
	"has parent"

	"Reference to the next referable parent element of the element."@en
	*/
	@JsonAlias({"ids:parent", "parent"})
	 URI _parent;


	/**
	"has referable category"

	"The category is a value that gives further meta information w.r.t. to the class of the element. It affects the expected existence of attributes and the applicability of constraints."@en
	*/
	@JsonAlias({"ids:referableCategory", "referableCategory"})
	 java.util.ArrayList<? extends String> _referableCategory;


	// no manual construction
	PropertyImpl() {
		id = VocabUtil.getInstance().createRandomUrl("property");
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
	
	
	@JsonProperty("ids:propertyCategory")
	java.util.ArrayList<? extends Category> getPropertyCategory() {
		return _propertyCategory;
	}

	final public void setPropertyCategory (java.util.ArrayList<? extends Category> _propertyCategory_) {
		this._propertyCategory = _propertyCategory_;
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
	
	
	@JsonProperty("ids:referableCategory")
	java.util.ArrayList<? extends String> getReferableCategory() {
		return _referableCategory;
	}

	final public void setReferableCategory (java.util.ArrayList<? extends String> _referableCategory_) {
		this._referableCategory = _referableCategory_;
	}

	final public 
	
	
	@JsonProperty("ids:description")
	java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> getDescription() {
		return _description;
	}

	final public void setDescription (java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this._description = _description_;
	}

	final public 
	
	
	@JsonProperty("ids:displayName")
	de.fraunhofer.iais.eis.util.TypedLiteral getDisplayName() {
		return _displayName;
	}

	final public void setDisplayName (de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this._displayName = _displayName_;
	}

	final public 
	
	@NotNull
	@JsonProperty("ids:idShort")
	String getIdShort() {
		return _idShort;
	}

	final public void setIdShort (String _idShort_) {
		this._idShort = _idShort_;
	}

	final public 
	
	
	@JsonProperty("ids:parent")
	URI getParent() {
		return _parent;
	}

	final public void setParent (URI _parent_) {
		this._parent = _parent_;
	}

	final public 
	
	
	@JsonProperty("ids:qualifier")
	java.util.ArrayList<? extends Constraint> getQualifier() {
		return _qualifier;
	}

	final public void setQualifier (java.util.ArrayList<? extends Constraint> _qualifier_) {
		this._qualifier = _qualifier_;
	}

	final public 
	
	
	@JsonProperty("ids:dataSpecification")
	java.util.ArrayList<? extends Reference> getDataSpecification() {
		return _dataSpecification;
	}

	final public void setDataSpecification (java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this._dataSpecification = _dataSpecification_;
	}

	final public 
	
	
	@JsonProperty("ids:kind")
	ModelingKind getKind() {
		return _kind;
	}

	final public void setKind (ModelingKind _kind_) {
		this._kind = _kind_;
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
