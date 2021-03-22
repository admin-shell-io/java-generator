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

	"Data Specification Template for Physical Units."@en*/
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type")
@JsonSubTypes({
@JsonSubTypes.Type(value = RC01Impl.class),})
public interface RC01 {

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
	"has conversion factor"
	*/
	
	
	@JsonProperty("ids:conversionFactor")
	java.util.ArrayList<? extends String> getConversionFactor();
	/**
	"has definition"
	*/
	
	
	@JsonProperty("ids:definition")
	java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> getDefinition();
	/**
	"has DIN notation"
	*/
	
	
	@JsonProperty("ids:dinNotation")
	java.util.ArrayList<? extends String> getDinNotation();
	/**
	"has ECE code"
	*/
	
	
	@JsonProperty("ids:eceCode")
	java.util.ArrayList<? extends String> getEceCode();
	/**
	"has ECE name"
	*/
	
	
	@JsonProperty("ids:eceName")
	java.util.ArrayList<? extends String> getEceName();
	/**
	"has NIST name"
	*/
	
	
	@JsonProperty("ids:nistName")
	java.util.ArrayList<? extends String> getNistName();
	/**
	"has SI name"
	*/
	
	
	@JsonProperty("ids:siName")
	java.util.ArrayList<? extends String> getSiName();
	/**
	"has SI notation"
	*/
	
	
	@JsonProperty("ids:siNotation")
	java.util.ArrayList<? extends String> getSiNotation();
	/**
	"has registration authority"
	*/
	
	
	@JsonProperty("ids:registrationAuthorityId")
	java.util.ArrayList<? extends String> getRegistrationAuthorityId();
	/**
	"has supplier"
	*/
	
	
	@JsonProperty("ids:supplier")
	java.util.ArrayList<? extends String> getSupplier();
	/**
	"unit has name"
	*/
	
	
	@JsonProperty("ids:unitName")
	java.util.ArrayList<? extends String> getUnitName();
	/**
	"unit has symbol"
	*/
	
	
	@JsonProperty("ids:unitSymbol")
	java.util.ArrayList<? extends String> getUnitSymbol();
}
