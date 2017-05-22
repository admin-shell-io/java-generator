package usage;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.GregorianCalendar;

/**
 * Created by christian on 22.05.17.
 */
public class DataTransferUsage {

    @Test
    public void dataTransferSerialization() throws MalformedURLException, DatatypeConfigurationException, ConstraintViolationException {
        String serializedHeader = createDataTransfer().toRdf();
        System.out.println(serializedHeader);

        Model model = TestUtil.createModelFromRdf(serializedHeader);
        Resource transfer = model.createResource("http://example.org/transfer/1");
        Property authTokenProperty = model.createProperty("http://industrialdataspace.org/2016/10/ids/core#authToken");
        Property hashFuncProperty = model.createProperty("http://industrialdataspace.org/2016/10/ids/core#hashFunction");
        Property recvProperty = model.createProperty("http://industrialdataspace.org/2016/10/ids/core#receiver");
        Property sendProperty = model.createProperty("http://industrialdataspace.org/2016/10/ids/core#sender");
        Property creatProperty = model.createProperty("http://industrialdataspace.org/2016/10/ids/core#transferCreatedAt");

        for (Property property : Arrays.asList(authTokenProperty, hashFuncProperty, recvProperty, sendProperty, creatProperty)) {
            Assert.assertTrue(model.listObjectsOfProperty(transfer, property).hasNext());
        }
    }

    private DataTransfer createDataTransfer() throws MalformedURLException, DatatypeConfigurationException, ConstraintViolationException {
        byte[] digest = "xxx".getBytes(Charset.defaultCharset());

        HashFunction hashFunction = HashFunction.SHA_512;
        return new DataTransferBuilder(new URL("http://example.org/transfer/1"))
            .sender(new URL("http://www.fraunhofer.de/Broker"))
            .receiver(new URL("http://www.fraunhofer.de/Broker"))
            .transferCreatedAt(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()))
            .hashFunction(hashFunction)
// this is still buggy, solution in progress
//            .digest(digest)
            .authToken(new AuthTokenBuilder().tokenValue("token").build())
            .build();
    }

    @Test
    public void dataTransferDeserialization() throws ConstraintViolationException, DatatypeConfigurationException, MalformedURLException {
        String serializedHeader = createDataTransfer().toRdf();
        DataTransferImpl obj = (DataTransferImpl) VocabUtil.fromRdf(serializedHeader);

        Assert.assertEquals(obj.getAuthToken().getTokenValue(), "token");
        Assert.assertEquals(obj.getHashFunction(), HashFunction.SHA_512);
        Assert.assertEquals(obj.getReceiver().toString(), "http://www.fraunhofer.de/Broker");
        Assert.assertEquals(obj.getSender().toString(), "http://www.fraunhofer.de/Broker");

        XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        Assert.assertEquals(obj.getTransferCreatedAt().compare(now), -1);
    }
}
