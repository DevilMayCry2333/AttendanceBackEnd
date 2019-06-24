package com.Attendence.My.Model.Entity.Attend;

import java.util.ArrayList;

public class Attend {
    private ArrayList<String> ID;
    private ArrayList<String> EmpCode;
    private ArrayList<String> EmpName;
    private ArrayList<String> EarlyTime;
    private ArrayList<String> LateTime;
    private ArrayList<String> AttendStatus;
    private ArrayList<String> ClassId;

    public ArrayList<String> getID() {
        return ID;
    }

    public void setID(ArrayList<String> ID) {
        this.ID = ID;
    }

    public ArrayList<String> getEmpCode() {
        return EmpCode;
    }

    public void setEmpCode(ArrayList<String> empCode) {
        EmpCode = empCode;
    }

    public ArrayList<String> getEmpName() {
        return EmpName;
    }

    public void setEmpName(ArrayList<String> empName) {
        EmpName = empName;
    }

    public ArrayList<String> getEarlyTime() {
        return EarlyTime;
    }

    public void setEarlyTime(ArrayList<String> earlyTime) {
        EarlyTime = earlyTime;
    }

    public ArrayList<String> getLateTime() {
        return LateTime;
    }

    public void setLateTime(ArrayList<String> lateTime) {
        LateTime = lateTime;
    }

    public ArrayList<String> getAttendStatus() {
        return AttendStatus;
    }

    public void setAttendStatus(ArrayList<String> attendStatus) {
        AttendStatus = attendStatus;
    }

    public ArrayList<String> getClassId() {
        return ClassId;
    }

    public void setClassId(ArrayList<String> classId) {
        ClassId = classId;
    }
}
