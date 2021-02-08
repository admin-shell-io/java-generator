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

public class BlobBuilder {

	private BlobImpl blobImpl;

	public BlobBuilder() {
		blobImpl = new BlobImpl();
	}

	public BlobBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		blobImpl.id = id;
	}

	final public BlobBuilder _mimeType_(String _mimeType_) {
		this.blobImpl._mimeType = _mimeType_;
		return this;
	}


	final public BlobBuilder _value_(byte _value_) {
		this.blobImpl._value = _value_;
		return this;
	}




	final public BlobBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.blobImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public BlobBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.blobImpl._description = _description_;
		return this;
	}


	final public BlobBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.blobImpl._displayName = _displayName_;
		return this;
	}


	final public BlobBuilder _idShort_(String _idShort_) {
		this.blobImpl._idShort = _idShort_;
		return this;
	}


	final public BlobBuilder _parent_(URI _parent_) {
		this.blobImpl._parent = _parent_;
		return this;
	}


	final public BlobBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.blobImpl._qualifier = _qualifier_;
		return this;
	}


	final public BlobBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.blobImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public BlobBuilder _kind_(ModelingKind _kind_) {
		this.blobImpl._kind = _kind_;
		return this;
	}


	final public BlobBuilder _semanticId_(Reference _semanticId_) {
		this.blobImpl._semanticId = _semanticId_;
		return this;
	}

	public final Blob build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(blobImpl);
		return blobImpl;
	}
}
