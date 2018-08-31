package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Capability {
    private final boolean capable;
    private final Map<String, Boolean> requirements;

    public Capability(@JsonProperty("capable") boolean capable,
                      @JsonProperty("requirements") Map<String, Boolean> requirements) {
        this.capable = capable;
        this.requirements = requirements;
    }

    public boolean isCapable() {
        return capable;
    }

    public Map<String, Boolean> getRequirements() {
        return requirements;
    }

    @Override
    public String toString() {
        return "Capability{" +
                "capable=" + capable +
                ", requirements=" + requirements +
                '}';
    }
}
