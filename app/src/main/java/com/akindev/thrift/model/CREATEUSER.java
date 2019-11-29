package com.akindev.thrift.model;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class CREATEUSER extends LitePalSupport {



    private String COLUMN_THIFT_REGID ;
    private String COLUMN_THIRFT_NAME;
    private String COLUMN_THIFT_PHONE;
    private String COLUMN_THITFT_ADDRESS;
    private String COLUMN_THRIFT_GENDER;
    private String COLUMN_THRIFT_OCCUP;
    private String COLUMN_THIRFT_STATE;
    private String COLUMN_THIFT_DOB;
    private String COLUMN_THIFT_DOJ;
    private String COLUMN_THIFT_NOK;
    private String COLUMN_THRIFT_AMOUNT;
    private String COLUMN_THRIFT_REASON;
    private String COLUMN_THRIFT_Q1;
    private String COLUMN_THRIFT_WITNAMME;
    private String COLUMN_THRIFT_WITREGID;

    @Column(defaultValue = "0")
    private String COLUMN_THRIFT_IMAGEPATH;

    @Column( defaultValue = "0")
    private String COLUMN_THRIFT_COLLECTLOAN;



    public String getCOLUMN_THIFT_REGID() {
        return COLUMN_THIFT_REGID;
    }

    public void setCOLUMN_THIFT_REGID(String COLUMN_THIFT_REGID) {
        this.COLUMN_THIFT_REGID = COLUMN_THIFT_REGID;
    }

    public String getCOLUMN_THIRFT_NAME() {
        return COLUMN_THIRFT_NAME;
    }

    public void setCOLUMN_THIRFT_NAME(String COLUMN_THIRFT_NAME) {
        this.COLUMN_THIRFT_NAME = COLUMN_THIRFT_NAME;
    }

    public String getCOLUMN_THIFT_PHONE() {
        return COLUMN_THIFT_PHONE;
    }

    public void setCOLUMN_THIFT_PHONE(String COLUMN_THIFT_PHONE) {
        this.COLUMN_THIFT_PHONE = COLUMN_THIFT_PHONE;
    }

    public String getCOLUMN_THITFT_ADDRESS() {
        return COLUMN_THITFT_ADDRESS;
    }

    public void setCOLUMN_THITFT_ADDRESS(String COLUMN_THITFT_ADDRESS) {
        this.COLUMN_THITFT_ADDRESS = COLUMN_THITFT_ADDRESS;
    }

    public String getCOLUMN_THRIFT_GENDER() {
        return COLUMN_THRIFT_GENDER;
    }

    public void setCOLUMN_THRIFT_GENDER(String COLUMN_THRIFT_GENDER) {
        this.COLUMN_THRIFT_GENDER = COLUMN_THRIFT_GENDER;
    }

    public String getCOLUMN_THRIFT_OCCUP() {
        return COLUMN_THRIFT_OCCUP;
    }

    public void setCOLUMN_THRIFT_OCCUP(String COLUMN_THRIFT_OCCUP) {
        this.COLUMN_THRIFT_OCCUP = COLUMN_THRIFT_OCCUP;
    }

    public String getCOLUMN_THIRFT_STATE() {
        return COLUMN_THIRFT_STATE;
    }

    public void setCOLUMN_THIRFT_STATE(String COLUMN_THIRFT_STATE) {
        this.COLUMN_THIRFT_STATE = COLUMN_THIRFT_STATE;
    }

    public String getCOLUMN_THIFT_DOB() {
        return COLUMN_THIFT_DOB;
    }

    public void setCOLUMN_THIFT_DOB(String COLUMN_THIFT_DOB) {
        this.COLUMN_THIFT_DOB = COLUMN_THIFT_DOB;
    }

    public String getCOLUMN_THIFT_DOJ() {
        return COLUMN_THIFT_DOJ;
    }

    public void setCOLUMN_THIFT_DOJ(String COLUMN_THIFT_DOJ) {
        this.COLUMN_THIFT_DOJ = COLUMN_THIFT_DOJ;
    }

    public String getCOLUMN_THIFT_NOK() {
        return COLUMN_THIFT_NOK;
    }

    public void setCOLUMN_THIFT_NOK(String COLUMN_THIFT_NOK) {
        this.COLUMN_THIFT_NOK = COLUMN_THIFT_NOK;
    }

    public String getCOLUMN_THRIFT_AMOUNT() {
        return COLUMN_THRIFT_AMOUNT;
    }

    public void setCOLUMN_THRIFT_AMOUNT(String COLUMN_THRIFT_AMOUNT) {
        this.COLUMN_THRIFT_AMOUNT = COLUMN_THRIFT_AMOUNT;
    }

    public String getCOLUMN_THRIFT_REASON() {
        return COLUMN_THRIFT_REASON;
    }

    public void setCOLUMN_THRIFT_REASON(String COLUMN_THRIFT_REASON) {
        this.COLUMN_THRIFT_REASON = COLUMN_THRIFT_REASON;
    }

    public String getCOLUMN_THRIFT_Q1() {
        return COLUMN_THRIFT_Q1;
    }

    public void setCOLUMN_THRIFT_Q1(String COLUMN_THRIFT_Q1) {
        this.COLUMN_THRIFT_Q1 = COLUMN_THRIFT_Q1;
    }

    public String getCOLUMN_THRIFT_IMAGEPATH() {
        return COLUMN_THRIFT_IMAGEPATH;
    }

    public void setCOLUMN_THRIFT_IMAGEPATH(String COLUMN_THRIFT_IMAGEPATH) {
        this.COLUMN_THRIFT_IMAGEPATH = COLUMN_THRIFT_IMAGEPATH;
    }

    public String getCOLUMN_THRIFT_WITNAMME() {
        return COLUMN_THRIFT_WITNAMME;
    }

    public void setCOLUMN_THRIFT_WITNAMME(String COLUMN_THRIFT_WITNAMME) {
        this.COLUMN_THRIFT_WITNAMME = COLUMN_THRIFT_WITNAMME;
    }

    public String getCOLUMN_THRIFT_WITREGID() {
        return COLUMN_THRIFT_WITREGID;
    }

    public void setCOLUMN_THRIFT_WITREGID(String COLUMN_THRIFT_WITREGID) {
        this.COLUMN_THRIFT_WITREGID = COLUMN_THRIFT_WITREGID;
    }

    public String getCOLUMN_THRIFT_COLLECTLOAN() {
        return COLUMN_THRIFT_COLLECTLOAN;
    }

    public void setCOLUMN_THRIFT_COLLECTLOAN(String COLUMN_THRIFT_COLLECTLOAN) {
        this.COLUMN_THRIFT_COLLECTLOAN = COLUMN_THRIFT_COLLECTLOAN;
    }
}
