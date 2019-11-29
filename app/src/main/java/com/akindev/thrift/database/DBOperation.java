package com.akindev.thrift.database;

public class DBOperation {



    String query ="";

    void createUsertable(){


        query = "CREATE TABLE "+ ThriftUtil.CREATEUSER.TABLE_NAME
                +" ("+ ThriftUtil.CREATEUSER.COLUMN_uid +" INTEGER PRIMARY KEY, "+
                ThriftUtil.CREATEUSER.COLUMN_THIFT_REGID +" TEXT,"+ ThriftUtil.CREATEUSER.COLUMN_THIRFT_NAME
                +" TEXT,"+ ThriftUtil.CREATEUSER.COLUMN_THIFT_PHONE +" TEXT,"+ ThriftUtil.CREATEUSER.COLUMN_THITFT_ADDRESS +")";
    }
}
