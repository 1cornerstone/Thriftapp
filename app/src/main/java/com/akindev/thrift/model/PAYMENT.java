package com.akindev.thrift.model;

import org.litepal.crud.LitePalSupport;

public class PAYMENT extends LitePalSupport {

    private  String COLUMN_ID;
    private String COLUMN_DATE;
    private String COLUMN_AMOUNT;

    public String getCOLUMN_ID() {
        return COLUMN_ID;
    }

    public void setCOLUMN_ID(String COLUMN_ID) {
        this.COLUMN_ID = COLUMN_ID;
    }

    public String getCOLUMN_DATE() {
        return COLUMN_DATE;
    }

    public void setCOLUMN_DATE(String COLUMN_DATE) {
        this.COLUMN_DATE = COLUMN_DATE;
    }

    public String getCOLUMN_AMOUNT() {
        return COLUMN_AMOUNT;
    }

    public void setCOLUMN_AMOUNT(String COLUMN_AMOUNT) {
        this.COLUMN_AMOUNT = COLUMN_AMOUNT;
    }
}
