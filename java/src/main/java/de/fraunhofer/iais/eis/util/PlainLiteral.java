package de.fraunhofer.iais.eis.util;

import java.util.ArrayList;
import java.util.Collection;

public class PlainLiteral {

    private final String value, language;

    public PlainLiteral(String value) {
        this(value, "");
    }

    public PlainLiteral(String value, String language) {
        this.value = value;
        this.language = language;
    }

    public String getValue() {
        return new String(value);
    }

    public String getLanguage() {
        return new String(language);
    }

}
