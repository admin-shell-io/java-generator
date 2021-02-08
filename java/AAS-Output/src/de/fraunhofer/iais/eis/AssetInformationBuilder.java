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

public class AssetInformationBuilder {

	private AssetInformationImpl assetInformationImpl;

	public AssetInformationBuilder() {
		assetInformationImpl = new AssetInformationImpl();
	}

	public AssetInformationBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		assetInformationImpl.id = id;
	}

	final public AssetInformationBuilder _assetKind_(java.util.ArrayList<? extends AssetKind> _assetKind_) {
		this.assetInformationImpl._assetKind = _assetKind_;
		return this;
	}


	final public AssetInformationBuilder _globalAssetId_(Reference _globalAssetId_) {
		this.assetInformationImpl._globalAssetId = _globalAssetId_;
		return this;
	}


	final public AssetInformationBuilder _externalAssetId_(java.util.ArrayList<? extends IdentifierKeyValuePair> _externalAssetId_) {
		this.assetInformationImpl._externalAssetId = _externalAssetId_;
		return this;
	}


	final public AssetInformationBuilder _billOfMaterial_(java.util.ArrayList<? extends Submodel> _billOfMaterial_) {
		this.assetInformationImpl._billOfMaterial = _billOfMaterial_;
		return this;
	}


	final public AssetInformationBuilder _thumbnail_(File _thumbnail_) {
		this.assetInformationImpl._thumbnail = _thumbnail_;
		return this;
	}

	public final AssetInformation build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(assetInformationImpl);
		return assetInformationImpl;
	}
}
