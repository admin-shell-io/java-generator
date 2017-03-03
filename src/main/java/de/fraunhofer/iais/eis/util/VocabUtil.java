package de.fraunhofer.iais.eis.util;

import com.google.common.reflect.ClassPath;
import de.fraunhofer.iais.eis.jrdfb.JrdfbException;
import de.fraunhofer.iais.eis.jrdfb.serializer.RdfSerializer;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Created by christian on 31.01.17.
 */
public class VocabUtil {

    private final static String PROTOCOL = "http";
    private final static String HOST = "industrialdataspace.org";
    private static RdfSerializer serializer;

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
            constraintViolations.stream().forEach(x -> messages.add(x.getPropertyPath() + " " + x.getMessage()));

            ConstraintViolationException exc = new ConstraintViolationException(messages);
            throw exc;
        }
    }

    public static String toRdf(Object obj) {
        try {
            return getRdfSeriaizer().serialize(obj);
        }
        catch (JrdfbException e) {
            throw new RdfSerializationException("Error serializing objects", e);
        }
    }

    private static RdfSerializer getRdfSeriaizer() {
        if (serializer == null) {
            Collection<Class> annotatedClasses = collectAnnotatedClasses();
            serializer = new RdfSerializer(annotatedClasses.toArray(new Class[annotatedClasses.size()]));
        }
        return serializer;
    }

    private static Collection<Class> collectAnnotatedClasses() {
        Collection<Class> annotatedClasses = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try {
            ClassPath classPath = ClassPath.from(classLoader);
            Collection<ClassPath.ClassInfo> classInfos = classPath.getTopLevelClasses("de.fraunhofer.iais.eis");

            for (ClassPath.ClassInfo classInfo : classInfos) {
                Class clazz = classLoader.loadClass(classInfo.getName());
                if (clazz.isInterface()) {
                    annotatedClasses.add(clazz);
                }
            }
        }
        catch (IOException e) {
            throw new RdfSerializationException("Error getting classpath", e);
        }
        catch (ClassNotFoundException e) {
            throw new RdfSerializationException("Error loading annotated class", e);
        }

        return annotatedClasses;
    }

    public static Object fromRdf(String rdf) {
        try {
            return getRdfSeriaizer().deserialize(rdf);
        }
        catch (JrdfbException e) {
            throw new RdfSerializationException("Error deserializing objects", e);
        }
    }

}
