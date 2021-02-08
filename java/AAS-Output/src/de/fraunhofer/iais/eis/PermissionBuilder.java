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

public class PermissionBuilder {

	private PermissionImpl permissionImpl;

	public PermissionBuilder() {
		permissionImpl = new PermissionImpl();
	}

	public PermissionBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		permissionImpl.id = id;
	}

	final public PermissionBuilder _kindOfPermission_(PermissionKind _kindOfPermission_) {
		this.permissionImpl._kindOfPermission = _kindOfPermission_;
		return this;
	}


	final public PermissionBuilder _permission_(Property _permission_) {
		this.permissionImpl._permission = _permission_;
		return this;
	}

	public final Permission build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(permissionImpl);
		return permissionImpl;
	}
}
