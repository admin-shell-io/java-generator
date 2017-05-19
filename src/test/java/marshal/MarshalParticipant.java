package marshal;

import de.fraunhofer.iais.eis.Participant;
import de.fraunhofer.iais.eis.ParticipantBuilder;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by christian on 19.05.17.
 */
public class MarshalParticipant {

    @Test
    public void marshalParticipant() throws MalformedURLException, ConstraintViolationException {
        ParticipantBuilder participantBuilder = new ParticipantBuilder(new URL("http://www.isst.fraunhofer.de"))
                .entityNames(Arrays.asList((new PlainLiteral("Fraunhofer ISST"))))
                .entityDescriptions(Arrays.asList(new PlainLiteral("Fraunhofer ISST - Dortmund - Germany")));
        Participant participant = participantBuilder.build();
        String rdf = participant.toRdf();
        System.out.println(rdf);
    }

}
