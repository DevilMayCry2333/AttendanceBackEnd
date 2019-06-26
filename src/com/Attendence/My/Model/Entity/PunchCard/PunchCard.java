package com.Attendence.My.Model.Entity.PunchCard;

public class PunchCard {
    private int ID;
    private String ClassId;
    private String PunchId;
    private String UserName;
    private String PunchDate;
    private String Remarks;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPunchId() {
        return PunchId;
    }

    public void setPunchId(String punchId) {
        PunchId = punchId;
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


    public String getClassId() {
        return ClassId;
    }

    public void setClassId(String classId) {
        ClassId = classId;
    }
}
