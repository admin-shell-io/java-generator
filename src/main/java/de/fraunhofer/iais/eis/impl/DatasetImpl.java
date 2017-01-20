package de.fraunhofer.iais.eis.impl;

import de.fraunhofer.iais.eis.Dataset;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.MalformedURLException;
import java.util.UUID;

/**
 * Created by christian on 19.01.17.
 */
public class DatasetImpl implements Dataset {

    private java.net.URL url;
    private XMLGregorianCalendar creationDate;
    private String version, format, mediaType;
    private boolean readOnly;

    // no "manual" construction
    DatasetImpl() {
        try {
            url = new java.net.URL("http", "industrialdataspace.org", "/dataset/" + UUID.randomUUID());
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    final public java.net.URL getId() {
        return url;
    }

    @Override
    final public void setId(@NotNull java.net.URL url) {
        assertModifiable();
        this.url = url;
    }

    @Override
    final public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    @Override
    final public void setCreationDate(XMLGregorianCalendar creationDate) {
        assertModifiable();
        this.creationDate = creationDate;
    }

    @Override
    final public String getVersion() {
        return version;
    }

    @Override
    final public void setVersion(String version) {
        assertModifiable();
        this.version = version;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    final public void setFormat(String format) {
        assertModifiable();
        this.format = format;
    }

    @Override
    public String getMediaType() {
        return mediaType;
    }

    @Override
    final public void setMediaType(String mediaType) {
        assertModifiable();
        this.mediaType = mediaType;
    }

    final public void setReadOnly() {
        readOnly = true;
    }

    private void assertModifiable() {
        if (readOnly) {
            throw new RuntimeException("object is built and cannot be modified");
        }
    }
}
