package de.fraunhofer.iais.eis;

/* An office or other premise at which the organization is located */
public interface Site {

	// standard methods

	@javax.validation.constraints.NotNull java.net.URL getId();
	void setId(@javax.validation.constraints.NotNull java.net.URL url);

	void setReadOnly();

	// accessor methods as derived from vocabulary

	String getSiteAddress();
	void setSiteAddress(String siteAddress);
	
}
