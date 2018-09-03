package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yogurtpowered.jeero.response.fields.Client;
import com.yogurtpowered.jeero.response.fields.Connectivity;
import com.yogurtpowered.jeero.response.fields.Device;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.ConnectException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class DevicesResponseTest {
    private static String testResponse;
    private static ObjectMapper mapper;

    @BeforeClass
    public static void setUpBeforeClass() throws IOException {
        testResponse = new String(Files.readAllBytes(Paths.get("src/test/resources/devicesResponse.json")));
        mapper = new ObjectMapper();
    }

    @Test
    public void testParseResponse() throws IOException {
        final DevicesResponse dr = mapper.readValue(testResponse, DevicesResponse.class);

        assertEquals(200, dr.getMeta().getResponseCode());

        DevicesResponse.DevicesData data = dr.getData();
        assertEquals(1, data.getDevices().length);
        Device device = data.getDevices()[0];
        assertTrue(device.isConnected());
        assertEquals("wireless", device.getConnectionType());
        Connectivity conn = device.getConnectivity();
        assertEquals("50.0 MBit/s", conn.getRxBitrate());
        assertEquals(1, conn.getScore());
        assertEquals(5, conn.getScoreBars());
        assertEquals("-50 dBm", conn.getSignal());
        assertEquals("-49 dBm", conn.getSignalAverage());
        assertEquals("generic", device.getDeviceType());
        assertEquals("111111fffe111111", device.getEui64());
        assertEquals("2018", device.getFirstActive());
        assertNull(device.getHostname());
        assertEquals("2.4", device.getInterface().getFrequency());
        assertEquals("GHz", device.getInterface().getFrequencyUnit());
        assertEquals("192.168.5.1", device.getIp());
        assertArrayEquals(new String[] { "192.168.5.1" }, device.getIps());
        assertEquals("2018", device.getLastActive());
        assertEquals("11:11:11:11:11:11", device.getMac());
        assertEquals("SAMSUNG", device.getManufacturer());
        assertNull(device.getNickname());
        assertNull(device.getProfile());
        assertEquals("eero1", device.getSource().getLocation());
        assertEquals("/2.2/networks/4916/devices/1", device.getUrl());
        assertEquals(7.74e-05, device.getUsage().getDownMbps(), .01);
        assertEquals(6.87e-05, device.getUsage().getUpMbps(), .01);
        assertTrue(device.getWireless());
    }
}
