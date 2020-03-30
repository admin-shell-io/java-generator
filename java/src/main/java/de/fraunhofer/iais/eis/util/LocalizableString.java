package de.fraunhofer.iais.eis.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.StringTokenizer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocalizableString implements Serializable {
    @JsonProperty("@value")
    private String value = "";

    @JsonProperty("@language")
    private String language = "";

    public LocalizableString() {
        super();
    }

    public LocalizableString(String valueAndLanguage) {
        StringTokenizer tokenizer = new StringTokenizer(valueAndLanguage, "@");
        value = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";
        language = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";
    }

    public LocalizableString(String value, String language) {
        this.value = value;
        this.language = language;
    }
    //Getters and Setters inherited from parent class
}
