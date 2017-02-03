package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class SiteBuilder {

	private Site site;

	public SiteBuilder() {
		site = new SiteImpl();
	}

	final public SiteBuilder siteAddress(String siteAddress) {
		site.setSiteAddress(siteAddress);
		return this;
	}
	

	public final Site build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(site);
		validationHook();
		site.setReadOnly();
		return site;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
