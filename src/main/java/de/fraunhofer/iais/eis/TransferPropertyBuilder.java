package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class TransferPropertyBuilder {

	private TransferProperty transferProperty;

	public TransferPropertyBuilder() {
		transferProperty = new TransferPropertyImpl();
	}

	final public TransferPropertyBuilder transferPropertyKey(@javax.validation.constraints.NotNull String transferPropertyKey) {
		transferProperty.setTransferPropertyKey(transferPropertyKey);
		return this;
	}
	

	final public TransferPropertyBuilder transferPropertyValue(@javax.validation.constraints.NotNull String transferPropertyValue) {
		transferProperty.setTransferPropertyValue(transferPropertyValue);
		return this;
	}
	

	public final TransferProperty build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(transferProperty);
		validationHook();
		transferProperty.setReadOnly();
		return transferProperty;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
