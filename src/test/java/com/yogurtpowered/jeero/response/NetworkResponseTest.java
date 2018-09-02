package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yogurtpowered.jeero.response.fields.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.Assert.*;

public class NetworkResponseTest {
    private static String testResponse;
    private static ObjectMapper mapper;

    @BeforeClass
    public static void setUpBeforeClass() throws IOException {
        testResponse = new String(Files.readAllBytes(Paths.get("src/test/resources/networkResponse.json")));
        mapper = new ObjectMapper();
    }

    @Test
    public void testParseResponse() throws IOException {
        final NetworkResponse nr = mapper.readValue(testResponse, NetworkResponse.class);

        assertEquals(200, nr.getMeta().getResponseCode());

        NetworkResponse.NetworkData data = nr.getData();
        assertFalse(data.isBandSteering());
        Map<String, Capability> capabilities = data.getCapabilities();
        assertEquals(2, capabilities.size());
        assertFalse(capabilities.get("ad_block").isCapable());
        assertTrue(capabilities.get("led_action").isCapable());
        assertEquals(10, data.getClients().getCount());
        assertEquals("/2.2/networks/0000/clients", data.getClients().getUrl());
        assertEquals("nat", data.getConnection().getValue());
        assertNull(data.getDhcp().getCustom());
        assertEquals("automatic", data.getDhcp().getMode());
        ParentMode dns = data.getDns();
        assertFalse(dns.isCaching());
        assertNull(dns.getCustom());
        assertEquals("automatic", dns.getMode());
        assertEquals("192.168.1.1", dns.getParent().getIps()[0]);
        Eeros eeros = data.getEeros();
        assertEquals(3, eeros.getCount());
        for (int i = 1; i <= 3; i++) {
            verifyEero(eeros.getEeros()[i - 1], i, false, "192.168.5." + i,
                    "2016", null, false, "place" + i,
                    "mac" + i, new String[0], "model", "version",
                    "serial" + i, "green", false, "/2.2/eeros/" + i,
                    false, false);
        }
        Flag[] flags = data.getFlags();
        assertEquals(2, flags.length);
        assertEquals("disable_adaptive_ft", flags[0].getFlag());
        assertTrue(((BooleanFlag) flags[0]).isValue());
        assertEquals("realtime", flags[1].getFlag());
        assertEquals("prov", ((MapFlag) flags[1]).isValue().get("provider"));
        assertEquals("dhcp", data.getGateway());
        assertEquals("192.168.5.1", data.getGatewayIp());
        GeoIp geoIp = data.getGeoIp();
        assertEquals((Integer) 999, geoIp.getAreaCode());
        assertEquals("City", geoIp.getCity());
        assertEquals("US", geoIp.getCountryCode());
        assertEquals("United States", geoIp.getCountryName());
        assertEquals("Isp", geoIp.getIsp());
        assertEquals((Integer) 888, geoIp.getMetroCode());
        assertEquals("Org", geoIp.getOrg());
        assertEquals("12345", geoIp.getPostalCode());
        assertEquals("ST", geoIp.getRegion());
        assertEquals("State", geoIp.getRegionName());
        assertEquals("America/Zone", geoIp.getTimezone());
        assertEquals("connected", data.getHealth().getEeroNetwork().getStatus());
        assertTrue(data.getHealth().getInternet().isIspUp());
        assertEquals("connected", data.getHealth().getInternet().getStatus());
        assertNull(data.getImageAssets());
        assertTrue(data.getIpSettings().isDoubleNat());
        assertEquals("111.222.333.444", data.getIpSettings().getPublicIp());
        assertNull(data.getIpv6Lease());
        assertFalse(data.isIpv6Upstream());
        assertNull(data.getLastReboot());
        Lease lease = data.getLease();
        assertEquals("192.168.1.2", lease.getDhcp().getIp());
        assertEquals("255.255.255.0", lease.getDhcp().getMask());
        assertEquals("192.168.1.1", lease.getDhcp().getRouter());
        assertEquals("dhcp", lease.getMode());
        assertNull(lease.getStatik());
        assertArrayEquals(new String[0], data.getMessages());
        assertEquals("ssid", data.getName());
        assertNull(data.getOrganization());
        assertEquals("owner", data.getOwner());
        assertEquals("password", data.getPassword());
        PremiumDns premiumDns = data.getPremiumDns();
        assertFalse(premiumDns.isAnyPoliciesEnabledForNetwork());
        assertFalse(premiumDns.getDnsPolicies().isAdBlock());
        assertFalse(premiumDns.getDnsPolicies().isBlockMalware());
        assertFalse(premiumDns.isDnsPoliciesEnabled());
        assertFalse(premiumDns.isZscalerLocationEnabled());
        assertEquals("trial_eligible", data.getPremiumStatus());
        assertNull(data.getRebooting());
        assertEquals(19, data.getResources().size());
        assertEquals("/2.2/networks/4916/burst_reporters", data.getResources().get("burst_reporters"));
        assertEquals("/2.2/networks/4916/blacklist", data.getResources().get("device_blacklist"));
        assertEquals("/2.2/networks/4916/devices", data.getResources().get("devices"));
        assertEquals("/2.2/networks/4916/diagnostics", data.getResources().get("diagnostics"));
        assertEquals("/2.2/networks/4916/eeros", data.getResources().get("eeros"));
        assertEquals("/2.2/networks/4916/forwards", data.getResources().get("forwards"));
        assertEquals("/2.2/networks/4916/guestnetwork", data.getResources().get("guestnetwork"));
        assertEquals("/2.2/networks/4916/insights", data.getResources().get("insights"));
        assertEquals("/2.2/networks/4916/ouicheck", data.getResources().get("ouicheck"));
        assertEquals("/2.2/networks/4916/password", data.getResources().get("password"));
        assertEquals("/2.2/networks/4916/profiles", data.getResources().get("profiles"));
        assertEquals("/2.2/networks/4916/reboot", data.getResources().get("reboot"));
        assertEquals("/2.2/networks/4916/reservations", data.getResources().get("reservations"));
        assertEquals("/2.2/networks/4916/settings", data.getResources().get("settings"));
        assertEquals("/2.2/networks/4916/speedtest", data.getResources().get("speedtest"));
        assertEquals("/2.2/networks/4916/support", data.getResources().get("support"));
        assertEquals("/2.2/networks/4916/thread", data.getResources().get("thread"));
        assertEquals("/2.2/networks/4916/transfer", data.getResources().get("transfer"));
        assertEquals("/2.2/networks/4916/updates", data.getResources().get("updates"));
        Speed speed = data.getSpeed();
        assertEquals("2018-08-31T13:20:44Z", speed.getDate());
        assertEquals("Mbps", speed.getDown().getUnits());
        assertEquals(500.279256, speed.getDown().getValue(), .01);
        assertEquals("none", speed.getStatus());
        assertEquals("Mbps", speed.getUp().getUnits());
        assertEquals(600.850336, speed.getUp().getValue(), .01);
        assertFalse(data.isSqm());
        assertEquals("connected", data.getStatus());
        assertFalse(data.isThread());
        assertEquals("America/Zone", data.getTimezone().getGeoIp());
        assertNull(data.getTimezone().getValue());
        Updates updates = data.getUpdates();
        assertFalse(updates.isCanUpdateNow());
        assertEquals("2018-08-23T05:17:48.107242Z", updates.getLastUpdateStarted());
        assertArrayEquals(new String[0], updates.getLastUserUpdate().getIncompleteEeros());
        assertEquals("2018-08-23T05:17:48.107242Z", updates.getLastUserUpdate().getLastUpdateStarted());
        assertArrayEquals(new String[0], updates.getLastUserUpdate().getUnresponsiveEeros());
        assertEquals("v1.1.2", updates.getMinRequiredFirmware());
        assertEquals("v3.9.1-3", updates.getTargetFirmware());
        assertFalse(updates.isUpdateRequired());
        assertNull(updates.getUpdateStatus());
        assertEquals("v3.9.1-3", updates.getUpdateToFirmware());
        assertTrue(data.isUpnp());
        assertArrayEquals(new String[0], data.getUpstream());
        assertEquals("/2.2/networks/4916", data.getUrl());
        assertEquals("192.168.1.2", data.getWanIp());
    }

    private void verifyEero(Eeros.Eero eero, int connectedClients, boolean gateway, String ipAddress, String joined,
                            String lastReboot, boolean ledOn, String location, String macAddress, String[] messages,
                            String modelNumber, String osVersion, String serial, String status,
                            boolean updateAvailable, String url, boolean usingWan, boolean wired) {
        assertEquals(connectedClients, eero.getConnectedClientsCount());
        assertEquals(gateway, eero.isGateway());
        assertEquals(ipAddress, eero.getIpAddress());
        assertEquals(joined, eero.getJoined());
        assertEquals(lastReboot, eero.getLastReboot());
        assertEquals(ledOn, eero.isLedOn());
        assertEquals(location, eero.getLocation());
        assertEquals(macAddress, eero.getMacAddress());
        assertArrayEquals(messages, eero.getMessages());
        assertEquals(modelNumber, eero.getModelNumber());
        assertEquals(osVersion, eero.getOsVersion());
        assertEquals(serial, eero.getSerial());
        assertEquals(status, eero.getStatus());
        assertEquals(updateAvailable, eero.isUpdateAvailable());
        assertEquals(url, eero.getUrl());
        assertEquals(usingWan, eero.isUsingWan());
        assertEquals(wired, eero.isWired());


    }
}
