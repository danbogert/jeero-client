package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentMode extends Mode {
    private final Parent parent;
    private final boolean caching;

    public ParentMode(@JsonProperty("mode") String mode,
                      @JsonProperty("custom") String custom,
                      @JsonProperty("parent") Parent parent,
                      @JsonProperty("caching") boolean caching) {
        super(mode, custom);

        this.parent = parent;
        this.caching = caching;
    }

    public Parent getParent() {
        return parent;
    }

    public boolean isCaching() {
        return caching;
    }

    @Override
    public String toString() {
        return "ParentMode{" +
                "parent=" + parent +
                ", caching=" + caching +
                ", mode='" + mode + '\'' +
                ", custom='" + custom + '\'' +
                '}';
    }
}
