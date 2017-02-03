package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class BrokerDataRequestBuilder {

	private BrokerDataRequest brokerDataRequest;

	public BrokerDataRequestBuilder() {
		brokerDataRequest = new BrokerDataRequestImpl();
	}

	final public BrokerDataRequestBuilder dataRequestAction(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.BrokerDataRequestAction dataRequestAction) {
		brokerDataRequest.setDataRequestAction(dataRequestAction);
		return this;
	}
	

	final public BrokerDataRequestBuilder coveredEntity(@javax.validation.constraints.NotNull EntityCoveredByDataRequest coveredEntity) {
		brokerDataRequest.setCoveredEntity(coveredEntity);
		return this;
	}
	


	final public BrokerDataRequestBuilder payload(@javax.validation.constraints.NotNull String payload) {
		brokerDataRequest.setPayload(payload);
		return this;
	}
	


	public final BrokerDataRequest build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(brokerDataRequest);
		validationHook();
		brokerDataRequest.setReadOnly();
		return brokerDataRequest;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
