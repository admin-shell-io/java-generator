package de.fraunhofer.iais.eis.util;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.net.URI;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RdfResource implements Serializable {

    @JsonProperty("@value")
    @JsonAlias({"@value", "value"})
    String value = null;

    @JsonProperty("@type")
    @JsonAlias({"@type", "type"})
    String type = null;

    public RdfResource() { super(); }
    public RdfResource(String value) {
        this.value = value;
    }
    public RdfResource(String value, URI type) {
        this.value = value;
        this.type = type.toString();
    }

    @JsonProperty("@value")
    public String getValue() {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    @JsonProperty("@type")
    public String getType() {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
