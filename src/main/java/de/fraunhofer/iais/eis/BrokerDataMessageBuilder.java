package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class BrokerDataMessageBuilder {

	private BrokerDataMessage brokerDataMessage;

	public BrokerDataMessageBuilder() {
		brokerDataMessage = new BrokerDataMessageImpl();
	}


	final public BrokerDataMessageBuilder payload(@javax.validation.constraints.NotNull String payload) {
		brokerDataMessage.setPayload(payload);
		return this;
	}
	

	public final BrokerDataMessage build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(brokerDataMessage);
		validationHook();
		brokerDataMessage.setReadOnly();
		return brokerDataMessage;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
