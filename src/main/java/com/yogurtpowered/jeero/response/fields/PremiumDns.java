package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PremiumDns {
    private final boolean dnsPoliciesEnabled;
    private final boolean zscalerLocationEnabled;
    private final boolean anyPoliciesEnabledForNetwork;
    private final DnsPolicies dnsPolicies;

    public PremiumDns(@JsonProperty("dns_policies_enabled") boolean dnsPoliciesEnabled,
                      @JsonProperty("zscaler_location_enabled") boolean zscalerLocationEnabled,
                      @JsonProperty("any_policies_enabled_for_network") boolean anyPoliciesEnabledForNetwork,
                      @JsonProperty("dns_policies") DnsPolicies dnsPolicies) {
        this.dnsPoliciesEnabled = dnsPoliciesEnabled;
        this.zscalerLocationEnabled = zscalerLocationEnabled;
        this.anyPoliciesEnabledForNetwork = anyPoliciesEnabledForNetwork;
        this.dnsPolicies = dnsPolicies;
    }

    public boolean isDnsPoliciesEnabled() {
        return dnsPoliciesEnabled;
    }

    public boolean isZscalerLocationEnabled() {
        return zscalerLocationEnabled;
    }

    public boolean isAnyPoliciesEnabledForNetwork() {
        return anyPoliciesEnabledForNetwork;
    }

    public DnsPolicies getDnsPolicies() {
        return dnsPolicies;
    }

    @Override
    public String toString() {
        return "PremiumDns{" +
                "dnsPoliciesEnabled=" + dnsPoliciesEnabled +
                ", zscalerLocationEnabled=" + zscalerLocationEnabled +
                ", anyPoliciesEnabledForNetwork=" + anyPoliciesEnabledForNetwork +
                ", dnsPolicies=" + dnsPolicies +
                '}';
    }
}
