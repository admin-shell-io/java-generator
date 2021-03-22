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

public class IdentifierBuilder {

	private IdentifierImpl identifierImpl;

	public IdentifierBuilder() {
		identifierImpl = new IdentifierImpl();
	}

	public IdentifierBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		identifierImpl.id = id;
	}

	final public IdentifierBuilder _identifier_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _identifier_) {
		this.identifierImpl._identifier = _identifier_;
		return this;
	}


	final public IdentifierBuilder _idType_(IdentifierType _idType_) {
		this.identifierImpl._idType = _idType_;
		return this;
	}

	public final Identifier build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(identifierImpl);
		return identifierImpl;
	}
}
