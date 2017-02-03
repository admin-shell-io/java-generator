package de.fraunhofer.iais.eis;

/* General property for additional description of security aspects of a data transfer. */
public interface TransferProperty {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

	@javax.validation.constraints.NotNull String getTransferPropertyKey();
	void setTransferPropertyKey(@javax.validation.constraints.NotNull String transferPropertyKey);
	

	@javax.validation.constraints.NotNull String getTransferPropertyValue();
	void setTransferPropertyValue(@javax.validation.constraints.NotNull String transferPropertyValue);
	
}
