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

public class PermissionsPerObjectBuilder {

	private PermissionsPerObjectImpl permissionsPerObjectImpl;

	public PermissionsPerObjectBuilder() {
		permissionsPerObjectImpl = new PermissionsPerObjectImpl();
	}

	public PermissionsPerObjectBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		permissionsPerObjectImpl.id = id;
	}

	final public PermissionsPerObjectBuilder _object_(Referable _object_) {
		this.permissionsPerObjectImpl._object = _object_;
		return this;
	}


	final public PermissionsPerObjectBuilder _permission_(java.util.ArrayList<? extends Permission> _permission_) {
		this.permissionsPerObjectImpl._permission = _permission_;
		return this;
	}


	final public PermissionsPerObjectBuilder _targetObjectAttributes_(ObjectAttributes _targetObjectAttributes_) {
		this.permissionsPerObjectImpl._targetObjectAttributes = _targetObjectAttributes_;
		return this;
	}

	public final PermissionsPerObject build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(permissionsPerObjectImpl);
		return permissionsPerObjectImpl;
	}
}
