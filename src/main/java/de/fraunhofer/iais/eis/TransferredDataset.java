package de.fraunhofer.iais.eis;

/* The class of resources that describe a dataset transfered by an IDS communication in a protocol frame. */
public interface TransferredDataset extends Dataset {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

	java.util.Collection<de.fraunhofer.iais.eis.TransferProperty> getCustomProperty();
	void setCustomProperty(java.util.Collection<de.fraunhofer.iais.eis.TransferProperty> customProperty);
	

	@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.DataEndpoint getSender();
	void setSender(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.DataEndpoint sender);
	

	@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.DataEndpoint getReceiver();
	void setReceiver(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.DataEndpoint receiver);
	

	de.fraunhofer.iais.eis.AuthToken getAuthToken();
	void setAuthToken(de.fraunhofer.iais.eis.AuthToken authToken);
	

	byte[] getDigest();
	void setDigest(byte[] digest);
	
}
