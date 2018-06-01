package de.fraunhofer.iais.eis.usage;

import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.junit.Assert;
import org.junit.Test;
import de.fraunhofer.iais.eis.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by christian on 19.06.17.
 */
public class PlainLiteralTest {

    @Test
    public void deserializeMessageContent() throws MalformedURLException, ConstraintViolationException {
        Assert.fail();
        /*
        Operation origOp = createOperation();
        Operation op = (Operation) VocabUtil.fromRdf(createBrokerDataRequest().getMessageContent());

        Assert.assertArrayEquals(origOp.getOpLabels().toArray(), op.getOpLabels().toArray());
        Assert.assertArrayEquals(origOp.getOpDescriptions().toArray(), op.getOpDescriptions().toArray());
        */
    }

    /*
    private BrokerDataRequest createBrokerDataRequest() throws ConstraintViolationException, MalformedURLException {
        return new BrokerDataRequestBuilder(new URL("http://example.org/brokerdatarequest/1"))
                .dataRequestAction(BrokerDataRequestAction.REGISTER)
                .messageContent(createOperation().toRdf())
                .coveredEntity(EntityCoveredByDataRequest.DATA_ENDPOINT)
                .build();
    }

    private Operation createOperation() throws MalformedURLException, ConstraintViolationException {
        return new ReadOperationBuilder(new URL("http://example.org/operation/1"))
                .opLabels(Arrays.asList(new PlainLiteral("label")))
                .opDescriptions(Arrays.asList(new PlainLiteral("desc1", "en"), new PlainLiteral("desc2")))
                .build();
    }
    */

}
