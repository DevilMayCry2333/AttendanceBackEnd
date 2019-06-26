package com.Attendence.My.Model.Entity.RepairCard;

import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairCard {
    private String RepairId;
    private String ClassId;
    private String UserName;
    private String RepairDate;
    private String Reason;
    private int Id;

    public String getRepairId() {
        return RepairId;
    }

    public void setRepairId(String repairId) {
        RepairId = repairId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getRepairDate() {
        return RepairDate;
    }

    public void setRepairDate(String repairDate) {
        RepairDate = repairDate;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getClassId() {
        return ClassId;
    }

    public void setClassId(String classId) {
        ClassId = classId;
    }
}
