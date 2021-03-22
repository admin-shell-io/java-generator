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

public class EventMessageBuilder {

	private EventMessageImpl eventMessageImpl;

	public EventMessageBuilder() {
		eventMessageImpl = new EventMessageImpl();
	}

	public EventMessageBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		eventMessageImpl.id = id;
	}



	final public EventMessageBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.eventMessageImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public EventMessageBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.eventMessageImpl._description = _description_;
		return this;
	}


	final public EventMessageBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.eventMessageImpl._displayName = _displayName_;
		return this;
	}


	final public EventMessageBuilder _idShort_(String _idShort_) {
		this.eventMessageImpl._idShort = _idShort_;
		return this;
	}


	final public EventMessageBuilder _parent_(URI _parent_) {
		this.eventMessageImpl._parent = _parent_;
		return this;
	}


	final public EventMessageBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.eventMessageImpl._qualifier = _qualifier_;
		return this;
	}


	final public EventMessageBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.eventMessageImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public EventMessageBuilder _kind_(ModelingKind _kind_) {
		this.eventMessageImpl._kind = _kind_;
		return this;
	}


	final public EventMessageBuilder _semanticId_(Reference _semanticId_) {
		this.eventMessageImpl._semanticId = _semanticId_;
		return this;
	}

	public final EventMessage build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(eventMessageImpl);
		return eventMessageImpl;
	}
}
