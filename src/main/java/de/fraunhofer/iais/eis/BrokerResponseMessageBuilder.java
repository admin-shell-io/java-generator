package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class BrokerResponseMessageBuilder {

	private BrokerResponseMessage brokerResponseMessage;

	public BrokerResponseMessageBuilder() {
		brokerResponseMessage = new BrokerResponseMessageImpl();
	}

	final public BrokerResponseMessageBuilder correlationId(@javax.validation.constraints.NotNull java.net.URL correlationId) {
		brokerResponseMessage.setCorrelationId(correlationId);
		return this;
	}
	

	final public BrokerResponseMessageBuilder payload(@javax.validation.constraints.NotNull String payload) {
		brokerResponseMessage.setPayload(payload);
		return this;
	}
	

	public final BrokerResponseMessage build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(brokerResponseMessage);
		validationHook();
		brokerResponseMessage.setReadOnly();
		return brokerResponseMessage;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
