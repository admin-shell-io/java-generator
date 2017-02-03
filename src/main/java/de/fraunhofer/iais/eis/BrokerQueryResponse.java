package de.fraunhofer.iais.eis;

/* The class of all messages that represent a Broker's response to a query. */
public interface BrokerQueryResponse extends BrokerQueryMessage
, BrokerResponseMessage {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

}
