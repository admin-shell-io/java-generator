package de.fraunhofer.iais.eis;

/* The class of all messages that represent data requests to a Broker. */
public interface BrokerDataRequest extends BrokerDataMessage
, BrokerRequestMessage {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

	@javax.validation.constraints.NotNull BrokerDataRequestAction getDataRequestAction();
	void setDataRequestAction(@javax.validation.constraints.NotNull BrokerDataRequestAction dataRequestAction);
	

	@javax.validation.constraints.NotNull EntityCoveredByDataRequest getCoveredEntity();
	void setCoveredEntity(@javax.validation.constraints.NotNull EntityCoveredByDataRequest coveredEntity);
	
}
