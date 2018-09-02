package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IspStatus extends Status {
    private final boolean ispUp;

    public IspStatus(@JsonProperty("isp_up") boolean ispUp,
                     @JsonProperty("status") String status) {
        super(status);

        this.ispUp = ispUp;
    }

    public boolean isIspUp() {
        return ispUp;
    }

    @Override
    public String toString() {
        return "IspStatus{" +
                "ispUp='" + ispUp + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
