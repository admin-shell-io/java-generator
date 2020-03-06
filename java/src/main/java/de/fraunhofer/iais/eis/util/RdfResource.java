package de.fraunhofer.iais.eis.util;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public class RdfResource implements Serializable {

    private String value;

    public RdfResource(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
