package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class BrokerQueryRequestBuilder {

	private BrokerQueryRequest brokerQueryRequest;

	public BrokerQueryRequestBuilder() {
		brokerQueryRequest = new BrokerQueryRequestImpl();
	}

	final public BrokerQueryRequestBuilder queryRequestAction(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.BrokerQueryRequestAction queryRequestAction) {
		brokerQueryRequest.setQueryRequestAction(queryRequestAction);
		return this;
	}
	

	final public BrokerQueryRequestBuilder queryScope(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.BrokerQueryMessageScope queryScope) {
		brokerQueryRequest.setQueryScope(queryScope);
		return this;
	}
	

	final public BrokerQueryRequestBuilder payload(@javax.validation.constraints.NotNull String payload) {
		brokerQueryRequest.setPayload(payload);
		return this;
	}
	


	public final BrokerQueryRequest build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(brokerQueryRequest);
		validationHook();
		brokerQueryRequest.setReadOnly();
		return brokerQueryRequest;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
