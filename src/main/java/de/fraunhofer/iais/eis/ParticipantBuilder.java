package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.VocabUtil;

public class ParticipantBuilder {

	private Participant participant;

	public ParticipantBuilder() {
		participant = new ParticipantImpl();
	}

	final public ParticipantBuilder name(@javax.validation.constraints.NotNull org.apache.jena.rdf.model.Literal name) {
		participant.setName(name);
		return this;
	}
	

	final public ParticipantBuilder primarySite(Site primarySite) {
		participant.setPrimarySite(primarySite);
		return this;
	}
	

	final public ParticipantBuilder Email(String Email) {
		participant.setEmail(Email);
		return this;
	}
	

	final public ParticipantBuilder Homepage(java.net.URL Homepage) {
		participant.setHomepage(Homepage);
		return this;
	}
	


	public final Participant build() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		VocabUtil.validate(participant);
		validationHook();
		participant.setReadOnly();
		return participant;
	}


	public void validationHook() throws de.fraunhofer.iais.eis.util.ConstraintViolationException {
		// override me!
	}
}
