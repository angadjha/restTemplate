package com.example.model;

/**
 * Created by yongjunjung on 2016. 5. 13..
 */
public class ReceiptResponse {

    private String approve_no;
    private String card_nm;
    private String card_no;
    private String approve_datetime;
    private String cancel_datetime;
    private String amount;
    private String supply_amount;
    private String vat_amount;
    private String quota;
    private String trade_no;
    private String good_name;
    private String pg_biz_name;


    public String getApprove_no() {
        return approve_no;
    }

    public void setApprove_no(String approve_no) {
        this.approve_no = approve_no;
    }

    public String getCard_nm() {
        return card_nm;
    }

    public void setCard_nm(String card_nm) {
        this.card_nm = card_nm;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getApprove_datetime() {
        return approve_datetime;
    }

    public void setApprove_datetime(String approve_datetime) {
        this.approve_datetime = approve_datetime;
    }

    public String getCancel_datetime() {
        return cancel_datetime;
    }

    public void setCancel_datetime(String cancel_datetime) {
        this.cancel_datetime = cancel_datetime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSupply_amount() {
        return supply_amount;
    }

    public void setSupply_amount(String supply_amount) {
        this.supply_amount = supply_amount;
    }

    public String getVat_amount() {
        return vat_amount;
    }

    public void setVat_amount(String vat_amount) {
        this.vat_amount = vat_amount;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public String getPg_biz_name() {
        return pg_biz_name;
    }

    public void setPg_biz_name(String pg_biz_name) {
        this.pg_biz_name = pg_biz_name;
    }

    @Override
    public String toString() {
        return "ReceiptResponse{" +
                "approve_no='" + approve_no + '\'' +
                ", card_nm='" + card_nm + '\'' +
                ", card_no='" + card_no + '\'' +
                ", approve_datetime='" + approve_datetime + '\'' +
                ", cancel_datetime='" + cancel_datetime + '\'' +
                ", amount='" + amount + '\'' +
                ", supply_amount='" + supply_amount + '\'' +
                ", vat_amount='" + vat_amount + '\'' +
                ", quota='" + quota + '\'' +
                ", trade_no='" + trade_no + '\'' +
                ", good_name='" + good_name + '\'' +
                ", pg_biz_name='" + pg_biz_name + '\'' +
                '}';
    }
}
