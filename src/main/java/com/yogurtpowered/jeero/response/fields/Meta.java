package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Meta {
    private final int responseCode;
    private final Date serverTime;

    public Meta(@JsonProperty("code") int responseCode, @JsonProperty("server_time") Date serverTime) {
        this.responseCode = responseCode;
        this.serverTime = serverTime;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public Date getServerTime() {
        return serverTime;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\tresponseCode=" + responseCode +
                "\n\tserverTime=" + serverTime +
                '}';
    }
}