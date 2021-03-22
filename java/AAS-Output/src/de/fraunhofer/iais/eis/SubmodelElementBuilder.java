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

public class SubmodelElementBuilder {

	private SubmodelElementImpl submodelElementImpl;

	public SubmodelElementBuilder() {
		submodelElementImpl = new SubmodelElementImpl();
	}

	public SubmodelElementBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		submodelElementImpl.id = id;
	}


	final public SubmodelElementBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.submodelElementImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public SubmodelElementBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.submodelElementImpl._description = _description_;
		return this;
	}


	final public SubmodelElementBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.submodelElementImpl._displayName = _displayName_;
		return this;
	}


	final public SubmodelElementBuilder _idShort_(String _idShort_) {
		this.submodelElementImpl._idShort = _idShort_;
		return this;
	}


	final public SubmodelElementBuilder _parent_(URI _parent_) {
		this.submodelElementImpl._parent = _parent_;
		return this;
	}


	final public SubmodelElementBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.submodelElementImpl._qualifier = _qualifier_;
		return this;
	}


	final public SubmodelElementBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.submodelElementImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public SubmodelElementBuilder _kind_(ModelingKind _kind_) {
		this.submodelElementImpl._kind = _kind_;
		return this;
	}


	final public SubmodelElementBuilder _semanticId_(Reference _semanticId_) {
		this.submodelElementImpl._semanticId = _semanticId_;
		return this;
	}

	public final SubmodelElement build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(submodelElementImpl);
		return submodelElementImpl;
	}
}
