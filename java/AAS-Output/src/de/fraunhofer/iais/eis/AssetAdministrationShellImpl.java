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

	"Describes the Administration Shell for Assets, Products, Components, e.g. Machines"@en */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:AssetAdministrationShell")
public class AssetAdministrationShellImpl implements Serializable, AssetAdministrationShell {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@javax.validation.constraints.NotNull URI id;

	//List of all labels of this class
	@JsonIgnore
	java.util.List<TypedLiteral> label = Arrays.asList(new TypedLiteral("Asset Administration Shell", ""));
	//List of all comments of this class
	@JsonIgnore
	java.util.List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("Describes the Administration Shell for Assets, Products, Components, e.g. Machines", "en"));

	// all classes have a generic property array
	@JsonIgnore
	java.util.Map<String,Object> properties;

	// instance fields as derived from information model

	/**
	"has assetInformation"

	"Meta information about the asset the AAS is representing."@en
	*/
	@NotNull@JsonAlias({"ids:assetInformation", "assetInformation"})
	 AssetInformation _assetInformation;


	/**
	"was derived from"

	"This relation connects instances of AAS with their respective types. Refer to Asset Kind for further information of instance and type kinds."@en
	*/
	@JsonAlias({"ids:derivedFrom", "derivedFrom"})
	 Reference _derivedFrom;


	/**
	"has security"

	"Definition of the security relevant aspects of the AAS."@en
	*/
	@JsonAlias({"ids:security", "security"})
	 Security _security;


	/**
	"has Submodel"

	"Points from the Admin Shell to the Submodels that describe the Admin Shell of a given Asset"@en
	*/
	@JsonAlias({"ids:submodel", "submodel"})
	 java.util.ArrayList<? extends Submodel> _submodel;


	/**
	"has View"

	"Points to the differents views associated to the Administration Shell via the Submodels."@en
	*/
	@JsonAlias({"ids:view", "view"})
	 java.util.ArrayList<? extends View> _view;


	/**
	"has Data Specification"

	"Global reference to the data specification template used by the element."@en
	*/
	@JsonAlias({"ids:dataSpecification", "dataSpecification"})
	 java.util.ArrayList<? extends Reference> _dataSpecification;


	/**
	"has administration"

	"Administrative information of an identifiable element."@en
	*/
	@JsonAlias({"ids:administration", "administration"})
	 AdministrativeInformation _administration;


	/**
	"has identification"

	"The globally unique identification of the element."@en
	*/
	@NotNull@JsonAlias({"ids:identification", "identification"})
	 Identifier _identification;


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
	AssetAdministrationShellImpl() {
		id = VocabUtil.getInstance().createRandomUrl("assetAdministrationShell");
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
	@JsonProperty("ids:assetInformation")
	AssetInformation getAssetInformation() {
		return _assetInformation;
	}

	final public void setAssetInformation (AssetInformation _assetInformation_) {
		this._assetInformation = _assetInformation_;
	}

	final public 
	
	
	@JsonProperty("ids:derivedFrom")
	Reference getDerivedFrom() {
		return _derivedFrom;
	}

	final public void setDerivedFrom (Reference _derivedFrom_) {
		this._derivedFrom = _derivedFrom_;
	}

	final public 
	
	
	@JsonProperty("ids:security")
	Security getSecurity() {
		return _security;
	}

	final public void setSecurity (Security _security_) {
		this._security = _security_;
	}

	final public 
	
	
	@JsonProperty("ids:submodel")
	java.util.ArrayList<? extends Submodel> getSubmodel() {
		return _submodel;
	}

	final public void setSubmodel (java.util.ArrayList<? extends Submodel> _submodel_) {
		this._submodel = _submodel_;
	}

	final public 
	
	
	@JsonProperty("ids:view")
	java.util.ArrayList<? extends View> getView() {
		return _view;
	}

	final public void setView (java.util.ArrayList<? extends View> _view_) {
		this._view = _view_;
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
	
	
	@JsonProperty("ids:administration")
	AdministrativeInformation getAdministration() {
		return _administration;
	}

	final public void setAdministration (AdministrativeInformation _administration_) {
		this._administration = _administration_;
	}

	final public 
	
	@NotNull
	@JsonProperty("ids:identification")
	Identifier getIdentification() {
		return _identification;
	}

	final public void setIdentification (Identifier _identification_) {
		this._identification = _identification_;
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
}
