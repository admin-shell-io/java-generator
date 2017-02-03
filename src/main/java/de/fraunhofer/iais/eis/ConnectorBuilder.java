package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class ConnectorBuilder {

	private Connector connector;

	public ConnectorBuilder() {
		connector = new ConnectorImpl();
	}


	final public ConnectorBuilder title(org.apache.jena.rdf.model.Literal title) {
		connector.setTitle(title);
		return this;
	}
	

	final public ConnectorBuilder description(org.apache.jena.rdf.model.Literal description) {
		connector.setDescription(description);
		return this;
	}
	

	final public ConnectorBuilder createdBy(Participant createdBy) {
		connector.setCreatedBy(createdBy);
		return this;
	}
	

	final public ConnectorBuilder curator(Participant curator) {
		connector.setCurator(curator);
		return this;
	}
	

	public final Connector build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(connector);
		validationHook();
		connector.setReadOnly();
		return connector;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
