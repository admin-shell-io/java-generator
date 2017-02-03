package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class BrokerMessageBuilder {

	private BrokerMessage brokerMessage;

	public BrokerMessageBuilder() {
		brokerMessage = new BrokerMessageImpl();
	}

	final public BrokerMessageBuilder payload(@javax.validation.constraints.NotNull String payload) {
		brokerMessage.setPayload(payload);
		return this;
	}
	

	public final BrokerMessage build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(brokerMessage);
		validationHook();
		brokerMessage.setReadOnly();
		return brokerMessage;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
