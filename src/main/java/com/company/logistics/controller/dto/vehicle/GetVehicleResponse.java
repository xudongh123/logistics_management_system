package com.company.logistics.controller.dto.vehicle;

import com.company.logistics.model.Vehicle;

import java.util.List;

public class GetVehicleResponse {
    private List<Vehicle> item;

    private int total;

    // getters and setters
    public List<Vehicle> getItem() {
        return item;
    }

    public void setItem(List<Vehicle> item) {
        this.item = item;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
