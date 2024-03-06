package com.company.logistics.model;

import java.util.Date;

public class Account {
    private String token;
    private String username;
    private String password;
    private int permissionLevel;
    private String nickname;
    private String sex;
    private Date time;

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

    public String getNickname() {
        return this.nickname;
    }

    public String getSex() {
        return this.sex;
    }

    public Date getTime() {
        return time;
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

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
