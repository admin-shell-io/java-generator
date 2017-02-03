package de.fraunhofer.iais.eis;

/* The class of all messages intended for data transfer to/from a Broker. */
public interface BrokerDataMessage extends BrokerMessage {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

}
