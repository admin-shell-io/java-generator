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

public class ReferableBuilder {

	private ReferableImpl referableImpl;

	public ReferableBuilder() {
		referableImpl = new ReferableImpl();
	}

	public ReferableBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		referableImpl.id = id;
	}

	final public ReferableBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.referableImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public ReferableBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.referableImpl._description = _description_;
		return this;
	}


	final public ReferableBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.referableImpl._displayName = _displayName_;
		return this;
	}


	final public ReferableBuilder _idShort_(String _idShort_) {
		this.referableImpl._idShort = _idShort_;
		return this;
	}


	final public ReferableBuilder _parent_(URI _parent_) {
		this.referableImpl._parent = _parent_;
		return this;
	}

	public final Referable build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(referableImpl);
		return referableImpl;
	}
}
