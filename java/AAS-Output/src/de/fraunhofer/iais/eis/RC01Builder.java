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

public class RC01Builder {

	private RC01Impl rC01Impl;

	public RC01Builder() {
		rC01Impl = new RC01Impl();
	}

	public RC01Builder(@javax.validation.constraints.NotNull URI id) {
		this();
		rC01Impl.id = id;
	}

	final public RC01Builder _conversionFactor_(java.util.ArrayList<? extends String> _conversionFactor_) {
		this.rC01Impl._conversionFactor = _conversionFactor_;
		return this;
	}


	final public RC01Builder _definition_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _definition_) {
		this.rC01Impl._definition = _definition_;
		return this;
	}


	final public RC01Builder _dinNotation_(java.util.ArrayList<? extends String> _dinNotation_) {
		this.rC01Impl._dinNotation = _dinNotation_;
		return this;
	}


	final public RC01Builder _eceCode_(java.util.ArrayList<? extends String> _eceCode_) {
		this.rC01Impl._eceCode = _eceCode_;
		return this;
	}


	final public RC01Builder _eceName_(java.util.ArrayList<? extends String> _eceName_) {
		this.rC01Impl._eceName = _eceName_;
		return this;
	}


	final public RC01Builder _nistName_(java.util.ArrayList<? extends String> _nistName_) {
		this.rC01Impl._nistName = _nistName_;
		return this;
	}


	final public RC01Builder _siName_(java.util.ArrayList<? extends String> _siName_) {
		this.rC01Impl._siName = _siName_;
		return this;
	}


	final public RC01Builder _siNotation_(java.util.ArrayList<? extends String> _siNotation_) {
		this.rC01Impl._siNotation = _siNotation_;
		return this;
	}


	final public RC01Builder _registrationAuthorityId_(java.util.ArrayList<? extends String> _registrationAuthorityId_) {
		this.rC01Impl._registrationAuthorityId = _registrationAuthorityId_;
		return this;
	}


	final public RC01Builder _supplier_(java.util.ArrayList<? extends String> _supplier_) {
		this.rC01Impl._supplier = _supplier_;
		return this;
	}


	final public RC01Builder _unitName_(java.util.ArrayList<? extends String> _unitName_) {
		this.rC01Impl._unitName = _unitName_;
		return this;
	}


	final public RC01Builder _unitSymbol_(java.util.ArrayList<? extends String> _unitSymbol_) {
		this.rC01Impl._unitSymbol = _unitSymbol_;
		return this;
	}


	public final RC01 build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(rC01Impl);
		return rC01Impl;
	}
}
