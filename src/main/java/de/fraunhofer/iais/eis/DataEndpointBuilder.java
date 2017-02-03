package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class DataEndpointBuilder {

	private DataEndpoint dataEndpoint;

	public DataEndpointBuilder() {
		dataEndpoint = new DataEndpointImpl();
	}

	final public DataEndpointBuilder providedBy(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.Connector providedBy) {
		dataEndpoint.setProvidedBy(providedBy);
		return this;
	}
	

	public final DataEndpoint build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(dataEndpoint);
		validationHook();
		dataEndpoint.setReadOnly();
		return dataEndpoint;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
