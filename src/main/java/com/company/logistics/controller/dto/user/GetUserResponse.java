package com.company.logistics.controller.dto.user;

import com.company.logistics.model.Account;

import java.util.List;

public class GetUserResponse {
    private List<Account> item;
    private int total;

    // getters and setters
    public List<Account> getItem() {
        return item;
    }

    public void setItem(List<Account> item) {
        this.item = item;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}
