package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

public class AccountTest {

    private static final String TEST_RESPONSE = "{\"meta\":{\"code\":200,\"server_time\":\"2018-08-17T02:52:33.898Z\"},\"data\":{\"name\":\"My Name\",\"phone\":{\"value\":\"+1234567890\",\"verified\":true},\"email\":{\"value\":\"email@example.com\",\"verified\":true},\"log_id\":\"UID0000000000\",\"organization_id\":null,\"networks\":{\"count\":1,\"data\":[{\"url\":\"/2.2/networks/1234\",\"name\":\"ssid\",\"created\":\"2000-02-25T00:00:00.000000Z\"}]},\"role\":\"none\",\"can_transfer\":false,\"premium_status\":\"trial_eligible\",\"push_settings\":{\"networkOffline\":false,\"nodeOffline\":false},\"trust_certificates_etag\":\"cert-etag-value\"}}";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void testParseResponse() throws IOException {
        final AccountResponse account = MAPPER.readValue(TEST_RESPONSE, AccountResponse.class);

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
