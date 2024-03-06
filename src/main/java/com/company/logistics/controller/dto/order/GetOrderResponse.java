package com.company.logistics.controller.dto.order;

import com.company.logistics.model.Order;

import java.util.List;

public class GetOrderResponse {
    private List<Order> item;

    // getters and setters
    public List<Order> getItem() {
        return item;
    }

    public void setItem(List<Order> item) {
        this.item = item;
    }
}


