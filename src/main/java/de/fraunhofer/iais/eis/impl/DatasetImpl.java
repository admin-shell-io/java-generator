package de.fraunhofer.iais.eis.impl;

import de.fraunhofer.iais.eis.Dataset;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by christian on 19.01.17.
 */
public class DatasetImpl implements Dataset {

    private XMLGregorianCalendar creationDate;
    private String version, format, mediaType;

    @Override
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(XMLGregorianCalendar creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String getMediaType() {
        return mediaType;
    }

    @Override
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
