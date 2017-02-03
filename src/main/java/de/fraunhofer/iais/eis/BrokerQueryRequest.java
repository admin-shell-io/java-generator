package de.fraunhofer.iais.eis;

/* The class of all messages that represent query requests to a Broker. */
public interface BrokerQueryRequest extends BrokerQueryMessage
, BrokerRequestMessage {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

	@javax.validation.constraints.NotNull BrokerQueryRequestAction getQueryRequestAction();
	void setQueryRequestAction(@javax.validation.constraints.NotNull BrokerQueryRequestAction queryRequestAction);
	
}
