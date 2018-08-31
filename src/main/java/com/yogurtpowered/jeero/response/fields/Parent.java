package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Parent {
    private final String[] ips;

    public Parent(@JsonProperty("ips") String[] ips) {
        this.ips = ips;
    }

    public String[] getIps() {
        return ips;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "ips=" + Arrays.toString(ips) +
                '}';
    }
}
