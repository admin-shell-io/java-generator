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

public class AccessControlBuilder {

	private AccessControlImpl accessControlImpl;

	public AccessControlBuilder() {
		accessControlImpl = new AccessControlImpl();
	}

	public AccessControlBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		accessControlImpl.id = id;
	}

	final public AccessControlBuilder _accessPermissionRule_(java.util.ArrayList<? extends AccessPermissionRule> _accessPermissionRule_) {
		this.accessControlImpl._accessPermissionRule = _accessPermissionRule_;
		return this;
	}


	final public AccessControlBuilder _selectableSubjectAttributes_(Submodel _selectableSubjectAttributes_) {
		this.accessControlImpl._selectableSubjectAttributes = _selectableSubjectAttributes_;
		return this;
	}


	final public AccessControlBuilder _defaultSubjectAttributes_(Submodel _defaultSubjectAttributes_) {
		this.accessControlImpl._defaultSubjectAttributes = _defaultSubjectAttributes_;
		return this;
	}


	final public AccessControlBuilder _selectablePermissions_(Submodel _selectablePermissions_) {
		this.accessControlImpl._selectablePermissions = _selectablePermissions_;
		return this;
	}


	final public AccessControlBuilder _defaultPermissions_(Submodel _defaultPermissions_) {
		this.accessControlImpl._defaultPermissions = _defaultPermissions_;
		return this;
	}


	final public AccessControlBuilder _selectableEnvironmentAttributes_(Submodel _selectableEnvironmentAttributes_) {
		this.accessControlImpl._selectableEnvironmentAttributes = _selectableEnvironmentAttributes_;
		return this;
	}


	final public AccessControlBuilder _defaultEnvironmentAttributes_(Submodel _defaultEnvironmentAttributes_) {
		this.accessControlImpl._defaultEnvironmentAttributes = _defaultEnvironmentAttributes_;
		return this;
	}

	public final AccessControl build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(accessControlImpl);
		return accessControlImpl;
	}
}
