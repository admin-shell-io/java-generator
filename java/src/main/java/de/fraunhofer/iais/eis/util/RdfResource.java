package de.fraunhofer.iais.eis.util;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("RdfResource")
public class RdfResource implements Serializable {

    @JsonProperty("@value")
    @JsonAlias({"@value", "value"})
    String value = null;

    @JsonProperty("@type")
    @JsonAlias({"@type", "type"})
    String type = null;


    // all classes have a generic property array
    @JsonIgnore
    ArrayList<Map<URI,RdfResource>> properties;


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
