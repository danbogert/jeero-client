package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IspStatus extends Status {
    private final String ispUp;

    public IspStatus(@JsonProperty("isp_up") String ispUp,
                     @JsonProperty("status") String status) {
        super(status);

        this.ispUp = ispUp;
    }

    public String getIspUp() {
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
