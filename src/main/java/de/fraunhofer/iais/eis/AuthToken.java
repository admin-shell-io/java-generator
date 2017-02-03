package de.fraunhofer.iais.eis;

/* Authorization Token. */
public interface AuthToken {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

	@javax.validation.constraints.NotNull String getTokenValue();
	void setTokenValue(@javax.validation.constraints.NotNull String tokenValue);
	
}
