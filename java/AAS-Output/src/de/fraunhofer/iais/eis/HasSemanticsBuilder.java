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

public class HasSemanticsBuilder {

	private HasSemanticsImpl hasSemanticsImpl;

	public HasSemanticsBuilder() {
		hasSemanticsImpl = new HasSemanticsImpl();
	}

	public HasSemanticsBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		hasSemanticsImpl.id = id;
	}

	final public HasSemanticsBuilder _semanticId_(Reference _semanticId_) {
		this.hasSemanticsImpl._semanticId = _semanticId_;
		return this;
	}

	public final HasSemantics build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(hasSemanticsImpl);
		return hasSemanticsImpl;
	}
}
