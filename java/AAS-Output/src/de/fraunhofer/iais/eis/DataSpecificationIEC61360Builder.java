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

public class DataSpecificationIEC61360Builder {

	private DataSpecificationIEC61360Impl dataSpecificationIEC61360Impl;

	public DataSpecificationIEC61360Builder() {
		dataSpecificationIEC61360Impl = new DataSpecificationIEC61360Impl();
	}

	public DataSpecificationIEC61360Builder(@javax.validation.constraints.NotNull URI id) {
		this();
		dataSpecificationIEC61360Impl.id = id;
	}

	final public DataSpecificationIEC61360Builder _dataType_(java.util.ArrayList<? extends DataTypeIEC61360> _dataType_) {
		this.dataSpecificationIEC61360Impl._dataType = _dataType_;
		return this;
	}


	final public DataSpecificationIEC61360Builder _definition_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _definition_) {
		this.dataSpecificationIEC61360Impl._definition = _definition_;
		return this;
	}


	final public DataSpecificationIEC61360Builder _levelType_(java.util.ArrayList<? extends LevelType> _levelType_) {
		this.dataSpecificationIEC61360Impl._levelType = _levelType_;
		return this;
	}


	final public DataSpecificationIEC61360Builder _preferredName_(de.fraunhofer.iais.eis.util.TypedLiteral _preferredName_) {
		this.dataSpecificationIEC61360Impl._preferredName = _preferredName_;
		return this;
	}


	final public DataSpecificationIEC61360Builder _shortName_(de.fraunhofer.iais.eis.util.TypedLiteral _shortName_) {
		this.dataSpecificationIEC61360Impl._shortName = _shortName_;
		return this;
	}


	final public DataSpecificationIEC61360Builder _sourceOfDefinition_(String _sourceOfDefinition_) {
		this.dataSpecificationIEC61360Impl._sourceOfDefinition = _sourceOfDefinition_;
		return this;
	}


	final public DataSpecificationIEC61360Builder _symbol_(String _symbol_) {
		this.dataSpecificationIEC61360Impl._symbol = _symbol_;
		return this;
	}


	final public DataSpecificationIEC61360Builder _unit_(String _unit_) {
		this.dataSpecificationIEC61360Impl._unit = _unit_;
		return this;
	}


	final public DataSpecificationIEC61360Builder _unitId_(Reference _unitId_) {
		this.dataSpecificationIEC61360Impl._unitId = _unitId_;
		return this;
	}


	final public DataSpecificationIEC61360Builder _valueFormat_(String _valueFormat_) {
		this.dataSpecificationIEC61360Impl._valueFormat = _valueFormat_;
		return this;
	}


	final public DataSpecificationIEC61360Builder _value_(String _value_) {
		this.dataSpecificationIEC61360Impl._value = _value_;
		return this;
	}


	final public DataSpecificationIEC61360Builder _valueList_(String _valueList_) {
		this.dataSpecificationIEC61360Impl._valueList = _valueList_;
		return this;
	}


	final public DataSpecificationIEC61360Builder _valueId_(Reference _valueId_) {
		this.dataSpecificationIEC61360Impl._valueId = _valueId_;
		return this;
	}


	public final DataSpecificationIEC61360 build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(dataSpecificationIEC61360Impl);
		return dataSpecificationIEC61360Impl;
	}
}
