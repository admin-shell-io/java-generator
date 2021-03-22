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

public class KeyBuilder {

	private KeyImpl keyImpl;

	public KeyBuilder() {
		keyImpl = new KeyImpl();
	}

	public KeyBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		keyImpl.id = id;
	}

	final public KeyBuilder _idType_(KeyType _idType_) {
		this.keyImpl._idType = _idType_;
		return this;
	}


	final public KeyBuilder _type_(KeyElements _type_) {
		this.keyImpl._type = _type_;
		return this;
	}


	final public KeyBuilder _value_(String _value_) {
		this.keyImpl._value = _value_;
		return this;
	}

	public final Key build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(keyImpl);
		return keyImpl;
	}
}
