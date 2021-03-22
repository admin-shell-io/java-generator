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

public class IdentifierKeyValuePairBuilder {

	private IdentifierKeyValuePairImpl identifierKeyValuePairImpl;

	public IdentifierKeyValuePairBuilder() {
		identifierKeyValuePairImpl = new IdentifierKeyValuePairImpl();
	}

	public IdentifierKeyValuePairBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		identifierKeyValuePairImpl.id = id;
	}

	final public IdentifierKeyValuePairBuilder _key_(String _key_) {
		this.identifierKeyValuePairImpl._key = _key_;
		return this;
	}


	final public IdentifierKeyValuePairBuilder _value_(String _value_) {
		this.identifierKeyValuePairImpl._value = _value_;
		return this;
	}


	final public IdentifierKeyValuePairBuilder _externalSubjectId_(Reference _externalSubjectId_) {
		this.identifierKeyValuePairImpl._externalSubjectId = _externalSubjectId_;
		return this;
	}


	final public IdentifierKeyValuePairBuilder _semanticId_(Reference _semanticId_) {
		this.identifierKeyValuePairImpl._semanticId = _semanticId_;
		return this;
	}

	public final IdentifierKeyValuePair build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(identifierKeyValuePairImpl);
		return identifierKeyValuePairImpl;
	}
}
