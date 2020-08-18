package de.fraunhofer.iais.eis.util;

import de.fraunhofer.iais.eis.spi.BeanSerializer;
import de.fraunhofer.iais.eis.spi.BeanValidator;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * Created by christian on 31.01.17.
 */
public class VocabUtil {

    private ServiceLoader<BeanSerializer> serializerLoader;
    private ServiceLoader<BeanValidator> validatorLoader;

    private final static String PROTOCOL = "https";
    private final static String HOST = "w3id.org";

    private static final VocabUtil instance = new VocabUtil();

    public static String randomUrlBase;

    private VocabUtil() {
        serializerLoader = ServiceLoader.load(BeanSerializer.class);
        validatorLoader = ServiceLoader.load(BeanValidator.class);
    }

    public static VocabUtil getInstance() {
        return instance;
    }

    /**
     * Generates a random URL starting with https://w3id.org/idsa/autogen/{path}/RANDOM-STRING
     * This behaviour can be altered by setting the static variable randomUrlBase. Then, the URL will be randomUrlBase/{path}/RANDOM-STRING
     * @param path Path to be appended to base URL
     * @return randomized URL according to predefined schema
     */
    public URI createRandomUrl(String path) {
        try {
            if(randomUrlBase != null)
            {
                if(!randomUrlBase.endsWith("/"))
                {
                    randomUrlBase += "/";
                }
                return new URL(randomUrlBase + path + "/" + UUID.randomUUID()).toURI();
            }
            return new URL(PROTOCOL, HOST, "/idsa/autogen/" + path + "/" + UUID.randomUUID()).toURI();
        }
        catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> void validate(T objToValidate) throws ConstraintViolationException {
        Iterator<BeanValidator> validators = validatorLoader.iterator();
        while (validators.hasNext()) {
            validators.next().validate(objToValidate);
        }
    }

    public String toRdf(Object obj) {
        Iterator<BeanSerializer> iterator = serializerLoader.iterator();
        return iterator.hasNext() ? iterator.next().toRdf(obj) : "";
    }

    public <T> T fromRdf(String rdf, Class<T> valueType) {
        Iterator<BeanSerializer> iterator = serializerLoader.iterator();
        return iterator.hasNext() ? iterator.next().fromRdf(rdf, valueType) : null;
    }

    public <T> T getByString(T[] values, String label) {
        for (T value : values) {
            if (value.toString().equals(label)) return value;
        }
        return null;
    }

}
