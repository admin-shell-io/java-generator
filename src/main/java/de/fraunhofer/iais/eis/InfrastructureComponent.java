package de.fraunhofer.iais.eis;

/* The class of all infrastructure components of the IDS. */
public interface InfrastructureComponent {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

	org.apache.jena.rdf.model.Literal getTitle();
	void setTitle(org.apache.jena.rdf.model.Literal title);
	

	org.apache.jena.rdf.model.Literal getDescription();
	void setDescription(org.apache.jena.rdf.model.Literal description);
	

	Participant getCreatedBy();
	void setCreatedBy(Participant createdBy);
	

	Participant getCurator();
	void setCurator(Participant curator);
	
}
