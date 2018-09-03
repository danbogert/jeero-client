package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {
    private final boolean connected;
    private final String connectionType;
    private final Connectivity connectivity;
    private final String deviceType;
    private final String eui64;
    private final String firstActive;
    private final String hostname;
    private final Interface _interface;
    private final String ip;
    private final String[] ips;
    private final String lastActive;
    private final String mac;
    private final String manufacturer;
    private final String nickname;
    private final String profile;
    private final Source source;
    private final String url;
    private final Usage usage;
    private final boolean wireless;

    public Device(@JsonProperty("connected") boolean connected,
                  @JsonProperty("connection_type") String connectionType,
                  @JsonProperty("connectivity") Connectivity connectivity,
                  @JsonProperty("device_type") String deviceType,
                  @JsonProperty("eui64") String eui64,
                  @JsonProperty("first_active") String firstActive,
                  @JsonProperty("hostname") String hostname,
                  @JsonProperty("interface") Interface _interface,
                  @JsonProperty("ip") String ip,
                  @JsonProperty("ips") String[] ips,
                  @JsonProperty("last_active") String lastActive,
                  @JsonProperty("mac") String mac,
                  @JsonProperty("manufacturer") String manufacturer,
                  @JsonProperty("nickname") String nickname,
                  @JsonProperty("profile") String profile,
                  @JsonProperty("source") Source source,
                  @JsonProperty("url") String url,
                  @JsonProperty("usage") Usage usage,
                  @JsonProperty("wireless") boolean wireless) {
        this.connected = connected;
        this.connectionType = connectionType;
        this.connectivity = connectivity;
        this.deviceType = deviceType;
        this.eui64 = eui64;
        this.firstActive = firstActive;
        this.hostname = hostname;
        this._interface = _interface;
        this.ip = ip;
        this.ips = ips;
        this.lastActive = lastActive;
        this.mac = mac;
        this.manufacturer = manufacturer;
        this.nickname = nickname;
        this.profile = profile;
        this.source = source;
        this.url = url;
        this.usage = usage;
        this.wireless = wireless;
    }

    public boolean isConnected() {
        return connected;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public Connectivity getConnectivity() {
        return connectivity;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getEui64() {
        return eui64;
    }

    public String getFirstActive() {
        return firstActive;
    }

    public String getHostname() {
        return hostname;
    }

    public Interface getInterface() {
        return _interface;
    }

    public String getIp() {
        return ip;
    }

    public String[] getIps() {
        return ips;
    }

    public String getLastActive() {
        return lastActive;
    }

    public String getMac() {
        return mac;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getNickname() {
        return nickname;
    }

    public String getProfile() {
        return profile;
    }

    public Source getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    public Usage getUsage() {
        return usage;
    }

    public boolean getWireless() {
        return wireless;
    }

    @Override
    public String toString() {
        return "\n\t\t{" +
                "connected=" + connected +
                ", connectionType='" + connectionType + '\'' +
                ", connectivity=" + connectivity +
                ", deviceType='" + deviceType + '\'' +
                ", eui64='" + eui64 + '\'' +
                ", firstActive='" + firstActive + '\'' +
                ", hostname='" + hostname + '\'' +
                ", interface=" + _interface +
                ", ip='" + ip + '\'' +
                ", ips=" + Arrays.toString(ips) +
                ", lastActive='" + lastActive + '\'' +
                ", mac='" + mac + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", nickname='" + nickname + '\'' +
                ", profile='" + profile + '\'' +
                ", source=" + source +
                ", url='" + url + '\'' +
                ", usage=" + usage +
                ", wireless='" + wireless + '\'' +
                '}';
    }
}
