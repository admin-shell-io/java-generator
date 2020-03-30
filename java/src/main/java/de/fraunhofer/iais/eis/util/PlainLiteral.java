package de.fraunhofer.iais.eis.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.StringTokenizer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlainLiteral extends LocalizableString {

    @JsonProperty("@value")
    private String value = "";

    @JsonProperty("@language")
    private String language = "";

    public PlainLiteral() {
        super();
    }

    public PlainLiteral(String valueAndLanguage) {
        super(valueAndLanguage);
    }

    public PlainLiteral(String value, String language) {
        super(value, language);
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
