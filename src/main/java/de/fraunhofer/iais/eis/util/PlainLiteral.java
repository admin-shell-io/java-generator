package de.fraunhofer.iais.eis.util;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.graph.impl.LiteralLabel;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.impl.LiteralImpl;

import java.util.ArrayList;
import java.util.Collection;

public class PlainLiteral extends LiteralImpl  {

    public PlainLiteral(String value) {
        this(value, "");
    }

    public PlainLiteral(String value, String language) {
        super(NodeFactory.createLiteral( value, language ), null );
    }

    // compatibility functions to handle proper deserialization of convenience class PlainLiteral

    public static Collection<PlainLiteral> toPlainLiteralCollection(Collection<? extends Literal> literals) {
        Collection<PlainLiteral> plainLiterals = new ArrayList<>();

        if (literals == null) return null;

        literals.stream().forEach(lit -> {
            plainLiterals.add(new PlainLiteral(lit.getLexicalForm(), lit.getLanguage()));
        });

        return plainLiterals;
    }

}
