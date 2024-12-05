package com.example.project;

public class LoginManager {
    private final AuthenticationService authenticationService;

    public LoginManager(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public boolean login(String username, String password) throws Exception {
        if (username == null || password == null) {
            throw new Exception("Username and password cannot be null");
        }
        return authenticationService.authenticate(username, password);
    }
}
