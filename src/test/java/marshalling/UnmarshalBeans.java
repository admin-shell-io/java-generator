package marshalling;

import de.fraunhofer.iais.eis.AuthTokenBuilder;
import de.fraunhofer.iais.eis.DataTransfer;
import de.fraunhofer.iais.eis.DataTransferBuilder;
import de.fraunhofer.iais.eis.HashFunction;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.testng.annotations.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.GregorianCalendar;

/**
 * Created by christian on 19.05.17.
 */
public class UnmarshalBeans {

    @Test
    public void dataTransfer() throws MalformedURLException, DatatypeConfigurationException, ConstraintViolationException {
        byte[] digest = "xxx".getBytes(Charset.defaultCharset());

        HashFunction hashFunction = HashFunction.SHA_512;
        DataTransfer header = new DataTransferBuilder()
            .sender(new URL("http://www.fraunhofer.de/Broker"))
            .receiver(new URL("http://www.fraunhofer.de/Broker"))
            .transferCreatedAt(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()))
            .hashFunction(hashFunction)
//            .digest(digest)
            .authToken(new AuthTokenBuilder().tokenValue("token").build())
            .build();
        String serializedHeader = header.toRdf();
        System.out.println(serializedHeader);


        DataTransfer deserializedHeader = (DataTransfer) VocabUtil.fromRdf(serializedHeader);

        System.out.println("xxxx");
    }

}
