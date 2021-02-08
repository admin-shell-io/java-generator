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

public class PolicyAdministrationPointBuilder {

	private PolicyAdministrationPointImpl policyAdministrationPointImpl;

	public PolicyAdministrationPointBuilder() {
		policyAdministrationPointImpl = new PolicyAdministrationPointImpl();
	}

	public PolicyAdministrationPointBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		policyAdministrationPointImpl.id = id;
	}

	final public PolicyAdministrationPointBuilder _localAccessControl_(AccessControl _localAccessControl_) {
		this.policyAdministrationPointImpl._localAccessControl = _localAccessControl_;
		return this;
	}


	final public PolicyAdministrationPointBuilder _externalAccessControl_(boolean _externalAccessControl_) {
		this.policyAdministrationPointImpl._externalAccessControl = _externalAccessControl_;
		return this;
	}

	public final PolicyAdministrationPoint build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(policyAdministrationPointImpl);
		return policyAdministrationPointImpl;
	}
}
