package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usage {
    private final double downMbps;
    private final double upMbps;

    public Usage(@JsonProperty("down_mbps") double downMbps,
                 @JsonProperty("up_mbps") double upMbps) {
        this.downMbps = downMbps;
        this.upMbps = upMbps;
    }

    public double getDownMbps() {
        return downMbps;
    }

    public double getUpMbps() {
        return upMbps;
    }

    @Override
    public String toString() {
        return "{" +
                "downMbps=" + downMbps +
                ", upMbps=" + upMbps +
                '}';
    }
}
