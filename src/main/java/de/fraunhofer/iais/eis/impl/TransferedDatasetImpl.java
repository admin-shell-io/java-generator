package de.fraunhofer.iais.eis.impl;

import de.fraunhofer.iais.eis.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Collection;

/**
 * Created by christian on 19.01.17.
 */
public class TransferedDatasetImpl implements TransferedDataset {


    final public DataEndpoint getSender() {
        return null;
    }

    final public void setSender(DataEndpoint sender) {

    }

    final public DataEndpoint getReceiver() {
        return null;
    }

    final public void setReceiver(DataEndpoint receiver) {

    }

    
    final public AuthThoken getAuthToken() {
        return null;
    }

    
    final public void setAuthThoken(AuthToken authToken) {

    }

    
    final public byte[] getPayloadDigest() {
        return new byte[0];
    }

    
    final public void setPayloadDigest(byte[] digest) {

    }

    
    final public Collection<TransferProperty> getCustomProperty() {
        return null;
    }

    
    final public void setCustomProperty(Collection<TransferProperty> customProperty) {

    }

    
    final public XMLGregorianCalendar getCreationDate() {
        return null;
    }

    final public void setCreationDate(XMLGregorianCalendar creationDate) {

    }

    
    final public String getVersion() {
        return null;
    }

    
    final public void setVersion(String version) {

    }

    
    final public String getFormat() {
        return null;
    }

    
    final public void setFormat(String version) {

    }

    final public String getMediaType() {
        return null;
    }

    final public void setMediaType(@org.hibernate.validator.constraints.URL String mediaType) {

    }
}
