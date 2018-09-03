package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.yogurtpowered.jeero.response.fields.Data;
import com.yogurtpowered.jeero.response.fields.Device;
import com.yogurtpowered.jeero.response.fields.Meta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DevicesResponse extends Response<DevicesResponse.DevicesData> {

    public DevicesResponse(@JsonProperty("meta") Meta meta, @JsonProperty("data") DevicesData data) {
        super(meta, data);
    }

    @JsonDeserialize(using = DevicesResponse.DevicesDeserializer.class)
    public static class DevicesData extends Data {
        private final Device[] devices;

        public DevicesData(Device[] devices) {
            this.devices = devices;
        }

        public Device[] getDevices() {
            return devices;
        }

        @Override
        public String toString() {
            return "{" +
                    "\n\tdevices=" + Arrays.toString(devices) +
                    '}';
        }
    }

    public static class DevicesDeserializer extends StdDeserializer<DevicesResponse.DevicesData> {
        public DevicesDeserializer() {
            this(null);
        }

        protected DevicesDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public DevicesResponse.DevicesData deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException {
            final List<Device> devices = new ArrayList<>();

            if (JsonToken.START_ARRAY == jp.getCurrentToken()) {
                jp.nextToken();
                while (JsonToken.END_ARRAY != jp.getCurrentToken()) {
                    devices.add(ctxt.readValue(jp, Device.class));
                    jp.nextToken();
                }
            }

            return new DevicesData(devices.toArray(new Device[devices.size()]));
        }
    }
}
