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

public class SubmodelBuilder {

	private SubmodelImpl submodelImpl;

	public SubmodelBuilder() {
		submodelImpl = new SubmodelImpl();
	}

	public SubmodelBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		submodelImpl.id = id;
	}

	final public SubmodelBuilder _submodelElement_(java.util.ArrayList<? extends SubmodelElement> _submodelElement_) {
		this.submodelImpl._submodelElement = _submodelElement_;
		return this;
	}


	final public SubmodelBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.submodelImpl._qualifier = _qualifier_;
		return this;
	}


	final public SubmodelBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.submodelImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public SubmodelBuilder _administration_(AdministrativeInformation _administration_) {
		this.submodelImpl._administration = _administration_;
		return this;
	}


	final public SubmodelBuilder _identification_(Identifier _identification_) {
		this.submodelImpl._identification = _identification_;
		return this;
	}


	final public SubmodelBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.submodelImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public SubmodelBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.submodelImpl._description = _description_;
		return this;
	}


	final public SubmodelBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.submodelImpl._displayName = _displayName_;
		return this;
	}


	final public SubmodelBuilder _idShort_(String _idShort_) {
		this.submodelImpl._idShort = _idShort_;
		return this;
	}


	final public SubmodelBuilder _parent_(URI _parent_) {
		this.submodelImpl._parent = _parent_;
		return this;
	}


	final public SubmodelBuilder _kind_(ModelingKind _kind_) {
		this.submodelImpl._kind = _kind_;
		return this;
	}


	final public SubmodelBuilder _semanticId_(Reference _semanticId_) {
		this.submodelImpl._semanticId = _semanticId_;
		return this;
	}

	public final Submodel build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(submodelImpl);
		return submodelImpl;
	}
}
