package com.company.logistics.controller.dto.driver;

import com.company.logistics.model.Driver;

import java.util.List;

public class GetDriverResponse {
    private List<Driver> item;

    // getters and setters
    public List<Driver> getItem() {
        return item;
    }

    public void setItem(List<Driver> item) {
        this.item = item;
    }
}
