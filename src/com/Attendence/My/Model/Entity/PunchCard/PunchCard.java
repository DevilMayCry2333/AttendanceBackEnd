package com.Attendence.My.Model.Entity.PunchCard;

public class PunchCard {
    private int ID;
    private String SCode;
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

    public String getSCode() {
        return SCode;
    }

    public void setSCode(String SCode) {
        this.SCode = SCode;
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


}
