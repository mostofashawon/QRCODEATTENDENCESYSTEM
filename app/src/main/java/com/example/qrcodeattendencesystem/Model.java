package com.example.qrcodeattendencesystem;

public class Model {


    private String date,id,Intime,Outtime,OverTime;

    public Model(){

    }

    public Model(String date, String id, String intime, String outtime, String overTime) {
        this.date = date;
        this.id = id;
        Intime = intime;
        Outtime = outtime;
        OverTime = overTime;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntime() {
        return Intime;
    }

    public void setIntime(String intime) {
        Intime = intime;
    }

    public String getOuttime() {
        return Outtime;
    }

    public void setOuttime(String outtime) {
        Outtime = outtime;
    }

    public String getOverTime() {
        return OverTime;
    }

    public void setOverTime(String overTime) {
        OverTime = overTime;
    }
}
