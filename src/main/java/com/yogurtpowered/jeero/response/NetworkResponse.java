package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yogurtpowered.jeero.response.fields.*;

import java.util.Arrays;
import java.util.Map;

public class NetworkResponse extends Response<NetworkResponse.NetworkData> {

    public NetworkResponse(@JsonProperty("meta") Meta meta, @JsonProperty("data") NetworkData data) {
        super(meta, data);
    }

    public static class NetworkData extends Data {
        private final String url;
        private final Map<String, String> resources;
        private final Flag[] flags;
        private final String name;
        private final String password;
        private final String status;
        private final String gateway;
        private final String wanIp;
        private final GeoIp geoIp;
        private final String gatewayIp;
        private final Map.Entry<String, String> connection;
        private final boolean upnp;
        private final boolean ipv6Upstream;
        private final boolean thread;
        private final boolean sqm;
        private final boolean bandSteering;
        private final String owner;
        private final String premiumStatus;
        private final Clients clients;
        private final IpSettings ipSettings;
        private final Health health;
        private final Speed speed;
        private final Eeros eeros;
        private final Timezone timezone;
        private final Mode dhcp;
        private final ParentMode dns;
        private final Lease lease;
        private final Updates updates;
        private final PremiumDns premiumDns;
        private final Map<String, Capability> capabilities;
        private final String[] messages;
        private final String[] upstream;
        private final String rebooting;
        private final String lastReboot;
        private final String ipv6Lease;
        private final String organization;
        private final String imageAssets;

        public NetworkData(@JsonProperty("url") String url,
                           @JsonProperty("resources") Map<String, String> resources,
                           @JsonProperty("flags") Flag[] flags,
                           @JsonProperty("name") String name,
                           @JsonProperty("password") String password,
                           @JsonProperty("status") String status,
                           @JsonProperty("gateway") String gateway,
                           @JsonProperty("wan_ip") String wanIp,
                           @JsonProperty("geo_ip") GeoIp geoIp,
                           @JsonProperty("gateway_ip") String gatewayIp,
                           @JsonProperty("connection") Map.Entry<String, String> connection,
                           @JsonProperty("upnp") boolean upnp,
                           @JsonProperty("ipv6_upstream") boolean ipv6Upstream,
                           @JsonProperty("thread") boolean thread,
                           @JsonProperty("sqm") boolean sqm,
                           @JsonProperty("band_steering") boolean bandSteering,
                           @JsonProperty("owner") String owner,
                           @JsonProperty("premium_status") String premiumStatus,
                           @JsonProperty("clients") Clients clients,
                           @JsonProperty("ip_settings") IpSettings ipSettings,
                           @JsonProperty("health") Health health,
                           @JsonProperty("speed") Speed speed,
                           @JsonProperty("eeros") Eeros eeros,
                           @JsonProperty("timezone") Timezone timezone,
                           @JsonProperty("dhcp") Mode dhcp,
                           @JsonProperty("dns") ParentMode dns,
                           @JsonProperty("lease") Lease lease,
                           @JsonProperty("updates") Updates updates,
                           @JsonProperty("premium_dns") PremiumDns premiumDns,
                           @JsonProperty("capabilities") Map<String, Capability> capabilities,
                           @JsonProperty("messages") String[] messages,
                           @JsonProperty("upstream") String[] upstream,
                           @JsonProperty("rebooting") String rebooting,
                           @JsonProperty("last_reboot") String lastReboot,
                           @JsonProperty("ipv6_lease") String ipv6Lease,
                           @JsonProperty("organization") String organization,
                           @JsonProperty("image_assets") String imageAssets) {
            this.url = url;
            this.resources = resources;
            this.flags = flags;
            this.name = name;
            this.password = password;
            this.status = status;
            this.gateway = gateway;
            this.wanIp = wanIp;
            this.geoIp = geoIp;
            this.gatewayIp = gatewayIp;
            this.connection = connection;
            this.upnp = upnp;
            this.ipv6Upstream = ipv6Upstream;
            this.thread = thread;
            this.sqm = sqm;
            this.bandSteering = bandSteering;
            this.owner = owner;
            this.premiumStatus = premiumStatus;
            this.clients = clients;
            this.ipSettings = ipSettings;
            this.health = health;
            this.speed = speed;
            this.eeros = eeros;
            this.timezone = timezone;
            this.dhcp = dhcp;
            this.dns = dns;
            this.lease = lease;
            this.updates = updates;
            this.premiumDns = premiumDns;
            this.capabilities = capabilities;
            this.messages = messages;
            this.upstream = upstream;
            this.rebooting = rebooting;
            this.lastReboot = lastReboot;
            this.ipv6Lease = ipv6Lease;
            this.organization = organization;
            this.imageAssets = imageAssets;
        }

