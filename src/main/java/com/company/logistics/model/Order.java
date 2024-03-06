package com.company.logistics.model;

import java.util.Date;

public class Order {
    private String id;
    private String orderNumber;
    private String status;
    private String sendName;
    private String sendPhone;
    private String sendAddr;
    private String sendAddrInfo;
    private String receiveName;
    private String receivePhone;
    private String receiveAddr;
    private String receiveAddrInfo;
    private String dispatchingType;
    private Date sendTime;
    private Date receiveTime;
    private boolean isCompany;
    private String token;

    private Date time;

    // getters
    public String getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getSendName() {
        return sendName;
    }

    public String getSendPhone() {
        return sendPhone;
    }

    public String getSendAddr() {
        return sendAddr;
    }

    public String getSendAddrInfo() {
        return sendAddrInfo;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public String getReceiveAddr() {
        return receiveAddr;
    }

    public String getReceiveAddrInfo() {
        return receiveAddrInfo;
    }

    public String getDispatchingType() {
        return dispatchingType;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public boolean getIsCompany() {
        return isCompany;
    }

    public String getToken() {
        return token;
    }

    public Date getTime() {
        return time;
    }

    // setters
    public void setId(String id) {
        this.id = id;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone;
    }

    public void setSendAddr(String sendAddr) {
        this.sendAddr = sendAddr;
    }

    public void setSendAddrInfo(String sendAddrInfo) {
        this.sendAddrInfo = sendAddrInfo;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }

    public void setReceiveAddrInfo(String receiveAddrInfo) {
        this.receiveAddrInfo = receiveAddrInfo;
    }

    public void setDispatchingType(String dispatchingType) {
        this.dispatchingType = dispatchingType;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public void setIsCompany(boolean isCompany) {
        this.isCompany = isCompany;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
