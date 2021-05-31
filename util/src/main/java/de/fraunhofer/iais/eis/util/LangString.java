package de.fraunhofer.iais.eis.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            LangString other = (LangString) obj;
            return Objects.equals(this.language, other.language) &&
                    Objects.equals(this.value, other.value);
        }
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.language, this.value);
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
