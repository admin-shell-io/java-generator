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

public class RelationshipElementBuilder {

	private RelationshipElementImpl relationshipElementImpl;

	public RelationshipElementBuilder() {
		relationshipElementImpl = new RelationshipElementImpl();
	}

	public RelationshipElementBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		relationshipElementImpl.id = id;
	}

	final public RelationshipElementBuilder _first_(Referable _first_) {
		this.relationshipElementImpl._first = _first_;
		return this;
	}


	final public RelationshipElementBuilder _second_(Referable _second_) {
		this.relationshipElementImpl._second = _second_;
		return this;
	}



	final public RelationshipElementBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.relationshipElementImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public RelationshipElementBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.relationshipElementImpl._description = _description_;
		return this;
	}


	final public RelationshipElementBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.relationshipElementImpl._displayName = _displayName_;
		return this;
	}


	final public RelationshipElementBuilder _idShort_(String _idShort_) {
		this.relationshipElementImpl._idShort = _idShort_;
		return this;
	}


	final public RelationshipElementBuilder _parent_(URI _parent_) {
		this.relationshipElementImpl._parent = _parent_;
		return this;
	}


	final public RelationshipElementBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.relationshipElementImpl._qualifier = _qualifier_;
		return this;
	}


	final public RelationshipElementBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.relationshipElementImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public RelationshipElementBuilder _kind_(ModelingKind _kind_) {
		this.relationshipElementImpl._kind = _kind_;
		return this;
	}


	final public RelationshipElementBuilder _semanticId_(Reference _semanticId_) {
		this.relationshipElementImpl._semanticId = _semanticId_;
		return this;
	}

	public final RelationshipElement build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(relationshipElementImpl);
		return relationshipElementImpl;
	}
}
