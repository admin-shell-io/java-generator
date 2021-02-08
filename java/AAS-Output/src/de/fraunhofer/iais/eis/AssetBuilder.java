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

public class AssetBuilder {

	private AssetImpl assetImpl;

	public AssetBuilder() {
		assetImpl = new AssetImpl();
	}

	public AssetBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		assetImpl.id = id;
	}


	final public AssetBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.assetImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public AssetBuilder _administration_(AdministrativeInformation _administration_) {
		this.assetImpl._administration = _administration_;
		return this;
	}


	final public AssetBuilder _identification_(Identifier _identification_) {
		this.assetImpl._identification = _identification_;
		return this;
	}


	final public AssetBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.assetImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public AssetBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.assetImpl._description = _description_;
		return this;
	}


	final public AssetBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.assetImpl._displayName = _displayName_;
		return this;
	}


	final public AssetBuilder _idShort_(String _idShort_) {
		this.assetImpl._idShort = _idShort_;
		return this;
	}


	final public AssetBuilder _parent_(URI _parent_) {
		this.assetImpl._parent = _parent_;
		return this;
	}

	public final Asset build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(assetImpl);
		return assetImpl;
	}
}
