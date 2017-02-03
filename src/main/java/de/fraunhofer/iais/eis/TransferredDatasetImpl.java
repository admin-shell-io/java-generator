package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

/* The class of resources that describe a dataset transfered by an IDS communication in a protocol frame. */
public class TransferredDatasetImpl implements TransferredDataset {

	private java.net.URL url;
	private boolean readOnly;

	// instance fields as derived from vocabulary

	private java.util.Collection<de.fraunhofer.iais.eis.TransferProperty> customProperty;

	private @javax.validation.constraints.NotNull de.fraunhofer.iais.eis.DataEndpoint sender;

	private @javax.validation.constraints.NotNull de.fraunhofer.iais.eis.DataEndpoint receiver;

	private de.fraunhofer.iais.eis.AuthToken authToken;

	private byte[] payloadDigest;

	private @org.hibernate.validator.constraints.URL String mediaType;

	private @javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar creationDate;

	private String format;

	private String version;


	// no manual construction
	TransferredDatasetImpl() {
		url = VocabUtil.createRandomUrl("transferreddataset");
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

	final public java.util.Collection<de.fraunhofer.iais.eis.TransferProperty> getCustomProperty() {
		return customProperty;
	}
	final public void setCustomProperty(java.util.Collection<de.fraunhofer.iais.eis.TransferProperty> customProperty) {
		assertModifiable();
		this.customProperty = customProperty;
	}
	

	final public @javax.validation.constraints.NotNull de.fraunhofer.iais.eis.DataEndpoint getSender() {
		return sender;
	}
	final public void setSender(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.DataEndpoint sender) {
		assertModifiable();
		this.sender = sender;
	}
	

	final public @javax.validation.constraints.NotNull de.fraunhofer.iais.eis.DataEndpoint getReceiver() {
		return receiver;
	}
	final public void setReceiver(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.DataEndpoint receiver) {
		assertModifiable();
		this.receiver = receiver;
	}
	

	final public de.fraunhofer.iais.eis.AuthToken getAuthToken() {
		return authToken;
	}
	final public void setAuthToken(de.fraunhofer.iais.eis.AuthToken authToken) {
		assertModifiable();
		this.authToken = authToken;
	}
	

	final public byte[] getDigest() {
		return payloadDigest;
	}
	final public void setDigest(byte[] digest) {
		assertModifiable();
		this.payloadDigest = payloadDigest;
	}
	

	final public @org.hibernate.validator.constraints.URL String getMediaType() {
		return mediaType;
	}
	final public void setMediaType(@org.hibernate.validator.constraints.URL String mediaType) {
		assertModifiable();
		this.mediaType = mediaType;
	}
	

	final public @javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar getCreationDate() {
		return creationDate;
	}
	final public void setCreationDate(@javax.validation.constraints.NotNull javax.xml.datatype.XMLGregorianCalendar creationDate) {
		assertModifiable();
		this.creationDate = creationDate;
	}
	

	final public String getFormat() {
		return format;
	}
	final public void setFormat(String format) {
		assertModifiable();
		this.format = format;
	}
	

	final public String getVersion() {
		return version;
	}
	final public void setVersion(String version) {
		assertModifiable();
		this.version = version;
	}
	

}
