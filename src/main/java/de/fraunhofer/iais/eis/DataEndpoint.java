package de.fraunhofer.iais.eis;

/* Data Endpoint that provides a service interface. */
public interface DataEndpoint {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

	@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.Connector getProvidedBy();
	void setProvidedBy(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.Connector providedBy);
	
}
