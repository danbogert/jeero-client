package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class LoginResponseTest {
    private static String testResponse;
    private static ObjectMapper mapper;

    @BeforeClass
    public static void setUpBeforeClass() throws IOException {
        testResponse = new String(Files.readAllBytes(Paths.get("src/test/resources/loginResponse.json")));
        mapper = new ObjectMapper();
    }

    @Test
    public void testParseResponse() throws IOException {
        final LoginResponse lr = mapper.readValue(testResponse, LoginResponse.class);

        assertEquals(200, lr.getMeta().getResponseCode());
        assertEquals("fake-user-token", lr.getData().getUserToken());
    }
}
