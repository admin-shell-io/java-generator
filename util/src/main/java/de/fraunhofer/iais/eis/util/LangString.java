package de.fraunhofer.iais.eis.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.net.URI;

//Prevent empty values from being printed - @language AND @type in combination is forbidden
//Note that the Serializer uses this class by name. If this class is renamed, make sure to adapt the MessageParser class accordingly!
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LangString implements Serializable {

    //@JsonProperty("@language")
    private String language = null;
    private String value = null;

    public LangString() {
        super();
    }


    public LangString(String valueAndLanguage) {
        if(valueAndLanguage.contains("@"))
        {
            String[] splitString = valueAndLanguage.split("@");
            this.value = splitString[0];
            this.language = splitString[1];
        }
        else
        {
            this.value = valueAndLanguage;
        }
    }

    public LangString(String value, String language) {
        this.value = value;
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    //This override doesn't seem to do much...
    @Override
    public String toString() {
        String result = this.value;
        if (this.language != null && !this.language.isEmpty())
        {
            return "\"" + result + "\"@" + this.language;
        }
        return result;
    }
}
