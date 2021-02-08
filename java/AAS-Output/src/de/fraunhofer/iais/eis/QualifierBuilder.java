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

public class QualifierBuilder {

	private QualifierImpl qualifierImpl;

	public QualifierBuilder() {
		qualifierImpl = new QualifierImpl();
	}

	public QualifierBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		qualifierImpl.id = id;
	}

	final public QualifierBuilder _type_(String _type_) {
		this.qualifierImpl._type = _type_;
		return this;
	}


	final public QualifierBuilder _value_(de.fraunhofer.iais.eis.util.TypedLiteral _value_) {
		this.qualifierImpl._value = _value_;
		return this;
	}


	final public QualifierBuilder _valueId_(Reference _valueId_) {
		this.qualifierImpl._valueId = _valueId_;
		return this;
	}



	final public QualifierBuilder _semanticId_(Reference _semanticId_) {
		this.qualifierImpl._semanticId = _semanticId_;
		return this;
	}

	public final Qualifier build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(qualifierImpl);
		return qualifierImpl;
	}
}
