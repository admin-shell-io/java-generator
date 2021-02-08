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

	"Data Specification Template for defining Property Descriptions conformant to IEC 61360."@en*/
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type")
@JsonSubTypes({
@JsonSubTypes.Type(value = DataSpecificationIEC61360Impl.class),})
public interface DataSpecificationIEC61360 {

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
	"has datatype"
	*/
	
	
	@JsonProperty("ids:dataType")
	java.util.ArrayList<? extends DataTypeIEC61360> getDataType();
	/**
	"has definition"
	*/
	
	
	@JsonProperty("ids:definition")
	java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> getDefinition();
	/**
	"has level type"
	*/
	
	
	@JsonProperty("ids:levelType")
	java.util.ArrayList<? extends LevelType> getLevelType();
	/**
	"has preferred name"
	*/
	
	@NotNull
	@JsonProperty("ids:preferredName")
	de.fraunhofer.iais.eis.util.TypedLiteral getPreferredName();
	/**
	"has short name"
	*/
	
	
	@JsonProperty("ids:shortName")
	de.fraunhofer.iais.eis.util.TypedLiteral getShortName();
	/**
	"has source of definition"
	*/
	
	
	@JsonProperty("ids:sourceOfDefinition")
	String getSourceOfDefinition();
	/**
	"has symbol"
	*/
	
	
	@JsonProperty("ids:symbol")
	String getSymbol();
	/**
	"has unit"
	*/
	
	
	@JsonProperty("ids:unit")
	String getUnit();
	/**
	"has unit id"
	*/
	
	
	@JsonProperty("ids:unitId")
	Reference getUnitId();
	/**
	"has value format"
	*/
	
	
	@JsonProperty("ids:valueFormat")
	String getValueFormat();
	/**
	"has value"
	*/
	
	
	@JsonProperty("ids:value")
	String getValue();
	/**
	"has value list"

	"The Type \'ValueList\' lists all the allowed values for a concept description for which the allowed values are listed in an enumeration. The value list is a set of value reference pairs."@en
	*/
	
	
	@JsonProperty("ids:valueList")
	String getValueList();
	/**
	"has value id"
	*/
	
	
	@JsonProperty("ids:valueId")
	Reference getValueId();
}
