package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metric {
    private final double value;
    private final String units;

    public Metric(@JsonProperty("value") double value,
                  @JsonProperty("units") String units) {
        this.value = value;
        this.units = units;
    }

    public double getValue() {
        return value;
    }

    public String getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "value=" + value +
                ", units='" + units + '\'' +
                '}';
    }
}
