package de.fraunhofer.iais.eis.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlainLiteral implements Serializable {

    private String value, language;

    public PlainLiteral() {
        value = "";
        language = "";
    }

    @JsonCreator
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

    @JsonValue
    @Override
    public String toString() {
        return value + (language.isEmpty() ? "" : "@" + language);
    }

}
