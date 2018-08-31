package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Speed {
    private final String status;
    private final String date;
    private final Metric up;
    private final Metric down;

    public Speed(@JsonProperty("status") String status,
                 @JsonProperty("date") String date,
                 @JsonProperty("up") Metric up,
                 @JsonProperty("down") Metric down) {
        this.status = status;
        this.date = date;
        this.up = up;
        this.down = down;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public Metric getUp() {
        return up;
    }

    public Metric getDown() {
        return down;
    }

    @Override
    public String toString() {
        return "Speed{" +
                "status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", up=" + up +
                ", down=" + down +
                '}';
    }
}
