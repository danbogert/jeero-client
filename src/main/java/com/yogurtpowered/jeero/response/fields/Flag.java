package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@JsonDeserialize(using = Flag.FlagDeserializer.class)
public abstract class Flag {
    protected final String flag;

    public Flag(@JsonProperty("flag") String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public static class FlagDeserializer extends StdDeserializer<Flag> {
        public FlagDeserializer() {
            this(null);
        }

        protected FlagDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Flag deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            String flag = node.get("flag").asText();

            JsonNode valueNode = node.get("value");
            switch (valueNode.getNodeType()) {
                case BOOLEAN:
                    return new BooleanFlag(flag, valueNode.booleanValue());
                case OBJECT:
                    Map<String, String> values = new HashMap<>();
                    Iterator<Map.Entry<String, JsonNode>> iter = valueNode.fields();

                    while (iter.hasNext()) {
                        Map.Entry<String, JsonNode> value = iter.next();
                        values.put(value.getKey(), value.getValue().asText());
                    }

                    return new MapFlag(flag, values);
                default:
                    throw new IOException("Unsupported flag type: " + valueNode.getNodeType());
            }
        }
    }
}
