package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoIp {
    private final String countryCode;
    private final String countryName;
    private final String city;
    private final String region;
    private final String timezone;
    private final String postalCode;
    private final Integer metroCode;
    private final Integer areaCode;
    private final String regionName;
    private final String isp;
    private final String org;

    public GeoIp(@JsonProperty("countryCode") String countryCode,
                 @JsonProperty("countryName") String countryName,
                 @JsonProperty("city") String city,
                 @JsonProperty("region") String region,
                 @JsonProperty("timezone") String timezone,
                 @JsonProperty("postalCode") String postalCode,
                 @JsonProperty("metroCode") Integer metroCode,
                 @JsonProperty("areaCode") Integer areaCode,
                 @JsonProperty("regionName") String regionName,
                 @JsonProperty("isp") String isp,
                 @JsonProperty("org") String org) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.city = city;
        this.region = region;
        this.timezone = timezone;
        this.postalCode = postalCode;
        this.metroCode = metroCode;
        this.areaCode = areaCode;
        this.regionName = regionName;
        this.isp = isp;
        this.org = org;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Integer getMetroCode() {
        return metroCode;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getIsp() {
        return isp;
    }

    public String getOrg() {
        return org;
    }

    @Override
    public String toString() {
        return "GeoIp{" +
                "countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", timezone='" + timezone + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", metroCode='" + metroCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", regionName='" + regionName + '\'' +
                ", isp='" + isp + '\'' +
                ", org='" + org + '\'' +
                '}';
    }
}
