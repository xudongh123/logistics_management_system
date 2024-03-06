package com.company.logistics.model;

public class Profit {

    private String id;
    private double receive;
    private double pay;
    private double receiveNow;
    private boolean isReceive;
    private double payNow;
    private boolean isPay;
    private String token;

    // Getters
    public String getId() {
        return id;
    }

    public double getReceive() {
        return receive;
    }

    public double getPay() {
        return pay;
    }

    public double getReceiveNow() {
        return receiveNow;
    }

    public boolean getIsReceive() {
        return isReceive;
    }

    public double getPayNow() {
        return payNow;
    }

    public boolean getIsPay() {
        return isPay;
    }
    public String getToken() {
        return token;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setReceive(double receive) {
        this.receive = receive;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public void setReceiveNow(double receiveNow) {
        this.receiveNow = receiveNow;
    }

    public void setIsReceive(boolean isReceive) {
        this.isReceive = isReceive;
    }

    public void setPayNow(double payNow) {
        this.payNow = payNow;
    }

    public void setIsPay(boolean isPay) {
        this.isPay = isPay;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
