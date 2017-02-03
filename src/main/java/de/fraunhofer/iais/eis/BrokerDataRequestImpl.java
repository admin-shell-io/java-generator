package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

/* The class of all messages that represent data requests to a Broker. */
public class BrokerDataRequestImpl implements BrokerDataRequest {

	private java.net.URL url;
	private boolean readOnly;

	// instance fields as derived from vocabulary

	private @javax.validation.constraints.NotNull de.fraunhofer.iais.eis.BrokerDataRequestAction dataRequestAction;

	private @javax.validation.constraints.NotNull EntityCoveredByDataRequest coveredEntity;


	private @javax.validation.constraints.NotNull String payload;


	// no manual construction
	BrokerDataRequestImpl() {
		url = VocabUtil.createRandomUrl("brokerdatarequest");
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

	final public @javax.validation.constraints.NotNull de.fraunhofer.iais.eis.BrokerDataRequestAction getDataRequestAction() {
		return dataRequestAction;
	}
	final public void setDataRequestAction(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.BrokerDataRequestAction dataRequestAction) {
		assertModifiable();
		this.dataRequestAction = dataRequestAction;
	}
	

	final public @javax.validation.constraints.NotNull EntityCoveredByDataRequest getCoveredEntity() {
		return coveredEntity;
	}
	final public void setCoveredEntity(@javax.validation.constraints.NotNull EntityCoveredByDataRequest coveredEntity) {
		assertModifiable();
		this.coveredEntity = coveredEntity;
	}
	


	final public @javax.validation.constraints.NotNull String getPayload() {
		return payload;
	}
	final public void setPayload(@javax.validation.constraints.NotNull String payload) {
		assertModifiable();
		this.payload = payload;
	}
	

}
