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

public class PropertyBuilder {

	private PropertyImpl propertyImpl;

	public PropertyBuilder() {
		propertyImpl = new PropertyImpl();
	}

	public PropertyBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		propertyImpl.id = id;
	}

	final public PropertyBuilder _propertyCategory_(java.util.ArrayList<? extends Category> _propertyCategory_) {
		this.propertyImpl._propertyCategory = _propertyCategory_;
		return this;
	}


	final public PropertyBuilder _value_(de.fraunhofer.iais.eis.util.TypedLiteral _value_) {
		this.propertyImpl._value = _value_;
		return this;
	}


	final public PropertyBuilder _valueId_(Reference _valueId_) {
		this.propertyImpl._valueId = _valueId_;
		return this;
	}




	final public PropertyBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.propertyImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public PropertyBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.propertyImpl._description = _description_;
		return this;
	}


	final public PropertyBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.propertyImpl._displayName = _displayName_;
		return this;
	}


	final public PropertyBuilder _idShort_(String _idShort_) {
		this.propertyImpl._idShort = _idShort_;
		return this;
	}


	final public PropertyBuilder _parent_(URI _parent_) {
		this.propertyImpl._parent = _parent_;
		return this;
	}


	final public PropertyBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.propertyImpl._qualifier = _qualifier_;
		return this;
	}


	final public PropertyBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.propertyImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public PropertyBuilder _kind_(ModelingKind _kind_) {
		this.propertyImpl._kind = _kind_;
		return this;
	}


	final public PropertyBuilder _semanticId_(Reference _semanticId_) {
		this.propertyImpl._semanticId = _semanticId_;
		return this;
	}

	public final Property build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(propertyImpl);
		return propertyImpl;
	}
}
