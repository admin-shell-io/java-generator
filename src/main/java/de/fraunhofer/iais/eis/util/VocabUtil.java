package de.fraunhofer.iais.eis.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

/**
 * Created by christian on 31.01.17.
 */
public class VocabUtil {

    private final static String PROTOCOL = "http";
    private final static String HOST = "industrialdataspace.org";

    public static URL createRandomUrl(String path) {
        try {
            return new java.net.URL(PROTOCOL, HOST, "/" + path + "/" + UUID.randomUUID());
        }
        catch (MalformedURLException e) {
            // should never happen
            throw new RuntimeException(e);
        }
    }

    public static <T> void validate(T objToValidate) throws ConstraintViolationException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(objToValidate);
        if (!constraintViolations.isEmpty()) {
            Collection<String> messages = new ArrayList<>();
            constraintViolations.stream().forEach(x -> messages.add(x.getMessage()));

            ConstraintViolationException exc = new ConstraintViolationException(messages);
            throw exc;
        }
    }

    public static void toRdf(Object obj) {
        // todo: call serializer
    }

    public static Object fromRdf(String rdf) {
        // todo: call deserializer
        return null;
    }

}
