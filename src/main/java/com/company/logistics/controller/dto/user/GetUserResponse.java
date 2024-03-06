package com.company.logistics.controller.dto.user;

import com.company.logistics.model.User;

import java.util.List;

public class GetUserResponse {
    private List<User> item;
    private int total;

    // getters and setters
    public List<User> getItem() {
        return item;
    }

    public void setItem(List<User> item) {
        this.item = item;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}
