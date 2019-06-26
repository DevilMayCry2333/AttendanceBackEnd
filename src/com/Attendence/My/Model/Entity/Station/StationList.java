package com.Attendence.My.Model.Entity.Station;

public class StationList {
    private int Id;
    private String JobId;
    private String Pname;
    private String Adepartment;
    private String Isuperior;
    private String Jcategory;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getJobId() {
        return JobId;
    }

    public void setJobId(String jobId) {
        JobId = jobId;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getAdepartment() {
        return Adepartment;
    }

    public void setAdepartment(String adepartment) {
        Adepartment = adepartment;
    }

    public String getIsuperior() {
        return Isuperior;
    }

    public void setIsuperior(String isuperior) {
        Isuperior = isuperior;
    }

    public String getJcategory() {
        return Jcategory;
    }

    public void setJcategory(String jcategory) {
        Jcategory = jcategory;
    }
}
