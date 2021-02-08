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

public class ViewBuilder {

	private ViewImpl viewImpl;

	public ViewBuilder() {
		viewImpl = new ViewImpl();
	}

	public ViewBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		viewImpl.id = id;
	}

	final public ViewBuilder _containedElement_(java.util.ArrayList<? extends Referable> _containedElement_) {
		this.viewImpl._containedElement = _containedElement_;
		return this;
	}


	final public ViewBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.viewImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public ViewBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.viewImpl._description = _description_;
		return this;
	}


	final public ViewBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.viewImpl._displayName = _displayName_;
		return this;
	}


	final public ViewBuilder _idShort_(String _idShort_) {
		this.viewImpl._idShort = _idShort_;
		return this;
	}


	final public ViewBuilder _parent_(URI _parent_) {
		this.viewImpl._parent = _parent_;
		return this;
	}


	final public ViewBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.viewImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public ViewBuilder _semanticId_(Reference _semanticId_) {
		this.viewImpl._semanticId = _semanticId_;
		return this;
	}

	public final View build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(viewImpl);
		return viewImpl;
	}
}
