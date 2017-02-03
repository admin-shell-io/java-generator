package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class BrokerQueryMessageBuilder {

	private BrokerQueryMessage brokerQueryMessage;

	public BrokerQueryMessageBuilder() {
		brokerQueryMessage = new BrokerQueryMessageImpl();
	}

	final public BrokerQueryMessageBuilder queryScope(@javax.validation.constraints.NotNull BrokerQueryMessageScope queryScope) {
		brokerQueryMessage.setQueryScope(queryScope);
		return this;
	}
	

	final public BrokerQueryMessageBuilder payload(@javax.validation.constraints.NotNull String payload) {
		brokerQueryMessage.setPayload(payload);
		return this;
	}
	

	public final BrokerQueryMessage build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(brokerQueryMessage);
		validationHook();
		brokerQueryMessage.setReadOnly();
		return brokerQueryMessage;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
