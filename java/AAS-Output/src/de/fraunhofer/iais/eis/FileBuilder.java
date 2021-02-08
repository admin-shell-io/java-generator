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

public class FileBuilder {

	private FileImpl fileImpl;

	public FileBuilder() {
		fileImpl = new FileImpl();
	}

	public FileBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		fileImpl.id = id;
	}

	final public FileBuilder _mimeType_(String _mimeType_) {
		this.fileImpl._mimeType = _mimeType_;
		return this;
	}


	final public FileBuilder _value_(String _value_) {
		this.fileImpl._value = _value_;
		return this;
	}



	final public FileBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.fileImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public FileBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.fileImpl._description = _description_;
		return this;
	}


	final public FileBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.fileImpl._displayName = _displayName_;
		return this;
	}


	final public FileBuilder _idShort_(String _idShort_) {
		this.fileImpl._idShort = _idShort_;
		return this;
	}


	final public FileBuilder _parent_(URI _parent_) {
		this.fileImpl._parent = _parent_;
		return this;
	}


	final public FileBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.fileImpl._qualifier = _qualifier_;
		return this;
	}


	final public FileBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.fileImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public FileBuilder _kind_(ModelingKind _kind_) {
		this.fileImpl._kind = _kind_;
		return this;
	}


	final public FileBuilder _semanticId_(Reference _semanticId_) {
		this.fileImpl._semanticId = _semanticId_;
		return this;
	}

	public final File build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(fileImpl);
		return fileImpl;
	}
}
