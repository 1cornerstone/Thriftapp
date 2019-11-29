package com.akindev.thrift.database;

import android.provider.BaseColumns;

public class ThriftUtil {


    public class CREATEUSER implements BaseColumns {

        public static final String TABLE_NAME = "Thriftman";
        public static final String COLUMN_uid = "_ID";
        public static final String COLUMN_THIFT_REGID = "regid";
        public static final String COLUMN_THIRFT_NAME = "name";
        public static final String COLUMN_THIFT_PHONE = "phone";
        public static final String COLUMN_THITFT_ADDRESS = "address";
        public static final String COLUMN_THRIFT_GENDER = "gender";
        public static final String COLUMN_THRIFT_OCCUP = "occup";
        public static final String COLUMN_THIRFT_STATE = "state";
        public static final String COLUMN_THIFT_DOB = "dateofbirth";
        public static final String COLUMN_THIFT_DOJ = "datejoined";
        public static final String COLUMN_THIFT_NOK = "nextofkin";
        public static final String COLUMN_THRIFT_AMOUNT = "amount";
        public static final String COLUMN_THRIFT_REASON = "reasontojoin";
        public static final String COLUMN_THRIFT_Q1 = "qusetion";
        public static final String COLUMN_THRIFT_IMAGEPATH = "imagepath";
        public static final String COLUMN_THRIFT_WITNAMME = "witnessname";
        public static final String COLUMN_THRIFT_WITREGID = "witnessid";
        public static final String COLUMN_THRIFT_COLLECTLOAN = "collectloan";


    }

    public class LOAN implements BaseColumns {

        public static final String TABLE_NAME = "thriftloan";
        public static final String COLUMN_LOAN_UID = "id";
        public static final String COLUMN_LOAN_UNAME = "name";
        public static final String COLUMN_LOAN_AMOUNT = "amount";
        public static final String COLUMN_LOAN_WIT = "witness";
        public static final String COLUMN_LOAN_DATE = "datecollected";
        public static final String COLUMN_LOAN_DATE_R = "datetorereturn";
        public static final String COLUMN_LOAN_AMT = "amounttoreturn";
        public static final String COLUMN_LOAN_PAID = "paid";

    }

    public class USER implements BaseColumns {


        public static final String TABLE_USER = "thriftuser";
        public static final String COLUMN_PASSOWRD = "password";

    }

}
