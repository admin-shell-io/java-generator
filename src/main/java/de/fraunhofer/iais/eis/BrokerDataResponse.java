package de.fraunhofer.iais.eis;

/* The class of all messages that represent data responses of a Broker. */
public interface BrokerDataResponse extends BrokerDataMessage
, BrokerResponseMessage {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

}
