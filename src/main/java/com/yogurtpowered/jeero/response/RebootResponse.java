package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yogurtpowered.jeero.response.fields.Data;
import com.yogurtpowered.jeero.response.fields.Meta;

public class RebootResponse extends Response<RebootResponse.NoData> {
    public RebootResponse(@JsonProperty("meta") Meta meta) {
        super(meta, null);
    }

    public static class NoData extends Data {
    }
}
