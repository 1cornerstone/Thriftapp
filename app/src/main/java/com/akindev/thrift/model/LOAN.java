package com.akindev.thrift.model;

import org.litepal.crud.LitePalSupport;

public class LOAN extends LitePalSupport {


    private String COLUMN_LOAN_UID;
    private String COLUMN_LOAN_UNAME;
    private String COLUMN_LOAN_AMOUNT;
    private String COLUMN_LOAN_DATE;
    private String COLUMN_LOAN_AMT;
    private String COLUMN_LOAN_AMT_PAYING;
    private String COLUMN_ASSEST;

    public String getCOLUMN_ASSEST() {
        return COLUMN_ASSEST;
    }

    public void setCOLUMN_ASSEST(String COLUMN_ASSEST) {
        this.COLUMN_ASSEST = COLUMN_ASSEST;
    }

    private String COLUMN_LOAN_PAID;

    public String getCOLUMN_LOAN_UID() {
        return COLUMN_LOAN_UID;
    }

    public void setCOLUMN_LOAN_UID(String COLUMN_LOAN_UID) {
        this.COLUMN_LOAN_UID = COLUMN_LOAN_UID;
    }

    public String getCOLUMN_LOAN_UNAME() {
        return COLUMN_LOAN_UNAME;
    }

    public void setCOLUMN_LOAN_UNAME(String COLUMN_LOAN_UNAME) {
        this.COLUMN_LOAN_UNAME = COLUMN_LOAN_UNAME;
    }

    public String getCOLUMN_LOAN_AMOUNT() {
        return COLUMN_LOAN_AMOUNT;
    }

    public void setCOLUMN_LOAN_AMOUNT(String COLUMN_LOAN_AMOUNT) {
        this.COLUMN_LOAN_AMOUNT = COLUMN_LOAN_AMOUNT;
    }


    public String getCOLUMN_LOAN_DATE() {
        return COLUMN_LOAN_DATE;
    }

    public void setCOLUMN_LOAN_DATE(String COLUMN_LOAN_DATE) {
        this.COLUMN_LOAN_DATE = COLUMN_LOAN_DATE;
    }

    public String getCOLUMN_LOAN_AMT() {
        return COLUMN_LOAN_AMT;
    }

    public void setCOLUMN_LOAN_AMT(String COLUMN_LOAN_AMT) {
        this.COLUMN_LOAN_AMT = COLUMN_LOAN_AMT;
    }

    public String getCOLUMN_LOAN_PAID() {
        return COLUMN_LOAN_PAID;
    }

    public void setCOLUMN_LOAN_PAID(String COLUMN_LOAN_PAID) {
        this.COLUMN_LOAN_PAID = COLUMN_LOAN_PAID;
    }

    public String getCOLUMN_LOAN_AMT_PAYING() {
        return COLUMN_LOAN_AMT_PAYING;
    }

    public void setCOLUMN_LOAN_AMT_PAYING(String COLUMN_LOAN_AMT_PAYING) {
        this.COLUMN_LOAN_AMT_PAYING = COLUMN_LOAN_AMT_PAYING;
    }

}
