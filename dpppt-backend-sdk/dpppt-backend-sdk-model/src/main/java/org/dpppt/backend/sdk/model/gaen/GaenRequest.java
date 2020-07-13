package org.dpppt.backend.sdk.model.gaen;

import ch.ubique.openapi.docannotations.Documentation;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * GaenRequest represents a request made by the client to the backend-server.
 * It is used to publish the _Exposed Keys_ to the backend server.
 * As the GAEN API on the mobile phones never release the current day's key, the
 * client can set _delayedKeyDate_ to indicate a delayed key.
 */
public class GaenRequest {
    //TODO: needs to be adjusted properly after upgrading. (should ensure that payload stays sonstant)
    @NotNull
    @NotEmpty
    @Valid
    @Size(min = 14, max = 30)
    @Documentation(description = "Between 14 and 30 Temporary Exposure keys - zero or more of them might be fake keys. With the 1.5 update we could run into the situation of more than 14 keys a day.")

    private List<GaenKey> gaenKeys;

    @NotNull
    @Documentation(description = "Unknown - has something to do with GAEN not exposing the current day's key and that the current day's key will be delivered with 24h delay")
    private Integer delayedKeyDate;

    public List<GaenKey> getGaenKeys() {
        return this.gaenKeys;
    }

    public void setGaenKeys(List<GaenKey> gaenKeys) {
        this.gaenKeys = gaenKeys;
    }

    public Integer getDelayedKeyDate() {
        return this.delayedKeyDate;
    }

    public void setDelayedKeyDate(Integer delayedKeyDate) {
        this.delayedKeyDate = delayedKeyDate;
    }
}