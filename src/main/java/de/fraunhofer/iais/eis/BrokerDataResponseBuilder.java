package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class BrokerDataResponseBuilder {

	private BrokerDataResponse brokerDataResponse;

	public BrokerDataResponseBuilder() {
		brokerDataResponse = new BrokerDataResponseImpl();
	}



	final public BrokerDataResponseBuilder payload(@javax.validation.constraints.NotNull String payload) {
		brokerDataResponse.setPayload(payload);
		return this;
	}
	

	final public BrokerDataResponseBuilder correlationId(@javax.validation.constraints.NotNull java.net.URL correlationId) {
		brokerDataResponse.setCorrelationId(correlationId);
		return this;
	}
	

	public final BrokerDataResponse build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(brokerDataResponse);
		validationHook();
		brokerDataResponse.setReadOnly();
		return brokerDataResponse;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
