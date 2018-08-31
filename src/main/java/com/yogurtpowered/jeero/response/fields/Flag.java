package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Flag {
    private final String flag;
    private final boolean value;

    public Flag(@JsonProperty("flag") String flag, @JsonProperty("value") boolean value) {
        this.flag = flag;
        this.value = value;
    }

    public String getFlag() {
        return flag;
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
