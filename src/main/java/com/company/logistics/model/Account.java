package com.company.logistics.model;

public class Account {
    private String token;
    private String username;
    private String password;
    private int permissionLevel;

    // getters
    public String getToken() {
        return this.token;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getPermissionLevel() {
        return this.permissionLevel;
    }

    // setters
    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }
}
