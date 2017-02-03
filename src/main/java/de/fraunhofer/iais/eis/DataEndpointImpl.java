package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

/* Data Endpoint that provides a service interface. */
public class DataEndpointImpl implements DataEndpoint {

	private java.net.URL url;
	private boolean readOnly;

	// instance fields as derived from vocabulary

	private @javax.validation.constraints.NotNull de.fraunhofer.iais.eis.Connector providedBy;

	// no manual construction
	DataEndpointImpl() {
		url = VocabUtil.createRandomUrl("dataendpoint");
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

	final public @javax.validation.constraints.NotNull de.fraunhofer.iais.eis.Connector getProvidedBy() {
		return providedBy;
	}
	final public void setProvidedBy(@javax.validation.constraints.NotNull de.fraunhofer.iais.eis.Connector providedBy) {
		assertModifiable();
		this.providedBy = providedBy;
	}
	
}
