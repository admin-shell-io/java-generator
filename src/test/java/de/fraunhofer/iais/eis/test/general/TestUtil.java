package de.fraunhofer.iais.eis.test.general;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.ByteArrayInputStream;

/**
 * Created by christian on 22.05.17.
 */
public class TestUtil {

    public static Model createModelFromRdf(String rdfTTL) {
        Model model = ModelFactory.createDefaultModel();
        model.read(new ByteArrayInputStream(rdfTTL.getBytes()), null, "TURTLE");
        return model;
    }

}
