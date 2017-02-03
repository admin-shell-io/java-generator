package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

/* General property for additional description of security aspects of a data transfer. */
public class TransferPropertyImpl implements TransferProperty {

	private java.net.URL url;
	private boolean readOnly;

	// instance fields as derived from vocabulary

	private @javax.validation.constraints.NotNull String transferPropertyKey;

	private @javax.validation.constraints.NotNull String transferPropertyValue;

	// no manual construction
	TransferPropertyImpl() {
		url = VocabUtil.createRandomUrl("transferproperty");
	}

	@Override
	final public java.net.URL getId() {
		return url;
	}

	@Override
	final public void setId(@javax.validation.constraints.NotNull java.net.URL url) {
		assertModifiable();
		this.url = url;
	}

	final public void setReadOnly() {
		readOnly = true;
	}

	private void assertModifiable() {
		if (readOnly) {
			throw new RuntimeException("object has been built and cannot be modified anymore");
		}
	}

	// accessor method implementations as derived from vocabulary

	final public @javax.validation.constraints.NotNull String getTransferPropertyKey() {
		return transferPropertyKey;
	}
	final public void setTransferPropertyKey(@javax.validation.constraints.NotNull String transferPropertyKey) {
		assertModifiable();
		this.transferPropertyKey = transferPropertyKey;
	}
	

	final public @javax.validation.constraints.NotNull String getTransferPropertyValue() {
		return transferPropertyValue;
	}
	final public void setTransferPropertyValue(@javax.validation.constraints.NotNull String transferPropertyValue) {
		assertModifiable();
		this.transferPropertyValue = transferPropertyValue;
	}
	
}
