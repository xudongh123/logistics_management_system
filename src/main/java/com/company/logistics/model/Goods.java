package com.company.logistics.model;

public class Goods {
    private String id;
    private String name;
    private int weight;
    private String size;
    private int number;
    private String remark;

    // Getter and Setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for weight
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // Getter and Setter for size
    public String getSize() {
        return size;
    }

    public void  setSize(String size) {
        this.size = size;
    }

    // Getter and Setter for number
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // Getter and Setter for remark
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
