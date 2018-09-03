package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yogurtpowered.jeero.response.fields.Client;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ClientsResponseTest {
    private static String testResponse;
    private static ObjectMapper mapper;

    @BeforeClass
    public static void setUpBeforeClass() throws IOException {
        testResponse = new String(Files.readAllBytes(Paths.get("src/test/resources/clientsResponse.json")));
        mapper = new ObjectMapper();
    }

    @Test
    public void testParseResponse() throws IOException {
        final ClientsResponse cr = mapper.readValue(testResponse, ClientsResponse.class);

        assertEquals(200, cr.getMeta().getResponseCode());
        Client[] clients = cr.getData().getClients();
        assertEquals(2, clients.length);
        verifyClient(clients[0], "aaaaaafffeaaaaaa", "apple", "192.168.5.11", new String[] { "192.168.5.11" }, "aa:aa:aa:aa:aa:aa");
        verifyClient(clients[1], "bbbbbbfffebbbbbb", "linux", "192.168.5.22", new String[] { "192.168.5.22" }, "bb:bb:bb:bb:bb:bb");
    }

    private void verifyClient(Client client, String eui64, String hostname, String ip, String[] ips, String mac) {
        assertEquals(eui64, client.getEui64());
        assertEquals(hostname, client.getHostname());
        assertEquals(ip, client.getIp());
        assertArrayEquals(ips, client.getIps());
        assertEquals(mac, client.getMac());
    }
}
