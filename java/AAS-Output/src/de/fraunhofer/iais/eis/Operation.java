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
	"Operation"

	"An operation is a submodel element with input and output variables."@en*/
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type")
@JsonSubTypes({
@JsonSubTypes.Type(value = OperationImpl.class),})
public interface Operation {

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
	"has input variable"

	"Input parameter of the operation."@en
	*/
	
	
	@JsonProperty("ids:inputVariable")
	java.util.ArrayList<? extends OperationVariable> getInputVariable();
	/**
	"has input/output variable"

	"Parameter that is input and output of the operation."@en
	*/
	
	
	@JsonProperty("ids:inoutputVariable")
	java.util.ArrayList<? extends OperationVariable> getInoutputVariable();
	/**
	"has output variable"

	"Output parameter of the operation."@en
	*/
	
	
	@JsonProperty("ids:outputVariable")
	java.util.ArrayList<? extends OperationVariable> getOutputVariable();
}
