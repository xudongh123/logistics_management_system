package com.company.logistics.controller.dto.profit;

import com.company.logistics.model.Profit;

import java.util.List;

public class GetProfitResponse {
    private List<Profit> item;
    private int total;

    // getters and setters
    public List<Profit> getItem() {
        return item;
    }

    public void setItem(List<Profit> item) {
        this.item = item;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}
