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

public class FormulaBuilder {

	private FormulaImpl formulaImpl;

	public FormulaBuilder() {
		formulaImpl = new FormulaImpl();
	}

	public FormulaBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		formulaImpl.id = id;
	}

	final public FormulaBuilder _dependsOn_(java.util.ArrayList<? extends Reference> _dependsOn_) {
		this.formulaImpl._dependsOn = _dependsOn_;
		return this;
	}


	public final Formula build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(formulaImpl);
		return formulaImpl;
	}
}
