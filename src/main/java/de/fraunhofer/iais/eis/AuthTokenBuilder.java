package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class AuthTokenBuilder {

	private AuthToken authToken;

	public AuthTokenBuilder() {
		authToken = new AuthTokenImpl();
	}

	final public AuthTokenBuilder tokenValue(@javax.validation.constraints.NotNull String tokenValue) {
		authToken.setTokenValue(tokenValue);
		return this;
	}
	

	public final AuthToken build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(authToken);
		validationHook();
		authToken.setReadOnly();
		return authToken;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
