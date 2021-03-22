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
	"Data Specification IEC 61360"

	"Data Specification Template for defining Property Descriptions conformant to IEC 61360."@en */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:DataSpecificationIEC61360")
public class DataSpecificationIEC61360Impl implements Serializable, DataSpecificationIEC61360 {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@javax.validation.constraints.NotNull URI id;

	//List of all labels of this class
	@JsonIgnore
	java.util.List<TypedLiteral> label = Arrays.asList(new TypedLiteral("Data Specification IEC 61360", ""));
	//List of all comments of this class
	@JsonIgnore
	java.util.List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("Data Specification Template for defining Property Descriptions conformant to IEC 61360.", "en"));

	// all classes have a generic property array
	@JsonIgnore
	java.util.Map<String,Object> properties;

	// instance fields as derived from information model

	/**
	"has datatype"
	*/
	@JsonAlias({"ids:dataType", "dataType"})
	 java.util.ArrayList<? extends DataTypeIEC61360> _dataType;


	/**
	"has definition"
	*/
	@JsonAlias({"ids:definition", "definition"})
	 java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _definition;


	/**
	"has level type"
	*/
	@JsonAlias({"ids:levelType", "levelType"})
	 java.util.ArrayList<? extends LevelType> _levelType;


	/**
	"has preferred name"
	*/
	@NotNull@JsonAlias({"ids:preferredName", "preferredName"})
	 de.fraunhofer.iais.eis.util.TypedLiteral _preferredName;


	/**
	"has short name"
	*/
	@JsonAlias({"ids:shortName", "shortName"})
	 de.fraunhofer.iais.eis.util.TypedLiteral _shortName;


	/**
	"has source of definition"
	*/
	@JsonAlias({"ids:sourceOfDefinition", "sourceOfDefinition"})
	 String _sourceOfDefinition;


	/**
	"has symbol"
	*/
	@JsonAlias({"ids:symbol", "symbol"})
	 String _symbol;


	/**
	"has unit"
	*/
	@JsonAlias({"ids:unit", "unit"})
	 String _unit;


	/**
	"has unit id"
	*/
	@JsonAlias({"ids:unitId", "unitId"})
	 Reference _unitId;


	/**
	"has value"
	*/
	@JsonAlias({"ids:value", "value"})
	 String _value;


	/**
	"has value format"
	*/
	@JsonAlias({"ids:valueFormat", "valueFormat"})
	 String _valueFormat;


	/**
	"has value id"
	*/
	@JsonAlias({"ids:valueId", "valueId"})
	 Reference _valueId;


	/**
	"has value list"

	"The Type \'ValueList\' lists all the allowed values for a concept description for which the allowed values are listed in an enumeration. The value list is a set of value reference pairs."@en
	*/
	@JsonAlias({"ids:valueList", "valueList"})
	 String _valueList;


	// no manual construction
	DataSpecificationIEC61360Impl() {
		id = VocabUtil.getInstance().createRandomUrl("dataSpecificationIEC61360");
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
	
	
	@JsonProperty("ids:dataType")
	java.util.ArrayList<? extends DataTypeIEC61360> getDataType() {
		return _dataType;
	}

	final public void setDataType (java.util.ArrayList<? extends DataTypeIEC61360> _dataType_) {
		this._dataType = _dataType_;
	}

	final public 
	
	
	@JsonProperty("ids:definition")
	java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> getDefinition() {
		return _definition;
	}

	final public void setDefinition (java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _definition_) {
		this._definition = _definition_;
	}

	final public 
	
	
	@JsonProperty("ids:levelType")
	java.util.ArrayList<? extends LevelType> getLevelType() {
		return _levelType;
	}

	final public void setLevelType (java.util.ArrayList<? extends LevelType> _levelType_) {
		this._levelType = _levelType_;
	}

	final public 
	
	@NotNull
	@JsonProperty("ids:preferredName")
	de.fraunhofer.iais.eis.util.TypedLiteral getPreferredName() {
		return _preferredName;
	}

	final public void setPreferredName (de.fraunhofer.iais.eis.util.TypedLiteral _preferredName_) {
		this._preferredName = _preferredName_;
	}

	final public 
	
	
	@JsonProperty("ids:shortName")
	de.fraunhofer.iais.eis.util.TypedLiteral getShortName() {
		return _shortName;
	}

	final public void setShortName (de.fraunhofer.iais.eis.util.TypedLiteral _shortName_) {
		this._shortName = _shortName_;
	}

	final public 
	
	
	@JsonProperty("ids:sourceOfDefinition")
	String getSourceOfDefinition() {
		return _sourceOfDefinition;
	}

	final public void setSourceOfDefinition (String _sourceOfDefinition_) {
		this._sourceOfDefinition = _sourceOfDefinition_;
	}

	final public 
	
	
	@JsonProperty("ids:symbol")
	String getSymbol() {
		return _symbol;
	}

	final public void setSymbol (String _symbol_) {
		this._symbol = _symbol_;
	}

	final public 
	
	
	@JsonProperty("ids:unit")
	String getUnit() {
		return _unit;
	}

	final public void setUnit (String _unit_) {
		this._unit = _unit_;
	}

	final public 
	
	
	@JsonProperty("ids:unitId")
	Reference getUnitId() {
		return _unitId;
	}

	final public void setUnitId (Reference _unitId_) {
		this._unitId = _unitId_;
	}

	final public 
	
	
	@JsonProperty("ids:valueFormat")
	String getValueFormat() {
		return _valueFormat;
	}

	final public void setValueFormat (String _valueFormat_) {
		this._valueFormat = _valueFormat_;
	}

	final public 
	
	
	@JsonProperty("ids:value")
	String getValue() {
		return _value;
	}

	final public void setValue (String _value_) {
		this._value = _value_;
	}

	final public 
	
	
	@JsonProperty("ids:valueList")
	String getValueList() {
		return _valueList;
	}

	final public void setValueList (String _valueList_) {
		this._valueList = _valueList_;
	}

	final public 
	
	
	@JsonProperty("ids:valueId")
	Reference getValueId() {
		return _valueId;
	}

	final public void setValueId (Reference _valueId_) {
		this._valueId = _valueId_;
	}

}
