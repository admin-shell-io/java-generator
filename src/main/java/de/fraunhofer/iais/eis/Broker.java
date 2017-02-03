package de.fraunhofer.iais.eis;

/* Broker holding an index of published data endpoints. */
public interface Broker extends InfrastructureComponent {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

}
