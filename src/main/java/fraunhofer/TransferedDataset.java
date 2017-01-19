package fraunhofer;

import javax.validation.constraints.NotNull;
import java.util.Collection;

public interface TransferedDataset extends Dataset {

    @NotNull
    DataEndpoint getSender();
    void setSender(@NotNull DataEndpoint sender);

    @NotNull DataEndpoint getReceiver();
    void setReceiver(@NotNull DataEndpoint receiver);

    AuthThoken getAuthToken();
    void setAuthThoken(AuthToken authToken);

    byte[] getPayloadDigest();
    void setPayloadDigest(byte[] digest);

    Collection<TransferProperty> getCustomProperty();
    void setCustomProperty(Collection<TransferProperty> customProperty);

}