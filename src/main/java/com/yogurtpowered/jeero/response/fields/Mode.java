package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mode {
    protected final String mode;
    protected final String custom;

    public Mode(@JsonProperty("mode") String mode,
                @JsonProperty("custom") String custom) {
        this.mode = mode;
        this.custom = custom;
    }

    public String getMode() {
        return mode;
    }

    public String getCustom() {
        return custom;
    }

    @Override
    public String toString() {
        return "Mode{" +
                "mode='" + mode + '\'' +
                ", custom='" + custom + '\'' +
                '}';
    }
}
