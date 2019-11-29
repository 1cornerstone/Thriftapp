package com.akindev.thrift.model;

public class memberview {

    private String regID="";
    private String gender="";

    public memberview(String regID, String gender) {
        this.regID = regID;
        this.gender = gender;
    }

    public String getRegID() {
        return regID;
    }

    public void setRegID(String regID) {
        this.regID = regID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
