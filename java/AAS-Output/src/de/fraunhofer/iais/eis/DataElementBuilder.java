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

public class DataElementBuilder {

	private DataElementImpl dataElementImpl;

	public DataElementBuilder() {
		dataElementImpl = new DataElementImpl();
	}

	public DataElementBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		dataElementImpl.id = id;
	}



	final public DataElementBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.dataElementImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public DataElementBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.dataElementImpl._description = _description_;
		return this;
	}


	final public DataElementBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.dataElementImpl._displayName = _displayName_;
		return this;
	}


	final public DataElementBuilder _idShort_(String _idShort_) {
		this.dataElementImpl._idShort = _idShort_;
		return this;
	}


	final public DataElementBuilder _parent_(URI _parent_) {
		this.dataElementImpl._parent = _parent_;
		return this;
	}


	final public DataElementBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.dataElementImpl._qualifier = _qualifier_;
		return this;
	}


	final public DataElementBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.dataElementImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public DataElementBuilder _kind_(ModelingKind _kind_) {
		this.dataElementImpl._kind = _kind_;
		return this;
	}


	final public DataElementBuilder _semanticId_(Reference _semanticId_) {
		this.dataElementImpl._semanticId = _semanticId_;
		return this;
	}

	public final DataElement build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(dataElementImpl);
		return dataElementImpl;
	}
}
