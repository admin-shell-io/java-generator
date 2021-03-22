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
	"Data Specification Physical Unit"

	"Data Specification Template for Physical Units."@en */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:RC01")
public class RC01Impl implements Serializable, RC01 {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@javax.validation.constraints.NotNull URI id;

	//List of all labels of this class
	@JsonIgnore
	java.util.List<TypedLiteral> label = Arrays.asList(new TypedLiteral("Data Specification Physical Unit", ""));
	//List of all comments of this class
	@JsonIgnore
	java.util.List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("Data Specification Template for Physical Units.", "en"));

	// all classes have a generic property array
	@JsonIgnore
	java.util.Map<String,Object> properties;

	// instance fields as derived from information model

	/**
	"has conversion factor"
	*/
	@JsonAlias({"ids:conversionFactor", "conversionFactor"})
	 java.util.ArrayList<? extends String> _conversionFactor;


	/**
	"has definition"
	*/
	@JsonAlias({"ids:definition", "definition"})
	 java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _definition;


	/**
	"has DIN notation"
	*/
	@JsonAlias({"ids:dinNotation", "dinNotation"})
	 java.util.ArrayList<? extends String> _dinNotation;


	/**
	"has ECE code"
	*/
	@JsonAlias({"ids:eceCode", "eceCode"})
	 java.util.ArrayList<? extends String> _eceCode;


	/**
	"has ECE name"
	*/
	@JsonAlias({"ids:eceName", "eceName"})
	 java.util.ArrayList<? extends String> _eceName;


	/**
	"has NIST name"
	*/
	@JsonAlias({"ids:nistName", "nistName"})
	 java.util.ArrayList<? extends String> _nistName;


	/**
	"has registration authority"
	*/
	@JsonAlias({"ids:registrationAuthorityId", "registrationAuthorityId"})
	 java.util.ArrayList<? extends String> _registrationAuthorityId;


	/**
	"has SI name"
	*/
	@JsonAlias({"ids:siName", "siName"})
	 java.util.ArrayList<? extends String> _siName;


	/**
	"has SI notation"
	*/
	@JsonAlias({"ids:siNotation", "siNotation"})
	 java.util.ArrayList<? extends String> _siNotation;


	/**
	"has supplier"
	*/
	@JsonAlias({"ids:supplier", "supplier"})
	 java.util.ArrayList<? extends String> _supplier;


	/**
	"unit has name"
	*/
	@JsonAlias({"ids:unitName", "unitName"})
	 java.util.ArrayList<? extends String> _unitName;


	/**
	"unit has symbol"
	*/
	@JsonAlias({"ids:unitSymbol", "unitSymbol"})
	 java.util.ArrayList<? extends String> _unitSymbol;


	// no manual construction
	RC01Impl() {
		id = VocabUtil.getInstance().createRandomUrl("rC01");
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
	
	
	@JsonProperty("ids:conversionFactor")
	java.util.ArrayList<? extends String> getConversionFactor() {
		return _conversionFactor;
	}

	final public void setConversionFactor (java.util.ArrayList<? extends String> _conversionFactor_) {
		this._conversionFactor = _conversionFactor_;
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
	
	
	@JsonProperty("ids:dinNotation")
	java.util.ArrayList<? extends String> getDinNotation() {
		return _dinNotation;
	}

	final public void setDinNotation (java.util.ArrayList<? extends String> _dinNotation_) {
		this._dinNotation = _dinNotation_;
	}

	final public 
	
	
	@JsonProperty("ids:eceCode")
	java.util.ArrayList<? extends String> getEceCode() {
		return _eceCode;
	}

	final public void setEceCode (java.util.ArrayList<? extends String> _eceCode_) {
		this._eceCode = _eceCode_;
	}

	final public 
	
	
	@JsonProperty("ids:eceName")
	java.util.ArrayList<? extends String> getEceName() {
		return _eceName;
	}

	final public void setEceName (java.util.ArrayList<? extends String> _eceName_) {
		this._eceName = _eceName_;
	}

	final public 
	
	
	@JsonProperty("ids:nistName")
	java.util.ArrayList<? extends String> getNistName() {
		return _nistName;
	}

	final public void setNistName (java.util.ArrayList<? extends String> _nistName_) {
		this._nistName = _nistName_;
	}

	final public 
	
	
	@JsonProperty("ids:siName")
	java.util.ArrayList<? extends String> getSiName() {
		return _siName;
	}

	final public void setSiName (java.util.ArrayList<? extends String> _siName_) {
		this._siName = _siName_;
	}

	final public 
	
	
	@JsonProperty("ids:siNotation")
	java.util.ArrayList<? extends String> getSiNotation() {
		return _siNotation;
	}

	final public void setSiNotation (java.util.ArrayList<? extends String> _siNotation_) {
		this._siNotation = _siNotation_;
	}

	final public 
	
	
	@JsonProperty("ids:registrationAuthorityId")
	java.util.ArrayList<? extends String> getRegistrationAuthorityId() {
		return _registrationAuthorityId;
	}

	final public void setRegistrationAuthorityId (java.util.ArrayList<? extends String> _registrationAuthorityId_) {
		this._registrationAuthorityId = _registrationAuthorityId_;
	}

	final public 
	
	
	@JsonProperty("ids:supplier")
	java.util.ArrayList<? extends String> getSupplier() {
		return _supplier;
	}

	final public void setSupplier (java.util.ArrayList<? extends String> _supplier_) {
		this._supplier = _supplier_;
	}

	final public 
	
	
	@JsonProperty("ids:unitName")
	java.util.ArrayList<? extends String> getUnitName() {
		return _unitName;
	}

	final public void setUnitName (java.util.ArrayList<? extends String> _unitName_) {
		this._unitName = _unitName_;
	}

	final public 
	
	
	@JsonProperty("ids:unitSymbol")
	java.util.ArrayList<? extends String> getUnitSymbol() {
		return _unitSymbol;
	}

	final public void setUnitSymbol (java.util.ArrayList<? extends String> _unitSymbol_) {
		this._unitSymbol = _unitSymbol_;
	}

}
