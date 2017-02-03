package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class TransferredDatasetBuilder {

	private TransferredDataset transferredDataset;

	public TransferredDatasetBuilder() {
		transferredDataset = new TransferredDatasetImpl();
	}

	final public TransferredDatasetBuilder customProperty(java.util.Collection<de.fraunhofer.iais.eis.TransferProperty> customProperty) {
		transferredDataset.setCustomProperty(customProperty);
		return this;
	}
	

	final public TransferredDatasetBuilder sender(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.DataEndpoint sender) {
		transferredDataset.setSender(sender);
		return this;
	}
	

	final public TransferredDatasetBuilder receiver(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.DataEndpoint receiver) {
		transferredDataset.setReceiver(receiver);
		return this;
	}
	

	final public TransferredDatasetBuilder authToken(de.fraunhofer.iais.eis.AuthToken authToken) {
		transferredDataset.setAuthToken(authToken);
		return this;
	}
	

	final public TransferredDatasetBuilder digest(byte[] digest) {
		transferredDataset.setDigest(digest);
		return this;
	}
	

	final public TransferredDatasetBuilder mediaType(@org.hibernate.validator.constraints.URL String mediaType) {
		transferredDataset.setMediaType(mediaType);
		return this;
	}
	

	final public TransferredDatasetBuilder creationDate(@javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar creationDate) {
		transferredDataset.setCreationDate(creationDate);
		return this;
	}
	

	final public TransferredDatasetBuilder format(String format) {
		transferredDataset.setFormat(format);
		return this;
	}
	

	final public TransferredDatasetBuilder version(String version) {
		transferredDataset.setVersion(version);
		return this;
	}
	


	public final TransferredDataset build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(transferredDataset);
		validationHook();
		transferredDataset.setReadOnly();
		return transferredDataset;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
