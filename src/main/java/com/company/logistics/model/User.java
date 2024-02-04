package com.company.logistics.model;

public class User {
    private int userID;
    private String username;
    private String password;

    // getter methods
    public int getUserID() {
        return this.userID;
    }
    public String getUserName() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }

    // setter methods
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
