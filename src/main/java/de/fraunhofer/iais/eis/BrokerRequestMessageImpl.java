package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

/* The class of all messages that represent requests to a Broker. */
public class BrokerRequestMessageImpl implements BrokerRequestMessage {

	private java.net.URL url;
	private boolean readOnly;

	// instance fields as derived from vocabulary


	private @javax.validation.constraints.NotNull String payload;

	// no manual construction
	BrokerRequestMessageImpl() {
		url = VocabUtil.createRandomUrl("brokerrequestmessage");
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


	final public @javax.validation.constraints.NotNull String getPayload() {
		return payload;
	}
	final public void setPayload(@javax.validation.constraints.NotNull String payload) {
		assertModifiable();
		this.payload = payload;
	}
	
}
