package com.example.model;

/**
 * Created by yongjunjung on 2016. 5. 12..
 */
public class TossResponse {

    private String code;
    private String checkoutPage;
    private String payToken;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCheckoutPage() {
        return checkoutPage;
    }

    public void setCheckoutPage(String checkoutPage) {
        this.checkoutPage = checkoutPage;
    }

    public String getPayToken() {
        return payToken;
    }

    public void setPayToken(String payToken) {
        this.payToken = payToken;
    }

    @Override
    public String toString() {
        return "TossResponse{" +
                "code='" + code + '\'' +
                ", checkoutPage='" + checkoutPage + '\'' +
                ", payToken='" + payToken + '\'' +
                '}';
    }
}
