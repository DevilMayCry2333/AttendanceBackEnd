package com.Attendence.My.Model.Entity.PunchCard;

public class PunchCardInsert {
    private String PunchId;
    private String ClassId;
    private String UserName;
    private String PunchDate;
    private String Remarks;
    private int Id;


    public String getPunchId() {
        return PunchId;
    }

    public void setPunchId(String punchId) {
        PunchId = punchId;
    }

    public String getClassId() {
        return ClassId;
    }

    public void setClassId(String classId) {
        ClassId = classId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPunchDate() {
        return PunchDate;
    }

    public void setPunchDate(String punchDate) {
        PunchDate = punchDate;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
