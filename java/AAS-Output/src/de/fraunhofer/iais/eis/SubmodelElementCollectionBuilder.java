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

public class SubmodelElementCollectionBuilder {

	private SubmodelElementCollectionImpl submodelElementCollectionImpl;

	public SubmodelElementCollectionBuilder() {
		submodelElementCollectionImpl = new SubmodelElementCollectionImpl();
	}

	public SubmodelElementCollectionBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		submodelElementCollectionImpl.id = id;
	}

	final public SubmodelElementCollectionBuilder _allowDuplicates_(boolean _allowDuplicates_) {
		this.submodelElementCollectionImpl._allowDuplicates = _allowDuplicates_;
		return this;
	}


	final public SubmodelElementCollectionBuilder _ordered_(boolean _ordered_) {
		this.submodelElementCollectionImpl._ordered = _ordered_;
		return this;
	}


	final public SubmodelElementCollectionBuilder _value_(java.util.ArrayList<? extends SubmodelElement> _value_) {
		this.submodelElementCollectionImpl._value = _value_;
		return this;
	}



	final public SubmodelElementCollectionBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.submodelElementCollectionImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public SubmodelElementCollectionBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.submodelElementCollectionImpl._description = _description_;
		return this;
	}


	final public SubmodelElementCollectionBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.submodelElementCollectionImpl._displayName = _displayName_;
		return this;
	}


	final public SubmodelElementCollectionBuilder _idShort_(String _idShort_) {
		this.submodelElementCollectionImpl._idShort = _idShort_;
		return this;
	}


	final public SubmodelElementCollectionBuilder _parent_(URI _parent_) {
		this.submodelElementCollectionImpl._parent = _parent_;
		return this;
	}


	final public SubmodelElementCollectionBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.submodelElementCollectionImpl._qualifier = _qualifier_;
		return this;
	}


	final public SubmodelElementCollectionBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.submodelElementCollectionImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public SubmodelElementCollectionBuilder _kind_(ModelingKind _kind_) {
		this.submodelElementCollectionImpl._kind = _kind_;
		return this;
	}


	final public SubmodelElementCollectionBuilder _semanticId_(Reference _semanticId_) {
		this.submodelElementCollectionImpl._semanticId = _semanticId_;
		return this;
	}

	public final SubmodelElementCollection build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(submodelElementCollectionImpl);
		return submodelElementCollectionImpl;
	}
}
