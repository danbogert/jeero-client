package com.yogurtpowered.jeero.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yogurtpowered.jeero.response.fields.Data;
import com.yogurtpowered.jeero.response.fields.Meta;

public class LoginResponse extends Response<LoginResponse.LoginData> {

    public LoginResponse(@JsonProperty("meta") Meta meta, @JsonProperty("data") LoginData data) {
        super(meta, data);
    }

    public static class LoginData extends Data {
        private final String userToken;

        public LoginData(@JsonProperty("user_token") String userToken) {
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
