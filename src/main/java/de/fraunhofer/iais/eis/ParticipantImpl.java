package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

/* A person or company using the Industrial Data Space */
public class ParticipantImpl implements Participant {

	private java.net.URL url;
	private boolean readOnly;

	// instance fields as derived from vocabulary

	private @javax.validation.constraints.NotNull org.apache.jena.rdf.model.Literal name;

	private Site primarySite;

	private String email;

	private java.net.URL homepage;


	// no manual construction
	ParticipantImpl() {
		url = VocabUtil.createRandomUrl("participant");
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

	final public @javax.validation.constraints.NotNull org.apache.jena.rdf.model.Literal getName() {
		return name;
	}
	final public void setName(@javax.validation.constraints.NotNull org.apache.jena.rdf.model.Literal name) {
		assertModifiable();
		this.name = name;
	}
	

	final public Site getPrimarySite() {
		return primarySite;
	}
	final public void setPrimarySite(Site primarySite) {
		assertModifiable();
		this.primarySite = primarySite;
	}
	

	final public String getEmail() {
		return email;
	}
	final public void setEmail(String Email) {
		assertModifiable();
		this.email = email;
	}
	

	final public java.net.URL getHomepage() {
		return homepage;
	}
	final public void setHomepage(java.net.URL Homepage) {
		assertModifiable();
		this.homepage = homepage;
	}
	

}
