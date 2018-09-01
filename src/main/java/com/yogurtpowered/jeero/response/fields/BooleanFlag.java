package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BooleanFlag extends Flag {
    private final boolean value;

    public BooleanFlag(@JsonProperty("flag") String flag, @JsonProperty("value") boolean value) {
        super(flag);

        this.value = value;
    }

    public boolean isValue() {
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
