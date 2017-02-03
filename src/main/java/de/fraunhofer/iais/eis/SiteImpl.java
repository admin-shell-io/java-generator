package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

/* An office or other premise at which the organization is located */
public class SiteImpl implements Site {

	private java.net.URL url;
	private boolean readOnly;

	// instance fields as derived from vocabulary

	private String siteAddress;

	// no manual construction
	SiteImpl() {
		url = VocabUtil.createRandomUrl("site");
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

	final public String getSiteAddress() {
		return siteAddress;
	}
	final public void setSiteAddress(String siteAddress) {
		assertModifiable();
		this.siteAddress = siteAddress;
	}
	
}
