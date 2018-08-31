package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Timezone {
    private final String value;
    private final String geoIp;

    public Timezone(@JsonProperty("value") String value,
                    @JsonProperty("geo_ip") String geoIp) {
        this.value = value;
        this.geoIp = geoIp;
    }

    public String getValue() {
        return value;
    }

    public String getGeoIp() {
        return geoIp;
    }

    @Override
    public String toString() {
        return "Timezone{" +
                "value='" + value + '\'' +
                ", geoIp='" + geoIp + '\'' +
                '}';
    }
}
