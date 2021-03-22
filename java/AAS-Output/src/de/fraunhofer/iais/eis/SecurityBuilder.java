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

public class SecurityBuilder {

	private SecurityImpl securityImpl;

	public SecurityBuilder() {
		securityImpl = new SecurityImpl();
	}

	public SecurityBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		securityImpl.id = id;
	}

	final public SecurityBuilder _accessControlPolicyPoints_(PolicyAdministrationPoint _accessControlPolicyPoints_) {
		this.securityImpl._accessControlPolicyPoints = _accessControlPolicyPoints_;
		return this;
	}


	final public SecurityBuilder _certificate_(java.util.ArrayList<? extends Certificate> _certificate_) {
		this.securityImpl._certificate = _certificate_;
		return this;
	}


	final public SecurityBuilder _requiredCertificateExtension_(java.util.ArrayList<? extends Reference> _requiredCertificateExtension_) {
		this.securityImpl._requiredCertificateExtension = _requiredCertificateExtension_;
		return this;
	}

	public final Security build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(securityImpl);
		return securityImpl;
	}
}
