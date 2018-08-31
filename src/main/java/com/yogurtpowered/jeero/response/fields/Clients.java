package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clients {
    private final int count;
    private final String url;

    public Clients(@JsonProperty("count") int count,
                   @JsonProperty("url") String url) {
        this.count = count;
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "count=" + count +
                ", url='" + url + '\'' +
                '}';
    }
}
