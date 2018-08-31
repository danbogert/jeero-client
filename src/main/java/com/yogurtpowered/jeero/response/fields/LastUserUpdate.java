package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class LastUserUpdate {
    private final String lastUpdateStarted;
    private final String[] unresponsiveEeros;
    private final String[] incompleteEeros;

    public LastUserUpdate(@JsonProperty("last_update_started") String lastUpdateStarted,
                          @JsonProperty("unresponsive_eeros") String[] unresponsiveEeros,
                          @JsonProperty("incomplete_eeros") String[] incompleteEeros) {
        this.lastUpdateStarted = lastUpdateStarted;
        this.unresponsiveEeros = unresponsiveEeros;
        this.incompleteEeros = incompleteEeros;
    }

    public String getLastUpdateStarted() {
        return lastUpdateStarted;
    }

    public String[] getUnresponsiveEeros() {
        return unresponsiveEeros;
    }

    public String[] getIncompleteEeros() {
        return incompleteEeros;
    }

    @Override
    public String toString() {
        return "LastUserUpdate{" +
                "lastUpdateStarted='" + lastUpdateStarted + '\'' +
                ", unresponsiveEeros=" + Arrays.toString(unresponsiveEeros) +
                ", incompleteEeros=" + Arrays.toString(incompleteEeros) +
                '}';
    }
}
