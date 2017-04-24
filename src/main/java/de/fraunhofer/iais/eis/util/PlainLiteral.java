package de.fraunhofer.iais.eis.util;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.rdf.model.impl.LiteralImpl;

public class PlainLiteral extends LiteralImpl  {

    public PlainLiteral(String value) {
        this(value, "");
    }

    public PlainLiteral(String value, String language) {
        super(NodeFactory.createLiteral( value, language ), null );
    }

}
