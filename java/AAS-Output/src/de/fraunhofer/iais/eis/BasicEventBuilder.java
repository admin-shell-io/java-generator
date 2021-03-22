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

public class BasicEventBuilder {

	private BasicEventImpl basicEventImpl;

	public BasicEventBuilder() {
		basicEventImpl = new BasicEventImpl();
	}

	public BasicEventBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		basicEventImpl.id = id;
	}

	final public BasicEventBuilder _observed_(Reference _observed_) {
		this.basicEventImpl._observed = _observed_;
		return this;
	}




	final public BasicEventBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.basicEventImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public BasicEventBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.basicEventImpl._description = _description_;
		return this;
	}


	final public BasicEventBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.basicEventImpl._displayName = _displayName_;
		return this;
	}


	final public BasicEventBuilder _idShort_(String _idShort_) {
		this.basicEventImpl._idShort = _idShort_;
		return this;
	}


	final public BasicEventBuilder _parent_(URI _parent_) {
		this.basicEventImpl._parent = _parent_;
		return this;
	}


	final public BasicEventBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.basicEventImpl._qualifier = _qualifier_;
		return this;
	}


	final public BasicEventBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.basicEventImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public BasicEventBuilder _kind_(ModelingKind _kind_) {
		this.basicEventImpl._kind = _kind_;
		return this;
	}


	final public BasicEventBuilder _semanticId_(Reference _semanticId_) {
		this.basicEventImpl._semanticId = _semanticId_;
		return this;
	}

	public final BasicEvent build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(basicEventImpl);
		return basicEventImpl;
	}
}
