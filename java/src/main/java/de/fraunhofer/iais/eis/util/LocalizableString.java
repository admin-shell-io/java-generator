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
    protected String value = "";

    @JsonProperty("@language")
	protected String language = "";


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
    
    @Override
    public String toString() {
    	String result = this.value;
    	if (this.language != null && !this.language.isEmpty()) return "\"" + result + "\"@" + this.language;
    	return result;
    }
}
