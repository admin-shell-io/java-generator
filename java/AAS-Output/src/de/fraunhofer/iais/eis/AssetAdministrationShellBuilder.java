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

public class AssetAdministrationShellBuilder {

	private AssetAdministrationShellImpl assetAdministrationShellImpl;

	public AssetAdministrationShellBuilder() {
		assetAdministrationShellImpl = new AssetAdministrationShellImpl();
	}

	public AssetAdministrationShellBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		assetAdministrationShellImpl.id = id;
	}

	final public AssetAdministrationShellBuilder _assetInformation_(AssetInformation _assetInformation_) {
		this.assetAdministrationShellImpl._assetInformation = _assetInformation_;
		return this;
	}


	final public AssetAdministrationShellBuilder _derivedFrom_(Reference _derivedFrom_) {
		this.assetAdministrationShellImpl._derivedFrom = _derivedFrom_;
		return this;
	}


	final public AssetAdministrationShellBuilder _security_(Security _security_) {
		this.assetAdministrationShellImpl._security = _security_;
		return this;
	}


	final public AssetAdministrationShellBuilder _submodel_(java.util.ArrayList<? extends Submodel> _submodel_) {
		this.assetAdministrationShellImpl._submodel = _submodel_;
		return this;
	}


	final public AssetAdministrationShellBuilder _view_(java.util.ArrayList<? extends View> _view_) {
		this.assetAdministrationShellImpl._view = _view_;
		return this;
	}


	final public AssetAdministrationShellBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.assetAdministrationShellImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public AssetAdministrationShellBuilder _administration_(AdministrativeInformation _administration_) {
		this.assetAdministrationShellImpl._administration = _administration_;
		return this;
	}


	final public AssetAdministrationShellBuilder _identification_(Identifier _identification_) {
		this.assetAdministrationShellImpl._identification = _identification_;
		return this;
	}


	final public AssetAdministrationShellBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.assetAdministrationShellImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public AssetAdministrationShellBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.assetAdministrationShellImpl._description = _description_;
		return this;
	}


	final public AssetAdministrationShellBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.assetAdministrationShellImpl._displayName = _displayName_;
		return this;
	}


	final public AssetAdministrationShellBuilder _idShort_(String _idShort_) {
		this.assetAdministrationShellImpl._idShort = _idShort_;
		return this;
	}


	final public AssetAdministrationShellBuilder _parent_(URI _parent_) {
		this.assetAdministrationShellImpl._parent = _parent_;
		return this;
	}

	public final AssetAdministrationShell build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(assetAdministrationShellImpl);
		return assetAdministrationShellImpl;
	}
}
