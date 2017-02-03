package de.fraunhofer.iais.eis;

/* A person or company using the Industrial Data Space */
public interface Participant {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

	@javax.validation.constraints.NotNull org.apache.jena.rdf.model.Literal getName();
	void setName(@javax.validation.constraints.NotNull org.apache.jena.rdf.model.Literal name);
	

	Site getPrimarySite();
	void setPrimarySite(Site primarySite);
	

	String getEmail();
	void setEmail(String Email);
	

	java.net.URL getHomepage();
	void setHomepage(java.net.URL Homepage);
	
}
