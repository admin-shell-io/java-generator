package de.fraunhofer.iais.eis.handcrafted.impl;

import de.fraunhofer.iais.eis.handcrafted.Dataset;
import de.fraunhofer.iais.eis.util.VocabUtil;

import javax.validation.constraints.NotNull;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.MalformedURLException;
import java.util.UUID;

/**
 * Created by christian on 19.01.17.
 */
//@RdfType("http://industrialdataspace.org/2016/10/idsv/core#TransferredDataset")
public class DatasetImpl implements Dataset {

//    @RdfId(uriTemplate = "{RdfId}")
    private java.net.URL url;

//    @RdfProperty("http://industrialdataspace.org/2016/10/idsv/core#creationDate")
    private XMLGregorianCalendar creationDate;

//    @RdfProperty("http://industrialdataspace.org/2016/10/idsv/core#version")
    private String version;

//    @RdfProperty("http://industrialdataspace.org/2016/10/idsv/core#format")
    String format;

//    @RdfProperty("http://industrialdataspace.org/2016/10/idsv/core#mediaType")
    String mediaType;

    private boolean readOnly;

    // no "manual" construction
    DatasetImpl() {
        url = VocabUtil.createRandomUrl("dataset");
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
            throw new RuntimeException("object has been built and cannot be modified anymore");
        }
    }
}
