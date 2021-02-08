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

public class EntityBuilder {

	private EntityImpl entityImpl;

	public EntityBuilder() {
		entityImpl = new EntityImpl();
	}

	public EntityBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		entityImpl.id = id;
	}

	final public EntityBuilder _globalAssetId_(Reference _globalAssetId_) {
		this.entityImpl._globalAssetId = _globalAssetId_;
		return this;
	}


	final public EntityBuilder _externalAssetId_(IdentifierKeyValuePair _externalAssetId_) {
		this.entityImpl._externalAssetId = _externalAssetId_;
		return this;
	}


	final public EntityBuilder _entityType_(EntityType _entityType_) {
		this.entityImpl._entityType = _entityType_;
		return this;
	}


	final public EntityBuilder _statement_(java.util.ArrayList<? extends SubmodelElement> _statement_) {
		this.entityImpl._statement = _statement_;
		return this;
	}



	final public EntityBuilder _referableCategory_(java.util.ArrayList<? extends String> _referableCategory_) {
		this.entityImpl._referableCategory = _referableCategory_;
		return this;
	}


	final public EntityBuilder _description_(java.util.ArrayList<? extends de.fraunhofer.iais.eis.util.TypedLiteral> _description_) {
		this.entityImpl._description = _description_;
		return this;
	}


	final public EntityBuilder _displayName_(de.fraunhofer.iais.eis.util.TypedLiteral _displayName_) {
		this.entityImpl._displayName = _displayName_;
		return this;
	}


	final public EntityBuilder _idShort_(String _idShort_) {
		this.entityImpl._idShort = _idShort_;
		return this;
	}


	final public EntityBuilder _parent_(URI _parent_) {
		this.entityImpl._parent = _parent_;
		return this;
	}


	final public EntityBuilder _qualifier_(java.util.ArrayList<? extends Constraint> _qualifier_) {
		this.entityImpl._qualifier = _qualifier_;
		return this;
	}


	final public EntityBuilder _dataSpecification_(java.util.ArrayList<? extends Reference> _dataSpecification_) {
		this.entityImpl._dataSpecification = _dataSpecification_;
		return this;
	}


	final public EntityBuilder _kind_(ModelingKind _kind_) {
		this.entityImpl._kind = _kind_;
		return this;
	}


	final public EntityBuilder _semanticId_(Reference _semanticId_) {
		this.entityImpl._semanticId = _semanticId_;
		return this;
	}

	public final Entity build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(entityImpl);
		return entityImpl;
	}
}
