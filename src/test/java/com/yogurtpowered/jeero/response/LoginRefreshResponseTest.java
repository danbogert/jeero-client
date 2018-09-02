package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class LoginRefreshResponseTest {
    private static String testResponse;
    private static ObjectMapper mapper;

    @BeforeClass
    public static void setUpBeforeClass() throws IOException {
        testResponse = new String(Files.readAllBytes(Paths.get("src/test/resources/loginRefreshResponse.json")));
        mapper = new ObjectMapper();
    }

    @Test
    public void testParseResponse() throws IOException {
        final LoginRefreshResponse lrr = mapper.readValue(testResponse, LoginRefreshResponse.class);

        assertEquals(200, lrr.getMeta().getResponseCode());
        assertEquals("1234567|stuff", lrr.getData().getUserToken());
    }
}
