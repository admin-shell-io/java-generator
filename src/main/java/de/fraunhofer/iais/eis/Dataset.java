package de.fraunhofer.iais.eis;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import javax.xml.datatype.XMLGregorianCalendar;

public interface Dataset {

    @NotNull XMLGregorianCalendar getCreationDate();
    void setCreationDate(@NotNull XMLGregorianCalendar creationDate);

    String getVersion();
    void setVersion(String version);

    String getFormat();
    void setFormat(String version);

    @URL
    String getMediaType();
    void setMediaType(@URL String mediaType);

}