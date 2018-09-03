package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Interface {
    private final String frequency;
    private final String frequencyUnit;

    public Interface(@JsonProperty("frequency") String frequency,
                     @JsonProperty("frequency_unit") String frequencyUnit) {
        this.frequency = frequency;
        this.frequencyUnit = frequencyUnit;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getFrequencyUnit() {
        return frequencyUnit;
    }

    @Override
    public String toString() {
        return "{" +
                "frequency='" + frequency + '\'' +
                ", frequencyUnit='" + frequencyUnit + '\'' +
                '}';
    }
}
