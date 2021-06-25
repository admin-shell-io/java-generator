package de.fraunhofer.iais.eis.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Deprecated
/**
 * This class is not reflecting the characteristics of rdf:Literal properly and therefore must be replaced soon.
 * Use TypedLiteral or LocalizableString instead.
 * 
 * @author sbader
 *
 */
public class PlainLiteral extends TypedLiteral {

    public PlainLiteral() {
        super();
    }

    public PlainLiteral(String valueAndLanguage) {
        super(valueAndLanguage);
    }

    public PlainLiteral(String value, String language) {
        super(value, language);
    }
    //Getters and Setters inherited from parent class

}
