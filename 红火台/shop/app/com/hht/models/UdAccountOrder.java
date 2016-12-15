package com.hht.models;

public class UdAccountOrder {
    private String id;

    private String customernum;

    private String discountid;

    private String discountrate;

    private String allowanceamount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCustomernum() {
        return customernum;
    }

    public void setCustomernum(String customernum) {
        this.customernum = customernum == null ? null : customernum.trim();
    }

    public String getDiscountid() {
        return discountid;
    }

    public void setDiscountid(String discountid) {
        this.discountid = discountid == null ? null : discountid.trim();
    }

    public String getDiscountrate() {
        return discountrate;
    }

    public void setDiscountrate(String discountrate) {
        this.discountrate = discountrate == null ? null : discountrate.trim();
    }

    public String getAllowanceamount() {
        return allowanceamount;
    }

    public void setAllowanceamount(String allowanceamount) {
        this.allowanceamount = allowanceamount == null ? null : allowanceamount.trim();
    }
}