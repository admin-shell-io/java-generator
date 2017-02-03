package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class InfrastructureComponentBuilder {

	private InfrastructureComponent infrastructureComponent;

	public InfrastructureComponentBuilder() {
		infrastructureComponent = new InfrastructureComponentImpl();
	}

	final public InfrastructureComponentBuilder title(org.apache.jena.rdf.model.Literal title) {
		infrastructureComponent.setTitle(title);
		return this;
	}
	

	final public InfrastructureComponentBuilder description(org.apache.jena.rdf.model.Literal description) {
		infrastructureComponent.setDescription(description);
		return this;
	}
	

	final public InfrastructureComponentBuilder createdBy(Participant createdBy) {
		infrastructureComponent.setCreatedBy(createdBy);
		return this;
	}
	

	final public InfrastructureComponentBuilder curator(Participant curator) {
		infrastructureComponent.setCurator(curator);
		return this;
	}
	

	public final InfrastructureComponent build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(infrastructureComponent);
		validationHook();
		infrastructureComponent.setReadOnly();
		return infrastructureComponent;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
