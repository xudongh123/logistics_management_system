package com.company.logistics.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Vehicle {
    private int id;

    private String plate;
    private Date time;
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getTwoPlate() {
        return twoPlate;
    }

    public void setTwoPlate(String twoPlate) {
        this.twoPlate = twoPlate;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getAxle() {
        return axle;
    }

    public void setAxle(int axle) {
        this.axle = axle;
    }

    public String getWheelbase() {
        return wheelbase;
    }

    public void setWheelbase(String wheelbase) {
        this.wheelbase = wheelbase;
    }

    public int getTire() {
        return tire;
    }

    public void setTire(int tire) {
        this.tire = tire;
    }

    public Date getFactoryTime() {
        return factoryTime;
    }

    public void setFactoryTime(Date factoryTime) {
        this.factoryTime = factoryTime;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Date getLimitedTime() {
        return limitedTime;
    }

    public void setLimitedTime(Date limitedTime) {
        this.limitedTime = limitedTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
