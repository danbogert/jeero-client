package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class MapFlag extends Flag {
    private final Map<String, String> value;

    public MapFlag(@JsonProperty("flag") String flag,
                   @JsonProperty("value") Map<String, String> value) {
        super(flag);

        this.value = value;
    }

    public Map<String, String> isValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" +
                "flag='" + flag + '\'' +
                ", value=" + value +
                '}';
    }
}
