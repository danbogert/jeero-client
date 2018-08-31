package com.yogurtpowered.jeero.command;

import com.yogurtpowered.jeero.response.AccountResponse;
import com.yogurtpowered.jeero.response.LoginResponse;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.*;
import java.util.Optional;

public class LoginCommand extends AbstractRestCommand<Boolean> {
    protected static final String COOKIE_FILE = ".jeeroClient";

    @Override
    public Optional<Boolean> execute() {
        loadCookie();

        if (!HTTP_HEADERS.containsKey("Cookie")) {
            login();
        }

        return Optional.of(Boolean.TRUE);
    }

    private void loadCookie() {
        try (FileReader fileReader = new FileReader(COOKIE_FILE);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String cookie = bufferedReader.readLine();
            if (cookie != null && cookie.startsWith("s=")) {
                HTTP_HEADERS.set("Cookie", cookie);
            }
        } catch (IOException ioe) {
            // Do nothing
        }
    }

    private void storeCookie(String cookie) {
        try (FileWriter fileWriter = new FileWriter(COOKIE_FILE);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            bufferedWriter.write(cookie);
        } catch (IOException ioe) {
            // Do nothing
        }
    }

    private void login() {
        System.out.print("Phone number? ");
        String phoneNumber = SCANNER.nextLine();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(API_BASE_URL)
                .path("login")
                .queryParam("login", phoneNumber);

        LoginResponse loginResponse = exchange(builder.toUriString(), HttpMethod.POST, LoginResponse.class);

        String cookie = "s=" + loginResponse.getData().getUserToken();
        storeCookie(cookie);
        HTTP_HEADERS.set("Cookie", cookie);

        loginVerify();
    }

    private void loginVerify() {
        System.out.print("Verification code? ");
        String verificationCode = SCANNER.nextLine();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(API_BASE_URL)
                .path("login/verify")
                .queryParam("code", verificationCode);

        exchange(builder.toUriString(), HttpMethod.POST, AccountResponse.class);
    }
}
