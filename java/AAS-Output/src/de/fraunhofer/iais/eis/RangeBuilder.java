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

public class RangeBuilder {

	private RangeImpl rangeImpl;

	public RangeBuilder() {
		rangeImpl = new RangeImpl();
	}

	public RangeBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		rangeImpl.id = id;
	}

	final public RangeBuilder _max_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _max_) {
		this.rangeImpl._max = _max_;
		return this;
	}


	final public RangeBuilder _min_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _min_) {
		this.rangeImpl._min = _min_;
		return this;
	}




	final public RangeBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.rangeImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public RangeBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.rangeImpl._description = _description_;
		return this;
	}


	final public RangeBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.rangeImpl._displayName = _displayName_;
		return this;
	}


	final public RangeBuilder _idShort_(String _idShort_) {
		this.rangeImpl._idShort = _idShort_;
		return this;
	}


	final public RangeBuilder _parent_(URI _parent_) {
		this.rangeImpl._parent = _parent_;
		return this;
	}


	final public RangeBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.rangeImpl._qualifier = _qualifier_;
		return this;
	}


	final public RangeBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.rangeImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public RangeBuilder _kind_(ModelingKind _kind_) {
		this.rangeImpl._kind = _kind_;
		return this;
	}


	final public RangeBuilder _semanticId_(Reference _semanticId_) {
		this.rangeImpl._semanticId = _semanticId_;
		return this;
	}

	public final Range build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(rangeImpl);
		return rangeImpl;
	}
}
