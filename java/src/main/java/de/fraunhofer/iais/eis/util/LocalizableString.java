package de.fraunhofer.iais.eis.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocalizableString extends PlainLiteral {
    @JsonProperty("@value")
    private String value = "";

    @JsonProperty("@language")
    private String language = "";

    public LocalizableString() {
        super();
    }

    public LocalizableString(String valueAndLanguage) {
        super(valueAndLanguage);
    }

    public LocalizableString(String value, String language) {
        super(value, language);
    }
    //Getters and Setters inherited from parent class
}
