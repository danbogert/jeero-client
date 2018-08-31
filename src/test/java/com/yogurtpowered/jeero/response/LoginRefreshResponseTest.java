package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LoginRefreshResponseTest {

    private static final String TEST_RESPONSE = "{\"meta\":{\"code\":200,\"server_time\":\"2018-08-25T02:30:19.758Z\"},\"data\":{\"user_token\":\"1234567|stuff\"}}";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void testParseResponse() throws IOException {
        final LoginRefreshResponse lrr = MAPPER.readValue(TEST_RESPONSE, LoginRefreshResponse.class);

        assertEquals(200, lrr.getMeta().getResponseCode());
        assertEquals("1234567|stuff", lrr.getData().getUserToken());
    }
}
