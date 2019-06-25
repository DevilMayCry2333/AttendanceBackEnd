package com.Attendence.My.Model.Entity.Leave;

public class Leave {
    private String LeaveId;
    private String LeaveName;
    private String BeginDate;
    private String EndDate;
    private String LeaveReason;
    private int Id;


    public String getLeaveId() {
        return LeaveId;
    }

    public void setLeaveId(String leaveId) {
        LeaveId = leaveId;
    }

    public String getLeaveName() {
        return LeaveName;
    }

    public void setLeaveName(String leaveName) {
        LeaveName = leaveName;
    }

    public String getBeginDate() {
        return BeginDate;
    }

    public void setBeginDate(String beginDate) {
        BeginDate = beginDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getLeaveReason() {
        return LeaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        LeaveReason = leaveReason;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
