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
	"Access Control"

	"Access Control defines the local access control policy administration point. Access Control has the major task to define the access permission rules."@en */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:AccessControl")
public class AccessControlImpl implements Serializable, AccessControl {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@javax.validation.constraints.NotNull URI id;

	//List of all labels of this class
	@JsonIgnore
	java.util.List<TypedLiteral> label = Arrays.asList(new TypedLiteral("Access Control", ""));
	//List of all comments of this class
	@JsonIgnore
	java.util.List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("Access Control defines the local access control policy administration point. Access Control has the major task to define the access permission rules.", "en"));

	// all classes have a generic property array
	@JsonIgnore
	java.util.Map<String,Object> properties;

	// instance fields as derived from information model

	/**
	"has access permission rule"

	"Access permission rules of the AAS describing the rights assigned to (already authenticated) subjects to access elements of the AAS."@en
	*/
	@JsonAlias({"ids:accessPermissionRule", "accessPermissionRule"})
	 java.util.ArrayList<? extends AccessPermissionRule> _accessPermissionRule;


	/**
	"has default environment attributes"

	"Reference to a submodel defining default environment attributes, i.e. attributes that are not describing the asset itself. The submodel is of kind=Type. At the same type the values of these environment attributes need to be accessible when evaluating the access permission rules. This is realized as a policy information point."@en
	*/
	@JsonAlias({"ids:defaultEnvironmentAttributes", "defaultEnvironmentAttributes"})
	 Submodel _defaultEnvironmentAttributes;


	/**
	"has default permissions"

	"Reference to a submodel defining the default permissions for the AAS."@en
	*/
	@NotNull@JsonAlias({"ids:defaultPermissions", "defaultPermissions"})
	 Submodel _defaultPermissions;


	/**
	"has default subject attributes"

	"Reference to a submodel defining the default subjects attributes for the AAS that can be used to describe access permission rules."@en
	*/
	@NotNull@JsonAlias({"ids:defaultSubjectAttributes", "defaultSubjectAttributes"})
	 Submodel _defaultSubjectAttributes;


	/**
	"has selectable environment attributes"

	"Reference to a submodel defining which environment attributes can be accessed via the permission rules."@en
	*/
	@JsonAlias({"ids:selectableEnvironmentAttributes", "selectableEnvironmentAttributes"})
	 Submodel _selectableEnvironmentAttributes;


	/**
	"has selectable permissions"

	"Reference to a submodel defining which permissions can be assigned to the subjects."@en
	*/
	@JsonAlias({"ids:selectablePermissions", "selectablePermissions"})
	 Submodel _selectablePermissions;


	/**
	"has selectable subject attributes"

	"Reference to a submodel defining the authenticated subjects that are configured for the AAS. They are selectable by the access permission rules to assign permissions to the subjects."@en
	*/
	@JsonAlias({"ids:selectableSubjectAttributes", "selectableSubjectAttributes"})
	 Submodel _selectableSubjectAttributes;


	// no manual construction
	AccessControlImpl() {
		id = VocabUtil.getInstance().createRandomUrl("accessControl");
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
	
	
	@JsonProperty("ids:accessPermissionRule")
	java.util.ArrayList<? extends AccessPermissionRule> getAccessPermissionRule() {
		return _accessPermissionRule;
	}

	final public void setAccessPermissionRule (java.util.ArrayList<? extends AccessPermissionRule> _accessPermissionRule_) {
		this._accessPermissionRule = _accessPermissionRule_;
	}

	final public 
	
	
	@JsonProperty("ids:selectableSubjectAttributes")
	Submodel getSelectableSubjectAttributes() {
		return _selectableSubjectAttributes;
	}

	final public void setSelectableSubjectAttributes (Submodel _selectableSubjectAttributes_) {
		this._selectableSubjectAttributes = _selectableSubjectAttributes_;
	}

	final public 
	
	@NotNull
	@JsonProperty("ids:defaultSubjectAttributes")
	Submodel getDefaultSubjectAttributes() {
		return _defaultSubjectAttributes;
	}

	final public void setDefaultSubjectAttributes (Submodel _defaultSubjectAttributes_) {
		this._defaultSubjectAttributes = _defaultSubjectAttributes_;
	}

	final public 
	
	
	@JsonProperty("ids:selectablePermissions")
	Submodel getSelectablePermissions() {
		return _selectablePermissions;
	}

	final public void setSelectablePermissions (Submodel _selectablePermissions_) {
		this._selectablePermissions = _selectablePermissions_;
	}

	final public 
	
	@NotNull
	@JsonProperty("ids:defaultPermissions")
	Submodel getDefaultPermissions() {
		return _defaultPermissions;
	}

	final public void setDefaultPermissions (Submodel _defaultPermissions_) {
		this._defaultPermissions = _defaultPermissions_;
	}

	final public 
	
	
	@JsonProperty("ids:selectableEnvironmentAttributes")
	Submodel getSelectableEnvironmentAttributes() {
		return _selectableEnvironmentAttributes;
	}

	final public void setSelectableEnvironmentAttributes (Submodel _selectableEnvironmentAttributes_) {
		this._selectableEnvironmentAttributes = _selectableEnvironmentAttributes_;
	}

	final public 
	
	
	@JsonProperty("ids:defaultEnvironmentAttributes")
	Submodel getDefaultEnvironmentAttributes() {
		return _defaultEnvironmentAttributes;
	}

	final public void setDefaultEnvironmentAttributes (Submodel _defaultEnvironmentAttributes_) {
		this._defaultEnvironmentAttributes = _defaultEnvironmentAttributes_;
	}
}
