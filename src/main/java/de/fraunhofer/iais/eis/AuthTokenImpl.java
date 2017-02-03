package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

/* Authorization Token. */
public class AuthTokenImpl implements AuthToken {

	private java.net.URL url;
	private boolean readOnly;

	// instance fields as derived from vocabulary

	private @javax.validation.constraints.NotNull String tokenValue;

	// no manual construction
	AuthTokenImpl() {
		url = VocabUtil.createRandomUrl("authtoken");
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

	final public @javax.validation.constraints.NotNull String getTokenValue() {
		return tokenValue;
	}
	final public void setTokenValue(@javax.validation.constraints.NotNull String tokenValue) {
		assertModifiable();
		this.tokenValue = tokenValue;
	}
	
}
