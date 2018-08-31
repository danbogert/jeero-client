package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yogurtpowered.jeero.response.fields.*;

public class AccountResponse extends Response<AccountResponse.AccountData> {

    public AccountResponse(@JsonProperty("meta") Meta meta, @JsonProperty("data") AccountData data) {
        super(meta, data);
    }

    public static class AccountData extends Data {
        private final String name;
        private final PhoneNumber phoneNumber;
        private final EmailAddress emailAddress;
        private final String logId;
        private final String organizationId;
        private final Networks networks;
        private final String role;
        private final boolean canTransfer;
        private final String premiumStatus;
        private final PushSettings pushSettings;
        private final String trustCertificatesEtag;

        public AccountData(
                @JsonProperty("name") String name,
                @JsonProperty("phone") PhoneNumber phoneNumber,
                @JsonProperty("email") EmailAddress emailAddress,
                @JsonProperty("log_id") String logId,
                @JsonProperty("organization_id") String organizationId,
                @JsonProperty("networks") Networks networks,
                @JsonProperty("role") String role,
                @JsonProperty("can_transfer") boolean canTransfer,
                @JsonProperty("premium_status") String premiumStatus,
                @JsonProperty("push_settings") PushSettings pushSettings,
                @JsonProperty("trust_certificates_etag") String trustCertificatesEtag) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
            this.logId = logId;
            this.organizationId = organizationId;
            this.networks = networks;
            this.role = role;
            this.canTransfer = canTransfer;
            this.premiumStatus = premiumStatus;
            this.pushSettings = pushSettings;
            this.trustCertificatesEtag = trustCertificatesEtag;
        }

        public String getName() {
            return name;
        }

        public PhoneNumber getPhoneNumber() {
            return phoneNumber;
        }

        public EmailAddress getEmailAddress() {
            return emailAddress;
        }

        public String getLogId() {
            return logId;
        }

        public String getOrganizationId() {
            return organizationId;
        }

        public Networks getNetworks() {
            return networks;
        }

        public String getRole() {
            return role;
        }

        public boolean isCanTransfer() {
            return canTransfer;
        }

        public String getPremiumStatus() {
            return premiumStatus;
        }

        public PushSettings getPushSettings() {
            return pushSettings;
        }

        public String getTrustCertificatesEtag() {
            return trustCertificatesEtag;
        }

        @Override
        public String toString() {
            return "{" +
                    "\n\tname='" + name + '\'' +
                    "\n\tphoneNumber=" + phoneNumber +
                    "\n\temailAddress=" + emailAddress +
                    "\n\tlogId='" + logId + '\'' +
                    "\n\torganizationId='" + organizationId + '\'' +
                    "\n\tnetworks=" + networks +
                    "\n\trole='" + role + '\'' +
                    "\n\tcanTransfer=" + canTransfer +
                    "\n\tpremiumStatus='" + premiumStatus + '\'' +
                    "\n\tpushSettings=" + pushSettings +
                    "\n\ttrustCertificatesEtag='" + trustCertificatesEtag + '\'' +
                    '}';
        }
    }
}
