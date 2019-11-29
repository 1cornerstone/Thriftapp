package com.akindev.thrift.model;

import org.litepal.crud.LitePalSupport;

public class ADMIN extends LitePalSupport {

    private String TABLE_USER;
    private String COLUMN_PASSOWRD ;


    public String getTABLE_USER() {
        return TABLE_USER;
    }

    public void setTABLE_USER(String TABLE_USER) {
        this.TABLE_USER = TABLE_USER;
    }

    public String getCOLUMN_PASSOWRD() {
        return COLUMN_PASSOWRD;
    }

    public void setCOLUMN_PASSOWRD(String COLUMN_PASSOWRD) {
        this.COLUMN_PASSOWRD = COLUMN_PASSOWRD;
    }
}
