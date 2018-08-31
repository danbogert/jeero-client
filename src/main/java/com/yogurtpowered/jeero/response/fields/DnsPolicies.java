package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DnsPolicies {
    private final boolean blockMalware;
    private final boolean adBlock;

    public DnsPolicies(@JsonProperty("block_malware") boolean blockMalware,
                       @JsonProperty("ad_block") boolean adBlock) {
        this.blockMalware = blockMalware;
        this.adBlock = adBlock;
    }

    public boolean isBlockMalware() {
        return blockMalware;
    }

    public boolean isAdBlock() {
        return adBlock;
    }

    @Override
    public String toString() {
        return "DnsPolicies{" +
                "blockMalware=" + blockMalware +
                ", adBlock=" + adBlock +
                '}';
    }
}
