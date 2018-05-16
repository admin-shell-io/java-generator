package de.fraunhofer.iais.eis.spi;

public interface BeanSerializer {

    String toRdf(Object obj);
    Object fromRdf(String rdf);

}
