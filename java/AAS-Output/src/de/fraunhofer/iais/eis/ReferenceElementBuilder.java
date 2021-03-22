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

public class ReferenceElementBuilder {

	private ReferenceElementImpl referenceElementImpl;

	public ReferenceElementBuilder() {
		referenceElementImpl = new ReferenceElementImpl();
	}

	public ReferenceElementBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		referenceElementImpl.id = id;
	}

	final public ReferenceElementBuilder _value_(Reference _value_) {
		this.referenceElementImpl._value = _value_;
		return this;
	}




	final public ReferenceElementBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.referenceElementImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public ReferenceElementBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.referenceElementImpl._description = _description_;
		return this;
	}


	final public ReferenceElementBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.referenceElementImpl._displayName = _displayName_;
		return this;
	}


	final public ReferenceElementBuilder _idShort_(String _idShort_) {
		this.referenceElementImpl._idShort = _idShort_;
		return this;
	}


	final public ReferenceElementBuilder _parent_(URI _parent_) {
		this.referenceElementImpl._parent = _parent_;
		return this;
	}


	final public ReferenceElementBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.referenceElementImpl._qualifier = _qualifier_;
		return this;
	}


	final public ReferenceElementBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.referenceElementImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public ReferenceElementBuilder _kind_(ModelingKind _kind_) {
		this.referenceElementImpl._kind = _kind_;
		return this;
	}


	final public ReferenceElementBuilder _semanticId_(Reference _semanticId_) {
		this.referenceElementImpl._semanticId = _semanticId_;
		return this;
	}

	public final ReferenceElement build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(referenceElementImpl);
		return referenceElementImpl;
	}
}
