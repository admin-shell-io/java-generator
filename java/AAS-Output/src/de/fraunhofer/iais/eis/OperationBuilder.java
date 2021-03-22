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

public class OperationBuilder {

	private OperationImpl operationImpl;

	public OperationBuilder() {
		operationImpl = new OperationImpl();
	}

	public OperationBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		operationImpl.id = id;
	}

	final public OperationBuilder _inputVariable_(java.util.ArrayList<? extends OperationVariable> _inputVariable_) {
		this.operationImpl._inputVariable = _inputVariable_;
		return this;
	}


	final public OperationBuilder _inoutputVariable_(java.util.ArrayList<? extends OperationVariable> _inoutputVariable_) {
		this.operationImpl._inoutputVariable = _inoutputVariable_;
		return this;
	}


	final public OperationBuilder _outputVariable_(java.util.ArrayList<? extends OperationVariable> _outputVariable_) {
		this.operationImpl._outputVariable = _outputVariable_;
		return this;
	}



	final public OperationBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.operationImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public OperationBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.operationImpl._description = _description_;
		return this;
	}


	final public OperationBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.operationImpl._displayName = _displayName_;
		return this;
	}


	final public OperationBuilder _idShort_(String _idShort_) {
		this.operationImpl._idShort = _idShort_;
		return this;
	}


	final public OperationBuilder _parent_(URI _parent_) {
		this.operationImpl._parent = _parent_;
		return this;
	}


	final public OperationBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.operationImpl._qualifier = _qualifier_;
		return this;
	}


	final public OperationBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.operationImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public OperationBuilder _kind_(ModelingKind _kind_) {
		this.operationImpl._kind = _kind_;
		return this;
	}


	final public OperationBuilder _semanticId_(Reference _semanticId_) {
		this.operationImpl._semanticId = _semanticId_;
		return this;
	}

	public final Operation build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(operationImpl);
		return operationImpl;
	}
}
