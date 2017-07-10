package de.fraunhofer.iais.eis.util;

import de.fraunhofer.iais.eis.HashFunction;
import de.fraunhofer.iais.eis.jrdfb.JrdfbException;
import de.fraunhofer.iais.eis.jrdfb.serializer.marshaller.RdfMarshaller;
import de.fraunhofer.iais.eis.jrdfb.serializer.unmarshaller.RdfUnmarshaller;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Created by christian on 31.01.17.
 */
public class VocabUtil {

    private final static String PROTOCOL = "http";
    private final static String HOST = "industrialdataspace.org";
    private static RdfMarshaller serializer;
    private static RdfUnmarshaller deserializer;

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
            Collection<String> messages = new HashSet<>();

            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                messages.add(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
            }

            ConstraintViolationException exc = new ConstraintViolationException(messages);
            throw exc;
        }
    }

    public static String toRdf(Object obj) {
        try {
            return getRdfMarshaller().marshal(obj);
        }
        catch (JrdfbException e) {
            throw new RdfSerializationException("Error serializing objects", e);
        }
    }

    private static RdfMarshaller getRdfMarshaller() {
        if (serializer == null) {
            Collection<Class> annotatedClasses = collectAnnotatedClasses();
            serializer = new RdfMarshaller(annotatedClasses.toArray(new Class[annotatedClasses.size()]));
        }
        return serializer;
    }

    private static RdfUnmarshaller getRdfUnmarshaller() {
        if (deserializer == null) {
            Collection<Class> annotatedClasses = collectAnnotatedClasses();
            deserializer = new RdfUnmarshaller(annotatedClasses.toArray(new Class[annotatedClasses.size()]));
        }
        return deserializer;
    }

    private static Collection<Class> collectAnnotatedClasses() {
        Collection<Class> annotatedClasses = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        FastClasspathScanner fastClasspathScanner = new FastClasspathScanner("de.fraunhofer.iais.eis");
        List<String> interfaces = fastClasspathScanner.scan().getNamesOfAllInterfaceClasses();

        try {
            for (String iface : interfaces) {
                Class clazz = classLoader.loadClass(iface);
                annotatedClasses.add(clazz);
            }
        }
        catch (ClassNotFoundException e) {
            throw new RdfSerializationException("Error loading annotated class", e);
        }

        return annotatedClasses;
    }

    public static Object fromRdf(String rdf) {
        try {
            return getRdfUnmarshaller().unmarshal(rdf);
        }
        catch (JrdfbException e) {
            throw new RdfSerializationException("Error deserializing objects", e);
        }
    }

    public static <T> T getByString(T[] values, String label) {
        for (T value : values) {
            if (value.toString().equals(label)) return value;
        }
        return null;
    }

}