        public String getUrl() {
            return url;
        }

        public Map<String, String> getResources() {
            return resources;
        }

        public Flag[] getFlags() {
            return flags;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        public String getStatus() {
            return status;
        }

        public String getGateway() {
            return gateway;
        }

        public String getWanIp() {
            return wanIp;
        }

        public GeoIp getGeoIp() {
            return geoIp;
        }

        public String getGatewayIp() {
            return gatewayIp;
        }

        public Map.Entry<String, String> getConnection() {
            return connection;
        }

        public boolean isUpnp() {
            return upnp;
        }

        public boolean isIpv6Upstream() {
            return ipv6Upstream;
        }

        public boolean isThread() {
            return thread;
        }

        public boolean isSqm() {
            return sqm;
        }

        public boolean isBandSteering() {
            return bandSteering;
        }

        public String getOwner() {
            return owner;
        }

        public String getPremiumStatus() {
            return premiumStatus;
        }

        public Clients getClients() {
            return clients;
        }

        public IpSettings getIpSettings() {
            return ipSettings;
        }

        public Health getHealth() {
            return health;
        }

        public Speed getSpeed() {
            return speed;
        }

        public Eeros getEeros() {
            return eeros;
        }

        public Timezone getTimezone() {
            return timezone;
        }

        public Mode getDhcp() {
            return dhcp;
        }

        public ParentMode getDns() {
            return dns;
        }

        public Lease getLease() {
            return lease;
        }

        public Updates getUpdates() {
            return updates;
        }

        public PremiumDns getPremiumDns() {
            return premiumDns;
        }

        public Map<String, Capability> getCapabilities() {
            return capabilities;
        }

        public String[] getMessages() {
            return messages;
        }

        public String[] getUpstream() {
            return upstream;
        }

        public String getRebooting() {
            return rebooting;
        }

        public String getLastReboot() {
            return lastReboot;
        }

        public String getIpv6Lease() {
            return ipv6Lease;
        }

        public String getOrganization() {
            return organization;
        }

        public String getImageAssets() {
            return imageAssets;
        }

        @Override
        public String toString() {
            return "{" +
                    "\n\turl='" + url + '\'' +
                    "\n\tresources=" + resources +
                    "\n\tflags=" + Arrays.toString(flags) +
                    "\n\tname='" + name + '\'' +
                    "\n\tpassword='" + password + '\'' +
                    "\n\tstatus='" + status + '\'' +
                    "\n\tgateway='" + gateway + '\'' +
                    "\n\twanIp='" + wanIp + '\'' +
                    "\n\tgeoIp=" + geoIp +
                    "\n\tgatewayIp='" + gatewayIp + '\'' +
                    "\n\tconnection=" + connection +
                    "\n\tupnp=" + upnp +
                    "\n\tipv6Upstream=" + ipv6Upstream +
                    "\n\tthread=" + thread +
                    "\n\tsqm=" + sqm +
                    "\n\tbandSteering=" + bandSteering +
                    "\n\towner='" + owner + '\'' +
                    "\n\tpremiumStatus='" + premiumStatus + '\'' +
                    "\n\tclients=" + clients +
                    "\n\tipSettings=" + ipSettings +
                    "\n\thealth=" + health +
                    "\n\tspeed=" + speed +
                    "\n\teeros=" + eeros +
                    "\n\ttimezone=" + timezone +
                    "\n\tdhcp=" + dhcp +
                    "\n\tdns=" + dns +
                    "\n\tlease=" + lease +
                    "\n\tupdates=" + updates +
                    "\n\tpremiumDns=" + premiumDns +
                    "\n\tcapabilities=" + capabilities +
                    "\n\tmessages=" + Arrays.toString(messages) +
                    "\n\tupstream=" + Arrays.toString(upstream) +
                    "\n\trebooting=" + rebooting +
                    "\n\tlastReboot=" + lastReboot +
                    "\n\tipv6Lease=" + ipv6Lease +
                    "\n\torganization=" + organization +
                    "\n\timageAssets=" + imageAssets +
                    '}';
        }
    }
}
