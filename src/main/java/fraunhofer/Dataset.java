package fraunhofer;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import javax.xml.datatype.XMLGregorianCalendar;

public interface Dataset {

    @NotEmpty XMLGregorianCalendar getCreationDate();
    void setCreationDate(@NotEmpty XMLGregorianCalendar creationDate);

    String getVersion();
    void setVersion(String version);

    String getFormat();
    void setFormat(String version);

    @URL
    String getMediaType();
    void setMediaType(@URL String mediaType);

}