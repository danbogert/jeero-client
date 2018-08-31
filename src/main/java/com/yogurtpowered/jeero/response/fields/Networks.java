package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Date;

public class Networks {
    private final int count;
    private final Network[] networks;

    public Networks(@JsonProperty("count") int count, @JsonProperty("data") Network[] networks) {
        this.count = count;
        this.networks = networks;
    }

    public int getCount() {
        return count;
    }

    public Network[] getNetworks() {
        return networks;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\t\tcount=" + count +
                "\n\t\tnetworks=" + Arrays.toString(networks) +
                '}';
    }

    public static class Network {
        private final String url;
        private final String name;
        private final Date created;

        public Network(
                @JsonProperty("url") String url,
                @JsonProperty("name") String name,
                @JsonProperty("created") Date created) {
            this.url = url;
            this.name = name;
            this.created = created;
        }

        public String getUrl() {
            return url;
        }

        public String getName() {
            return name;
        }

        public Date getCreated() {
            return created;
        }

        @Override
        public String toString() {
            return "{" +
                    "\n\t\t\turl='" + url + '\'' +
                    "\n\t\t\tname='" + name + '\'' +
                    "\n\t\t\tcreated=" + created +
                    '}';
        }
    }
}
