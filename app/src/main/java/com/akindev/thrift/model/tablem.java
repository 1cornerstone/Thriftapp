package com.akindev.thrift.model;

public class tablem {


    private String date;
    private String amount;

    public tablem(String date, String amount) {
        this.date = date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getAmount() {
        return amount;
    }
}
