package de.fraunhofer.iais.eis;

/* The class of all messages to interact with a Broker. */
public interface BrokerMessage {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

	@javax.validation.constraints.NotNull String getPayload();
	void setPayload(@javax.validation.constraints.NotNull String payload);
	
}
