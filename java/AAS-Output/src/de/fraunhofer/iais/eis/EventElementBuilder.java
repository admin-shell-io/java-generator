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

public class EventElementBuilder {

	private EventElementImpl eventElementImpl;

	public EventElementBuilder() {
		eventElementImpl = new EventElementImpl();
	}

	public EventElementBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		eventElementImpl.id = id;
	}



	final public EventElementBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.eventElementImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public EventElementBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.eventElementImpl._description = _description_;
		return this;
	}


	final public EventElementBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.eventElementImpl._displayName = _displayName_;
		return this;
	}


	final public EventElementBuilder _idShort_(String _idShort_) {
		this.eventElementImpl._idShort = _idShort_;
		return this;
	}


	final public EventElementBuilder _parent_(URI _parent_) {
		this.eventElementImpl._parent = _parent_;
		return this;
	}


	final public EventElementBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.eventElementImpl._qualifier = _qualifier_;
		return this;
	}


	final public EventElementBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.eventElementImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public EventElementBuilder _kind_(ModelingKind _kind_) {
		this.eventElementImpl._kind = _kind_;
		return this;
	}


	final public EventElementBuilder _semanticId_(Reference _semanticId_) {
		this.eventElementImpl._semanticId = _semanticId_;
		return this;
	}

	public final EventElement build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(eventElementImpl);
		return eventElementImpl;
	}
}
