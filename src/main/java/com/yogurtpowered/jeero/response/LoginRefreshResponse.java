package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yogurtpowered.jeero.response.fields.Data;
import com.yogurtpowered.jeero.response.fields.Meta;

public class LoginRefreshResponse extends Response<LoginRefreshResponse.LoginRefreshData> {

    public LoginRefreshResponse(@JsonProperty("meta") Meta meta, @JsonProperty("data") LoginRefreshData data) {
        super(meta, data);
    }

    public static class LoginRefreshData extends Data {
        private final String userToken;

        public LoginRefreshData(@JsonProperty("user_token") String userToken) {
            this.userToken = userToken;
        }

        public String getUserToken() {
            return userToken;
        }

        @Override
        public String toString() {
            return "{" +
                    "\n\tuserToken='" + userToken + '\'' +
                    '}';
        }
    }
}
