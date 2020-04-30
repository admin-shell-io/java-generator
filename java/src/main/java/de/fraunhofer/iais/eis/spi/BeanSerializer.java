package de.fraunhofer.iais.eis.spi;

public interface BeanSerializer {

    String toRdf(Object obj);
    <T> T fromRdf(String rdf, Class<T> valueType);

}
