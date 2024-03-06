package com.company.logistics.controller.dto.vehicle;

import java.time.LocalDateTime;
import java.util.Date;

public class SetVehicleRequest {
    private String plate;
    private String type;
    private String resource;
    private String twoPlate;
    private String driverPhone;
    private String driverName;
    private String energy;
    private String length;
    private String weight;
    private String vin;
    private String brand;
    private String engine;
    private int axle;
    private String wheelbase;
    private int tire;
    private Date factoryTime;
    private Date buyTime;
    private double buyPrice;
    private Date limitedTime;
    private String remark;
    private String token;

    // getters and setters
    // ...
    public String getPlate() {
        return plate;
    }

    public String getType() {
        return type;
    }

    public String getResource() {
        return resource;
    }

    public String getTwoPlate() {
        return twoPlate;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getEnergy() {
        return energy;
    }

    public String getLength() {
        return length;
    }

    public String getWeight() {
        return weight;
    }

    public String getVin() {
        return vin;
    }

    public String getBrand() {
        return brand;
    }

    public String getEngine() {
        return engine;
    }

    public int getAxle() {
        return axle;
    }

    public String getWheelbase() {
        return wheelbase;
    }

    public int getTire() {
        return tire;
    }

    public Date getFactoryTime() {
        return factoryTime;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public Date getLimitedTime() {
        return limitedTime;
    }

    public String getRemark() {
        return remark;
    }

    public String getToken() {
        return token;
    }

    //setters
    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setTwoPlate(String twoPlate) {
        this.twoPlate = twoPlate;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setAxle(int axle) {
        this.axle = axle;
    }

    public void setWheelbase(String wheelbase) {
        this.wheelbase = wheelbase;
    }

    public void setTire(int tire) {
        this.tire = tire;
    }

    public void setFactoryTime(Date factoryTime) {
        this.factoryTime = factoryTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setLimitedTime(Date limitedTime) {
        this.limitedTime = limitedTime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
