package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.yogurtpowered.jeero.response.fields.*;

import java.io.IOException;
import java.util.*;


public class ClientsResponse extends Response<ClientsResponse.ClientsData> {

    public ClientsResponse(@JsonProperty("meta") Meta meta, @JsonProperty("data") ClientsData data) {
        super(meta, data);
    }

    @JsonDeserialize(using = ClientsResponse.ClientDeserializer.class)
    public static class ClientsData extends Data {
        private final Client[] clients;

        public ClientsData(Client[] clients) {
            this.clients = clients;
        }

        public Client[] getClients() {
            return clients;
        }

        @Override
        public String toString() {
            return "{" +
                    "clients=" + Arrays.toString(clients) +
                    '}';
        }
    }

    public static class ClientDeserializer extends StdDeserializer<ClientsData> {
        public ClientDeserializer() {
            this(null);
        }

        protected ClientDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public ClientsData deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException {
            final JsonNode node = jp.getCodec().readTree(jp);
            final List<Client> clients = new ArrayList<>();

            for (int i = 0; node.has(i); i++) {
                JsonNode rawClient = node.get(i);
                clients.add(new Client(
                        rawClient.get("eui64").asText(),
                        rawClient.get("hostname").asText(),
                        rawClient.get("ip").asText(),
                        getIps(rawClient.get("ips")),
                        rawClient.get("mac").asText()));
            }

            return new ClientsData(clients.toArray(new Client[clients.size()]));
        }

        private String[] getIps(JsonNode rawIps) {
            final List<String> ips = new ArrayList<>();

            for (int i = 0; rawIps.has(i); i++) {
                JsonNode rawIp = rawIps.get(i);
                ips.add(rawIp.asText());
            }

            return ips.toArray(new String[ips.size()]);
        }
    }
}
