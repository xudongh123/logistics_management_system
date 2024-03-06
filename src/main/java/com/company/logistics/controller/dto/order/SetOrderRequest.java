package com.company.logistics.controller.dto.order;
import java.util.Date;
import java.util.List;

public class SetOrderRequest {

    private String sendName;
    private String sendPhone;
    private String sendAddr;
    private List<String> sendAddrEx;
    private String sendAddrInfo;
    private String receiveName;
    private String receivePhone;
    private String receiveAddr;
    private List<String> receiveAddrEx;
    private String receiveAddrInfo;
    private String dispatchingType;
    private Date sendTime;
    private Date receiveTime;
    private List<GoodsRequest> goods;
    private boolean isCompany;
    private String token;

    // getters and setters for SetOrderRequest class
    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getSendPhone() {
        return sendPhone;
    }

    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone;
    }

    public String getSendAddr() {
        return sendAddr;
    }

    public void setSendAddr(String sendAddr) {
        this.sendAddr = sendAddr;
    }

    public List<String> getSendAddrEx() {
        return sendAddrEx;
    }

    public void setSendAddrEx(List<String> sendAddrEx) {
        this.sendAddrEx = sendAddrEx;
    }

    public String getSendAddrInfo() {
        return sendAddrInfo;
    }

    public void setSendAddrInfo(String sendAddrInfo) {
        this.sendAddrInfo = sendAddrInfo;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveAddr() {
        return receiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }

    public List<String> getReceiveAddrEx() {
        return receiveAddrEx;
    }

    public void setReceiveAddrEx(List<String> receiveAddrEx) {
        this.receiveAddrEx = receiveAddrEx;
    }

    public String getReceiveAddrInfo() {
        return receiveAddrInfo;
    }

    public void setReceiveAddrInfo(String receiveAddrInfo) {
        this.receiveAddrInfo = receiveAddrInfo;
    }

    public String getDispatchingType() {
        return dispatchingType;
    }

    public void setDispatchingType(String dispatchingType) {
        this.dispatchingType = dispatchingType;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public List<GoodsRequest> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsRequest> goods) {
        this.goods = goods;
    }

    public boolean isCompany() {
        return isCompany;
    }

    public void setCompany(boolean company) {
        isCompany = company;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // getters and setters for inner class Goods
    public static class GoodsRequest {
        private String name;
        private String size;
        private int weight;
        private int number;
        private int freight;
        private String remark;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getFreight() {
            return freight;
        }

        public void setFreight(int freight) {
            this.freight = freight;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}


