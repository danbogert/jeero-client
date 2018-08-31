package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Eeros {
    private final int count;
    private final Eero[] eeros;

    public Eeros(@JsonProperty("count") int count,
                 @JsonProperty("data") Eero[] eeros) {
        this.count = count;
        this.eeros = eeros;
    }

    public int getCount() {
        return count;
    }

    public Eero[] getEeros() {
        return eeros;
    }

    @Override
    public String toString() {
        return "Eeros{" +
                "count=" + count +
                ", eeros=" + Arrays.toString(eeros) +
                '}';
    }

    public static class Eero {
        private final String url;
        private final String location;
        private final String ipAddress;
        private final String osVersion;
        private final boolean updateAvailable;
        private final String status;
        private final String[] messages;
        private final String joined;
        private final boolean gateway;
        private final boolean usingWan;
        private final String modelNumber;
        private final String macAddress;
        private final String serial;
        private final boolean wired;
        private final boolean ledOn;
        private final String lastReboot;
        private final int connectedClientsCount;

        public Eero(@JsonProperty("url") String url,
                    @JsonProperty("location") String location,
                    @JsonProperty("ip_address") String ipAddress,
                    @JsonProperty("os_version") String osVersion,
                    @JsonProperty("update_available") boolean updateAvailable,
                    @JsonProperty("status") String status,
                    @JsonProperty("messages") String[] messages,
                    @JsonProperty("joined") String joined,
                    @JsonProperty("gateway") boolean gateway,
                    @JsonProperty("using_wan") boolean usingWan,
                    @JsonProperty("model_number") String modelNumber,
                    @JsonProperty("mac_address") String macAddress,
                    @JsonProperty("serial") String serial,
                    @JsonProperty("wired") boolean wired,
                    @JsonProperty("led_on") boolean ledOn,
                    @JsonProperty("last_reboot") String lastReboot,
                    @JsonProperty("connected_clients_count") int connectedClientsCount) {
            this.url = url;
            this.location = location;
            this.ipAddress = ipAddress;
            this.osVersion = osVersion;
            this.updateAvailable = updateAvailable;
            this.status = status;
            this.messages = messages;
            this.joined = joined;
            this.gateway = gateway;
            this.usingWan = usingWan;
            this.modelNumber = modelNumber;
            this.macAddress = macAddress;
            this.serial = serial;
            this.wired = wired;
            this.ledOn = ledOn;
            this.lastReboot = lastReboot;
            this.connectedClientsCount = connectedClientsCount;
        }

        public String getUrl() {
            return url;
        }

        public String getLocation() {
            return location;
        }

        public String getIpAddress() {
            return ipAddress;
        }

        public String getOsVersion() {
            return osVersion;
        }

        public boolean isUpdateAvailable() {
            return updateAvailable;
        }

        public String getStatus() {
            return status;
        }

        public String[] getMessages() {
            return messages;
        }

        public String getJoined() {
            return joined;
        }

        public boolean isGateway() {
            return gateway;
        }

        public boolean isUsingWan() {
            return usingWan;
        }

        public String getModelNumber() {
            return modelNumber;
        }

        public String getMacAddress() {
            return macAddress;
        }

        public String getSerial() {
            return serial;
        }

        public boolean isWired() {
            return wired;
        }

        public boolean isLedOn() {
            return ledOn;
        }

        public String getLastReboot() {
            return lastReboot;
        }

        public int getConnectedClientsCount() {
            return connectedClientsCount;
        }

        @Override
        public String toString() {
            return "Eero{" +
                    "url='" + url + '\'' +
                    ", location='" + location + '\'' +
                    ", ipAddress='" + ipAddress + '\'' +
                    ", osVersion='" + osVersion + '\'' +
                    ", updateAvailable=" + updateAvailable +
                    ", status='" + status + '\'' +
                    ", messages=" + Arrays.toString(messages) +
                    ", joined='" + joined + '\'' +
                    ", gateway=" + gateway +
                    ", usingWan=" + usingWan +
                    ", modelNumber='" + modelNumber + '\'' +
                    ", macAddress='" + macAddress + '\'' +
                    ", serial='" + serial + '\'' +
                    ", wired=" + wired +
                    ", ledOn=" + ledOn +
                    ", lastReboot='" + lastReboot + '\'' +
                    ", connectedClientsCount=" + connectedClientsCount +
                    '}';
        }
    }
}
