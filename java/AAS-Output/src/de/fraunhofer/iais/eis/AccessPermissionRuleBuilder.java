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

public class AccessPermissionRuleBuilder {

	private AccessPermissionRuleImpl accessPermissionRuleImpl;

	public AccessPermissionRuleBuilder() {
		accessPermissionRuleImpl = new AccessPermissionRuleImpl();
	}

	public AccessPermissionRuleBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		accessPermissionRuleImpl.id = id;
	}

	final public AccessPermissionRuleBuilder _permissionsPerObject_(java.util.ArrayList<? extends PermissionsPerObject> _permissionsPerObject_) {
		this.accessPermissionRuleImpl._permissionsPerObject = _permissionsPerObject_;
		return this;
	}


	final public AccessPermissionRuleBuilder _targetSubjectAttributes_(SubjectAttributes _targetSubjectAttributes_) {
		this.accessPermissionRuleImpl._targetSubjectAttributes = _targetSubjectAttributes_;
		return this;
	}


	final public AccessPermissionRuleBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.accessPermissionRuleImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public AccessPermissionRuleBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.accessPermissionRuleImpl._description = _description_;
		return this;
	}


	final public AccessPermissionRuleBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.accessPermissionRuleImpl._displayName = _displayName_;
		return this;
	}


	final public AccessPermissionRuleBuilder _idShort_(String _idShort_) {
		this.accessPermissionRuleImpl._idShort = _idShort_;
		return this;
	}


	final public AccessPermissionRuleBuilder _parent_(URI _parent_) {
		this.accessPermissionRuleImpl._parent = _parent_;
		return this;
	}


	final public AccessPermissionRuleBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.accessPermissionRuleImpl._qualifier = _qualifier_;
		return this;
	}

	public final AccessPermissionRule build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(accessPermissionRuleImpl);
		return accessPermissionRuleImpl;
	}
}
