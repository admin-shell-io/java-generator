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

public class AccessControlPolicyPointsBuilder {

	private AccessControlPolicyPointsImpl accessControlPolicyPointsImpl;

	public AccessControlPolicyPointsBuilder() {
		accessControlPolicyPointsImpl = new AccessControlPolicyPointsImpl();
	}

	public AccessControlPolicyPointsBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		accessControlPolicyPointsImpl.id = id;
	}

	final public AccessControlPolicyPointsBuilder _policyAdministrationPoint_(PolicyAdministrationPoint _policyAdministrationPoint_) {
		this.accessControlPolicyPointsImpl._policyAdministrationPoint = _policyAdministrationPoint_;
		return this;
	}


	final public AccessControlPolicyPointsBuilder _policyDecisionPoint_(PolicyDecisionPoint _policyDecisionPoint_) {
		this.accessControlPolicyPointsImpl._policyDecisionPoint = _policyDecisionPoint_;
		return this;
	}


	final public AccessControlPolicyPointsBuilder _policyEnforcementPoint_(PolicyEnforcementPoints _policyEnforcementPoint_) {
		this.accessControlPolicyPointsImpl._policyEnforcementPoint = _policyEnforcementPoint_;
		return this;
	}


	final public AccessControlPolicyPointsBuilder _policyInformationPoints_(PolicyInformationPoints _policyInformationPoints_) {
		this.accessControlPolicyPointsImpl._policyInformationPoints = _policyInformationPoints_;
		return this;
	}

	public final AccessControlPolicyPoints build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(accessControlPolicyPointsImpl);
		return accessControlPolicyPointsImpl;
	}
}
