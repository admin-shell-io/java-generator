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

public class EventBuilder {

	private EventImpl eventImpl;

	public EventBuilder() {
		eventImpl = new EventImpl();
	}

	public EventBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		eventImpl.id = id;
	}



	final public EventBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.eventImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public EventBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.eventImpl._description = _description_;
		return this;
	}


	final public EventBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.eventImpl._displayName = _displayName_;
		return this;
	}


	final public EventBuilder _idShort_(String _idShort_) {
		this.eventImpl._idShort = _idShort_;
		return this;
	}


	final public EventBuilder _parent_(URI _parent_) {
		this.eventImpl._parent = _parent_;
		return this;
	}


	final public EventBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.eventImpl._qualifier = _qualifier_;
		return this;
	}


	final public EventBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.eventImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public EventBuilder _kind_(ModelingKind _kind_) {
		this.eventImpl._kind = _kind_;
		return this;
	}


	final public EventBuilder _semanticId_(Reference _semanticId_) {
		this.eventImpl._semanticId = _semanticId_;
		return this;
	}

	public final Event build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(eventImpl);
		return eventImpl;
	}
}
