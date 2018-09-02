package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.TimeZone;

public class AccountTest {
    private static String testResponse;
    private static ObjectMapper mapper;

    @BeforeClass
    public static void setUpBeforeClass() throws IOException {
        testResponse = new String(Files.readAllBytes(Paths.get("src/test/resources/accountResponse.json")));
        mapper = new ObjectMapper();
    }

    @Test
    public void testParseResponse() throws IOException {
        final AccountResponse account = mapper.readValue(testResponse, AccountResponse.class);

        assertEquals(200, account.getMeta().getResponseCode());
        assertEquals("My Name", account.getData().getName());

        assertEquals("+1234567890", account.getData().getPhoneNumber().getValue());
        assertTrue(account.getData().getPhoneNumber().getVerified());

        assertEquals("email@example.com", account.getData().getEmailAddress().getValue());
        assertTrue(account.getData().getEmailAddress().getVerified());

        assertEquals("UID0000000000", account.getData().getLogId());
        assertNull(account.getData().getOrganizationId());

        assertEquals(1, account.getData().getNetworks().getCount());
        assertEquals("/2.2/networks/1234", account.getData().getNetworks().getNetworks()[0].getUrl());
        assertEquals("ssid", account.getData().getNetworks().getNetworks()[0].getName());
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(951436800000L);
        assertEquals(calendar.getTime(), account.getData().getNetworks().getNetworks()[0].getCreated());

        assertEquals("none", account.getData().getRole());
        assertFalse(account.getData().isCanTransfer());
        assertEquals("trial_eligible", account.getData().getPremiumStatus());
        assertFalse(account.getData().getPushSettings().isNetworkOffline());
        assertFalse(account.getData().getPushSettings().isNodeOffline());
        assertEquals("cert-etag-value", account.getData().getTrustCertificatesEtag());
    }
}
