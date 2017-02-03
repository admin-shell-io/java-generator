package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class BrokerBuilder {

	private Broker broker;

	public BrokerBuilder() {
		broker = new BrokerImpl();
	}


	final public BrokerBuilder title(org.apache.jena.rdf.model.Literal title) {
		broker.setTitle(title);
		return this;
	}
	

	final public BrokerBuilder description(org.apache.jena.rdf.model.Literal description) {
		broker.setDescription(description);
		return this;
	}
	

	final public BrokerBuilder createdBy(Participant createdBy) {
		broker.setCreatedBy(createdBy);
		return this;
	}
	

	final public BrokerBuilder curator(Participant curator) {
		broker.setCurator(curator);
		return this;
	}
	

	public final Broker build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(broker);
		validationHook();
		broker.setReadOnly();
		return broker;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
