package com.company.logistics.controller.dto.order;

public class RefuseOrderRequest {
    private String token;
    private String id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
