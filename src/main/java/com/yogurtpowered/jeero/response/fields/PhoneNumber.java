package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneNumber {
    private final String value;
    private final boolean verified;

    public PhoneNumber(@JsonProperty("value") String value, @JsonProperty("verified") boolean verified) {
        this.value = value;
        this.verified = verified;
    }

    public String getValue() {
        return value;
    }

    public boolean getVerified() {
        return verified;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\t\tvalue='" + value + '\'' +
                "\n\t\tverified=" + verified +
                '}';
    }
}
