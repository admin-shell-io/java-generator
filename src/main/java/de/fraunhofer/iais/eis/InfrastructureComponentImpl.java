package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

/* The class of all infrastructure components of the IDS. */
public class InfrastructureComponentImpl implements InfrastructureComponent {

	private java.net.URL url;
	private boolean readOnly;

	// instance fields as derived from vocabulary

	private org.apache.jena.rdf.model.Literal title;

	private org.apache.jena.rdf.model.Literal description;

	private Participant createdBy;

	private Participant maintainedBy;

	// no manual construction
	InfrastructureComponentImpl() {
		url = VocabUtil.createRandomUrl("infrastructurecomponent");
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

	final public org.apache.jena.rdf.model.Literal getTitle() {
		return title;
	}
	final public void setTitle(org.apache.jena.rdf.model.Literal title) {
		assertModifiable();
		this.title = title;
	}
	

	final public org.apache.jena.rdf.model.Literal getDescription() {
		return description;
	}
	final public void setDescription(org.apache.jena.rdf.model.Literal description) {
		assertModifiable();
		this.description = description;
	}
	

	final public Participant getCreatedBy() {
		return createdBy;
	}
	final public void setCreatedBy(Participant createdBy) {
		assertModifiable();
		this.createdBy = createdBy;
	}
	

	final public Participant getCurator() {
		return maintainedBy;
	}
	final public void setCurator(Participant curator) {
		assertModifiable();
		this.maintainedBy = maintainedBy;
	}
	
}
