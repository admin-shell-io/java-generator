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

public class BlobCertificateBuilder {

	private BlobCertificateImpl blobCertificateImpl;

	public BlobCertificateBuilder() {
		blobCertificateImpl = new BlobCertificateImpl();
	}

	public BlobCertificateBuilder(@javax.validation.constraints.NotNull URI id) {
		this();
		blobCertificateImpl.id = id;
	}

	final public BlobCertificateBuilder _blobCertificate_(java.util.ArrayList<? extends Byte> _blobCertificate_) {
		this.blobCertificateImpl._blobCertificate = _blobCertificate_;
		return this;
	}


	final public BlobCertificateBuilder _containedExtension_(java.util.ArrayList<? extends Reference> _containedExtension_) {
		this.blobCertificateImpl._containedExtension = _containedExtension_;
		return this;
	}


	final public BlobCertificateBuilder _lastCertificate_(java.util.ArrayList<? extends Boolean> _lastCertificate_) {
		this.blobCertificateImpl._lastCertificate = _lastCertificate_;
		return this;
	}


	final public BlobCertificateBuilder _policyAdministrationPoint_(PolicyAdministrationPoint _policyAdministrationPoint_) {
		this.blobCertificateImpl._policyAdministrationPoint = _policyAdministrationPoint_;
		return this;
	}

	public final BlobCertificate build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(blobCertificateImpl);
		return blobCertificateImpl;
	}
}
