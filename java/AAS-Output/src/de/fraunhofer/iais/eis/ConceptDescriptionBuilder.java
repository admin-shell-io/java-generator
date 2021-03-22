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

public class ConceptDescriptionBuilder {

	private ConceptDescriptionImpl conceptDescriptionImpl;

	public ConceptDescriptionBuilder() {
		conceptDescriptionImpl = new ConceptDescriptionImpl();
	}

	public ConceptDescriptionBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		conceptDescriptionImpl.id = id;
	}

	final public ConceptDescriptionBuilder _content_(java.util.ArrayList<? extends DataSpecificationContent> _content_) {
		this.conceptDescriptionImpl._content = _content_;
		return this;
	}


	final public ConceptDescriptionBuilder _isCaseOf_(java.util.ArrayList<? extends Reference> _isCaseOf_) {
		this.conceptDescriptionImpl._isCaseOf = _isCaseOf_;
		return this;
	}


	final public ConceptDescriptionBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.conceptDescriptionImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public ConceptDescriptionBuilder _administration_(AdministrativeInformation _administration_) {
		this.conceptDescriptionImpl._administration = _administration_;
		return this;
	}


	final public ConceptDescriptionBuilder _identification_(Identifier _identification_) {
		this.conceptDescriptionImpl._identification = _identification_;
		return this;
	}


	final public ConceptDescriptionBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.conceptDescriptionImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public ConceptDescriptionBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.conceptDescriptionImpl._description = _description_;
		return this;
	}


	final public ConceptDescriptionBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.conceptDescriptionImpl._displayName = _displayName_;
		return this;
	}


	final public ConceptDescriptionBuilder _idShort_(String _idShort_) {
		this.conceptDescriptionImpl._idShort = _idShort_;
		return this;
	}


	final public ConceptDescriptionBuilder _parent_(URI _parent_) {
		this.conceptDescriptionImpl._parent = _parent_;
		return this;
	}

	public final ConceptDescription build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(conceptDescriptionImpl);
		return conceptDescriptionImpl;
	}
}
