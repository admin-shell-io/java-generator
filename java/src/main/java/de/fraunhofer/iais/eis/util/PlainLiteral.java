package de.fraunhofer.iais.eis.util;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlainLiteral implements Serializable {

    @JsonProperty("@value")
    private String value = "";

    @JsonProperty("@language")
    private String language = "";

    public PlainLiteral() {
    }

    public PlainLiteral(String valueAndLanguage) {
        StringTokenizer tokenizer = new StringTokenizer(valueAndLanguage, "@");
        value = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";
        language = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";
    }

    public PlainLiteral(String value, String language) {
        this.value = value;
        this.language = language;
    }

    public String getValue() {
        return value;
    }

    public String getLanguage() {
        return language;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
