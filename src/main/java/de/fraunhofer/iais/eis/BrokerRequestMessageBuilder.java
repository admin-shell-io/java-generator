package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class BrokerRequestMessageBuilder {

	private BrokerRequestMessage brokerRequestMessage;

	public BrokerRequestMessageBuilder() {
		brokerRequestMessage = new BrokerRequestMessageImpl();
	}


	final public BrokerRequestMessageBuilder payload(@javax.validation.constraints.NotNull String payload) {
		brokerRequestMessage.setPayload(payload);
		return this;
	}
	

	public final BrokerRequestMessage build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(brokerRequestMessage);
		validationHook();
		brokerRequestMessage.setReadOnly();
		return brokerRequestMessage;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
