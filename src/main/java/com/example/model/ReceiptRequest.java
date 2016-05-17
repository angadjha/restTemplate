package com.example.model;

/**
 * Created by yongjunjung on 2016. 5. 13..
 */
public class ReceiptRequest {

    private String serviceId;
    private String serviceTradeNo;

    public ReceiptRequest(String serviceId, String serviceTradeNo) {
        this.serviceId = serviceId;
        this.serviceTradeNo = serviceTradeNo;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceTradeNo() {
        return serviceTradeNo;
    }

    public void setServiceTradeNo(String serviceTradeNo) {
        this.serviceTradeNo = serviceTradeNo;
    }

    @Override
    public String toString() {
        return "ReceiptRequest{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceTradeNo='" + serviceTradeNo + '\'' +
                '}';
    }
}
