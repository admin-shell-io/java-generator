package de.fraunhofer.iais.eis.util;

import de.fraunhofer.iais.eis.spi.BeanSerializer;
import de.fraunhofer.iais.eis.spi.BeanValidator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Created by christian on 31.01.17.
 */
public class VocabUtil {

    private ServiceLoader<BeanSerializer> serializerLoader;
    private ServiceLoader<BeanValidator> validatorLoader;

    private final static String PROTOCOL = "http";
    private final static String HOST = "industrialdataspace.org";

    private static final VocabUtil instance = new VocabUtil();

    private VocabUtil() {
        serializerLoader = ServiceLoader.load(BeanSerializer.class);
        validatorLoader = ServiceLoader.load(BeanValidator.class);
    }

    public static VocabUtil getInstance() {
        return instance;
    }

    public URL createRandomUrl(String path) {
        try {
            return new URL(PROTOCOL, HOST, "/" + path + "/" + UUID.randomUUID());
        }
        catch (MalformedURLException e) {
            // should never happen
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

    public Object fromRdf(String rdf) {
        Iterator<BeanSerializer> iterator = serializerLoader.iterator();
        return iterator.hasNext() ? iterator.next().fromRdf(rdf) : null;
    }

    public <T> T getByString(T[] values, String label) {
        for (T value : values) {
            if (value.toString().equals(label)) return value;
        }
        return null;
    }

}
