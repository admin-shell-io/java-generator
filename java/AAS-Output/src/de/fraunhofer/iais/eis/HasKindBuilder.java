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

public class HasKindBuilder {

	private HasKindImpl hasKindImpl;

	public HasKindBuilder() {
		hasKindImpl = new HasKindImpl();
	}

	public HasKindBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		hasKindImpl.id = id;
	}

	final public HasKindBuilder _kind_(ModelingKind _kind_) {
		this.hasKindImpl._kind = _kind_;
		return this;
	}

	public final HasKind build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(hasKindImpl);
		return hasKindImpl;
	}
}
