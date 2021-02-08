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

public class CapabilityBuilder {

	private CapabilityImpl capabilityImpl;

	public CapabilityBuilder() {
		capabilityImpl = new CapabilityImpl();
	}

	public CapabilityBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		capabilityImpl.id = id;
	}



	final public CapabilityBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.capabilityImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public CapabilityBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.capabilityImpl._description = _description_;
		return this;
	}


	final public CapabilityBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.capabilityImpl._displayName = _displayName_;
		return this;
	}


	final public CapabilityBuilder _idShort_(String _idShort_) {
		this.capabilityImpl._idShort = _idShort_;
		return this;
	}


	final public CapabilityBuilder _parent_(URI _parent_) {
		this.capabilityImpl._parent = _parent_;
		return this;
	}


	final public CapabilityBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.capabilityImpl._qualifier = _qualifier_;
		return this;
	}


	final public CapabilityBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.capabilityImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public CapabilityBuilder _kind_(ModelingKind _kind_) {
		this.capabilityImpl._kind = _kind_;
		return this;
	}


	final public CapabilityBuilder _semanticId_(Reference _semanticId_) {
		this.capabilityImpl._semanticId = _semanticId_;
		return this;
	}

	public final Capability build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(capabilityImpl);
		return capabilityImpl;
	}
}
