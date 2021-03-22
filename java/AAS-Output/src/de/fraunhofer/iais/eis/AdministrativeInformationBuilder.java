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

public class AdministrativeInformationBuilder {

	private AdministrativeInformationImpl administrativeInformationImpl;

	public AdministrativeInformationBuilder() {
		administrativeInformationImpl = new AdministrativeInformationImpl();
	}

	public AdministrativeInformationBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		administrativeInformationImpl.id = id;
	}

	final public AdministrativeInformationBuilder _version_(String _version_) {
		this.administrativeInformationImpl._version = _version_;
		return this;
	}


	final public AdministrativeInformationBuilder _revision_(String _revision_) {
		this.administrativeInformationImpl._revision = _revision_;
		return this;
	}


	final public AdministrativeInformationBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.administrativeInformationImpl._dataSpecification = _dataSpecification_;
		return this;
	}

	public final AdministrativeInformation build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(administrativeInformationImpl);
		return administrativeInformationImpl;
	}
}
