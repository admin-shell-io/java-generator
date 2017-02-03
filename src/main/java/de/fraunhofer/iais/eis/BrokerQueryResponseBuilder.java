package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class BrokerQueryResponseBuilder {

	private BrokerQueryResponse brokerQueryResponse;

	public BrokerQueryResponseBuilder() {
		brokerQueryResponse = new BrokerQueryResponseImpl();
	}


	final public BrokerQueryResponseBuilder queryScope(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.BrokerQueryMessageScope queryScope) {
		brokerQueryResponse.setQueryScope(queryScope);
		return this;
	}
	

	final public BrokerQueryResponseBuilder payload(@javax.validation.constraints.NotNull String payload) {
		brokerQueryResponse.setPayload(payload);
		return this;
	}
	

	final public BrokerQueryResponseBuilder correlationId(@javax.validation.constraints.NotNull java.net.URL correlationId) {
		brokerQueryResponse.setCorrelationId(correlationId);
		return this;
	}
	

	public final BrokerQueryResponse build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(brokerQueryResponse);
		validationHook();
		brokerQueryResponse.setReadOnly();
		return brokerQueryResponse;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
