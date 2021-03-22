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
	"Permission"

	"Description of a single permission."@en */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:Permission")
public class PermissionImpl implements Serializable, Permission {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@javax.validation.constraints.NotNull URI id;

	//List of all labels of this class
	@JsonIgnore
	java.util.List<TypedLiteral> label = Arrays.asList(new TypedLiteral("Permission", ""));
	//List of all comments of this class
	@JsonIgnore
	java.util.List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("Description of a single permission.", "en"));

	// all classes have a generic property array
	@JsonIgnore
	java.util.Map<String,Object> properties;

	// instance fields as derived from information model

	/**
	"has kind of permission"

	"Description of the kind of permission. Possible kind of permission also include the denial of the permission."@en
	*/
	@NotNull@JsonAlias({"ids:kindOfPermission", "kindOfPermission"})
	 PermissionKind _kindOfPermission;


	/**
	"has permission"

	"Reference to a property that defines the semantics of the permission."@en
	*/
	@NotNull@JsonAlias({"ids:permission", "permission"})
	 Property _permission;


	// no manual construction
	PermissionImpl() {
		id = VocabUtil.getInstance().createRandomUrl("permission");
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
	@JsonProperty("ids:kindOfPermission")
	PermissionKind getKindOfPermission() {
		return _kindOfPermission;
	}

	final public void setKindOfPermission (PermissionKind _kindOfPermission_) {
		this._kindOfPermission = _kindOfPermission_;
	}

	final public 
	
	@NotNull
	@JsonProperty("ids:permission")
	Property getPermission() {
		return _permission;
	}

	final public void setPermission (Property _permission_) {
		this._permission = _permission_;
	}
}
