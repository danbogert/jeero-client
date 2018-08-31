package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LoginResponseTest {

    private static final String TEST_RESPONSE = "{\"meta\":{\"code\":200,\"server_time\":\"2018-08-18T20:56:29.542Z\"},\"data\":{\"user_token\":\"fake-user-token\"}}";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void testParseResponse() throws IOException {
        final LoginResponse lr = MAPPER.readValue(TEST_RESPONSE, LoginResponse.class);

        assertEquals(200, lr.getMeta().getResponseCode());
        assertEquals("fake-user-token", lr.getData().getUserToken());
    }
}
