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
	"Asset Administration Shell"

	"Describes the Administration Shell for Assets, Products, Components, e.g. Machines"@en*/
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type")
@JsonSubTypes({
@JsonSubTypes.Type(value = AssetAdministrationShellImpl.class),})
public interface AssetAdministrationShell {

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
	"has assetInformation"

	"Meta information about the asset the AAS is representing."@en
	*/
	
	@NotNull
	@JsonProperty("ids:assetInformation")
	AssetInformation getAssetInformation();
	/**
	"was derived from"

	"This relation connects instances of AAS with their respective types. Refer to Asset Kind for further information of instance and type kinds."@en
	*/
	
	
	@JsonProperty("ids:derivedFrom")
	Reference getDerivedFrom();
	/**
	"has security"

	"Definition of the security relevant aspects of the AAS."@en
	*/
	
	
	@JsonProperty("ids:security")
	Security getSecurity();
	/**
	"has Submodel"

	"Points from the Admin Shell to the Submodels that describe the Admin Shell of a given Asset"@en
	*/
	
	
	@JsonProperty("ids:submodel")
	java.util.ArrayList<? extends Submodel> getSubmodel();
	/**
	"has View"

	"Points to the differents views associated to the Administration Shell via the Submodels."@en
	*/
	
	
	@JsonProperty("ids:view")
	java.util.ArrayList<? extends View> getView();
}
