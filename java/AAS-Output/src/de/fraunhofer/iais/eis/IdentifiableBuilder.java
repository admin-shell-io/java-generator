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

public class IdentifiableBuilder {

	private IdentifiableImpl identifiableImpl;

	public IdentifiableBuilder() {
		identifiableImpl = new IdentifiableImpl();
	}

	public IdentifiableBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		identifiableImpl.id = id;
	}

	final public IdentifiableBuilder _administration_(AdministrativeInformation _administration_) {
		this.identifiableImpl._administration = _administration_;
		return this;
	}


	final public IdentifiableBuilder _identification_(Identifier _identification_) {
		this.identifiableImpl._identification = _identification_;
		return this;
	}


	final public IdentifiableBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.identifiableImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public IdentifiableBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.identifiableImpl._description = _description_;
		return this;
	}


	final public IdentifiableBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.identifiableImpl._displayName = _displayName_;
		return this;
	}


	final public IdentifiableBuilder _idShort_(String _idShort_) {
		this.identifiableImpl._idShort = _idShort_;
		return this;
	}


	final public IdentifiableBuilder _parent_(URI _parent_) {
		this.identifiableImpl._parent = _parent_;
		return this;
	}

	public final Identifiable build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(identifiableImpl);
		return identifiableImpl;
	}
}
