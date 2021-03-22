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

public class AnnotatedRelationshipElementBuilder {

	private AnnotatedRelationshipElementImpl annotatedRelationshipElementImpl;

	public AnnotatedRelationshipElementBuilder() {
		annotatedRelationshipElementImpl = new AnnotatedRelationshipElementImpl();
	}

	public AnnotatedRelationshipElementBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		annotatedRelationshipElementImpl.id = id;
	}

	final public AnnotatedRelationshipElementBuilder _annotation_(java.util.ArrayList<? extends DataElement> _annotation_) {
		this.annotatedRelationshipElementImpl._annotation = _annotation_;
		return this;
	}


	final public AnnotatedRelationshipElementBuilder _first_(Referable _first_) {
		this.annotatedRelationshipElementImpl._first = _first_;
		return this;
	}


	final public AnnotatedRelationshipElementBuilder _second_(Referable _second_) {
		this.annotatedRelationshipElementImpl._second = _second_;
		return this;
	}



	final public AnnotatedRelationshipElementBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.annotatedRelationshipElementImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public AnnotatedRelationshipElementBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.annotatedRelationshipElementImpl._description = _description_;
		return this;
	}


	final public AnnotatedRelationshipElementBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.annotatedRelationshipElementImpl._displayName = _displayName_;
		return this;
	}


	final public AnnotatedRelationshipElementBuilder _idShort_(String _idShort_) {
		this.annotatedRelationshipElementImpl._idShort = _idShort_;
		return this;
	}


	final public AnnotatedRelationshipElementBuilder _parent_(URI _parent_) {
		this.annotatedRelationshipElementImpl._parent = _parent_;
		return this;
	}


	final public AnnotatedRelationshipElementBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.annotatedRelationshipElementImpl._qualifier = _qualifier_;
		return this;
	}


	final public AnnotatedRelationshipElementBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.annotatedRelationshipElementImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public AnnotatedRelationshipElementBuilder _kind_(ModelingKind _kind_) {
		this.annotatedRelationshipElementImpl._kind = _kind_;
		return this;
	}


	final public AnnotatedRelationshipElementBuilder _semanticId_(Reference _semanticId_) {
		this.annotatedRelationshipElementImpl._semanticId = _semanticId_;
		return this;
	}

	public final AnnotatedRelationshipElement build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(annotatedRelationshipElementImpl);
		return annotatedRelationshipElementImpl;
	}
}
