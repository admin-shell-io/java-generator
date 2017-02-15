package de.fraunhofer.iais.eis.util;

import com.google.common.reflect.ClassPath;
import de.fhg.iais.jrdfb.JrdfbException;
import de.fhg.iais.jrdfb.RdfSerializer;
import de.fhg.iais.jrdfb.annotation.RdfId;
import de.fraunhofer.iais.eis.IANAMediaType;
import de.fraunhofer.iais.eis.Parameter;
import de.fraunhofer.iais.eis.ParameterImpl;

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
        Collection<Class> annotatedClasses = collectAnnotatedClasses();
        RdfSerializer serializer = new RdfSerializer(annotatedClasses.toArray(new Class[annotatedClasses.size()]));
        String rdf = null;
        try {
            rdf = serializer.serialize(obj);
            return rdf;
        }
        catch (JrdfbException e) {
            throw new RdfSerializationException("Error serializing object", e);
        }
    }

    private static Collection<Class> collectAnnotatedClasses() {
        Collection<Class> annotatedClasses = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try {
            ClassPath classPath = ClassPath.from(classLoader);
            Collection<ClassPath.ClassInfo> classInfos = classPath.getTopLevelClasses("de.fraunhofer.iais.eis");

            //todo: make one loop, this is to work around a serializer bug
            for (ClassPath.ClassInfo classInfo : classInfos) {
                if (classInfo.getName().endsWith("Impl")) {
                    annotatedClasses.add(classLoader.loadClass(classInfo.getName()));
                }
            }

            for (ClassPath.ClassInfo classInfo : classInfos) {
                if (classInfo.getName().endsWith("Impl"))
                    continue;
                annotatedClasses.add(classLoader.loadClass(classInfo.getName()));
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
        System.out.println("rdf deserialization not yet implemented");
        // todo: call deserializer
        return null;
    }

}
