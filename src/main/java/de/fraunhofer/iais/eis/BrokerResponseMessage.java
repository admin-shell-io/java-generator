package de.fraunhofer.iais.eis;

/* The class of all messages that represent responses of a Broker. */
public interface BrokerResponseMessage extends BrokerMessage {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

	@javax.validation.constraints.NotNull java.net.URL getCorrelationId();
	void setCorrelationId(@javax.validation.constraints.NotNull java.net.URL correlationId);
	
}
