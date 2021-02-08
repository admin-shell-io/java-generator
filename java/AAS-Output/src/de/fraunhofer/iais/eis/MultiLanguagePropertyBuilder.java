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

public class MultiLanguagePropertyBuilder {

	private MultiLanguagePropertyImpl multiLanguagePropertyImpl;

	public MultiLanguagePropertyBuilder() {
		multiLanguagePropertyImpl = new MultiLanguagePropertyImpl();
	}

	public MultiLanguagePropertyBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		multiLanguagePropertyImpl.id = id;
	}

	final public MultiLanguagePropertyBuilder _value_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _value_) {
		this.multiLanguagePropertyImpl._value = _value_;
		return this;
	}


	final public MultiLanguagePropertyBuilder _valueId_(java.util.ArrayList<? extends Reference> _valueId_) {
		this.multiLanguagePropertyImpl._valueId = _valueId_;
		return this;
	}




	final public MultiLanguagePropertyBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.multiLanguagePropertyImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public MultiLanguagePropertyBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.multiLanguagePropertyImpl._description = _description_;
		return this;
	}


	final public MultiLanguagePropertyBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.multiLanguagePropertyImpl._displayName = _displayName_;
		return this;
	}


	final public MultiLanguagePropertyBuilder _idShort_(String _idShort_) {
		this.multiLanguagePropertyImpl._idShort = _idShort_;
		return this;
	}


	final public MultiLanguagePropertyBuilder _parent_(URI _parent_) {
		this.multiLanguagePropertyImpl._parent = _parent_;
		return this;
	}


	final public MultiLanguagePropertyBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.multiLanguagePropertyImpl._qualifier = _qualifier_;
		return this;
	}


	final public MultiLanguagePropertyBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.multiLanguagePropertyImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public MultiLanguagePropertyBuilder _kind_(ModelingKind _kind_) {
		this.multiLanguagePropertyImpl._kind = _kind_;
		return this;
	}


	final public MultiLanguagePropertyBuilder _semanticId_(Reference _semanticId_) {
		this.multiLanguagePropertyImpl._semanticId = _semanticId_;
		return this;
	}

	public final MultiLanguageProperty build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(multiLanguagePropertyImpl);
		return multiLanguagePropertyImpl;
	}
}
