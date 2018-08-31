package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Updates {
    private final String minRequiredFirmware;
    private final String targetFirmware;
    private final String updateToFirmware;
    private final boolean updateRequired;
    private final boolean canUpdateNow;
    private final boolean hasUpdate;
    private final String updateStatus;
    private final String lastUpdateStarted;
    private final LastUserUpdate lastUserUpdate;

    public Updates(@JsonProperty("min_required_firmware") String minRequiredFirmware,
                   @JsonProperty("target_firmware") String targetFirmware,
                   @JsonProperty("update_to_firmware") String updateToFirmware,
                   @JsonProperty("update_required") boolean updateRequired,
                   @JsonProperty("can_update_now") boolean canUpdateNow,
                   @JsonProperty("has_update") boolean hasUpdate,
                   @JsonProperty("update_status") String updateStatus,
                   @JsonProperty("last_update_started") String lastUpdateStarted,
                   @JsonProperty("last_user_update") LastUserUpdate lastUserUpdate) {
        this.minRequiredFirmware = minRequiredFirmware;
        this.targetFirmware = targetFirmware;
        this.updateToFirmware = updateToFirmware;
        this.updateRequired = updateRequired;
        this.canUpdateNow = canUpdateNow;
        this.hasUpdate = hasUpdate;
        this.updateStatus = updateStatus;
        this.lastUpdateStarted = lastUpdateStarted;
        this.lastUserUpdate = lastUserUpdate;
    }

    public String getMinRequiredFirmware() {
        return minRequiredFirmware;
    }

    public String getTargetFirmware() {
        return targetFirmware;
    }

    public String getUpdateToFirmware() {
        return updateToFirmware;
    }

    public boolean isUpdateRequired() {
        return updateRequired;
    }

    public boolean isCanUpdateNow() {
        return canUpdateNow;
    }

    public boolean isHasUpdate() {
        return hasUpdate;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public String getLastUpdateStarted() {
        return lastUpdateStarted;
    }

    public LastUserUpdate getLastUserUpdate() {
        return lastUserUpdate;
    }

    @Override
    public String toString() {
        return "Updates{" +
                "minRequiredFirmware='" + minRequiredFirmware + '\'' +
                ", targetFirmware='" + targetFirmware + '\'' +
                ", updateToFirmware='" + updateToFirmware + '\'' +
                ", updateRequired=" + updateRequired +
                ", canUpdateNow=" + canUpdateNow +
                ", hasUpdate=" + hasUpdate +
                ", updateStatus='" + updateStatus + '\'' +
                ", lastUpdateStarted='" + lastUpdateStarted + '\'' +
                ", lastUserUpdate=" + lastUserUpdate +
                '}';
    }
}
