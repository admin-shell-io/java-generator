package de.fraunhofer.iais.eis;

/* Connector for hosting data services. */
public interface Connector extends InfrastructureComponent {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

}
