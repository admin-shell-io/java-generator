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

public class ExtensionBuilder {

	private ExtensionImpl extensionImpl;

	public ExtensionBuilder() {
		extensionImpl = new ExtensionImpl();
	}

	public ExtensionBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		extensionImpl.id = id;
	}

	final public ExtensionBuilder _name_(java.util.ArrayList<? extends String> _name_) {
		this.extensionImpl._name = _name_;
		return this;
	}


	final public ExtensionBuilder _valueType_(java.util.ArrayList<? extends String> _valueType_) {
		this.extensionImpl._valueType = _valueType_;
		return this;
	}


	final public ExtensionBuilder _value_(java.util.ArrayList<? extends String> _value_) {
		this.extensionImpl._value = _value_;
		return this;
	}


	final public ExtensionBuilder _refersTo_(java.util.ArrayList<? extends Reference> _refersTo_) {
		this.extensionImpl._refersTo = _refersTo_;
		return this;
	}


	final public ExtensionBuilder _semanticId_(Reference _semanticId_) {
		this.extensionImpl._semanticId = _semanticId_;
		return this;
	}

	public final Extension build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(extensionImpl);
		return extensionImpl;
	}
}
