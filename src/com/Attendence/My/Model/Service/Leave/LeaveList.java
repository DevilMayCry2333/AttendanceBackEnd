package com.Attendence.My.Model.Service.Leave;

import com.Attendence.My.Model.DAO.Leave.LeaveDAO;
import com.Attendence.My.Model.Entity.Leave.Leave;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeaveList {
    public ArrayList<Leave> LeaveList(int page) throws SQLException {
        LeaveDAO leave = new LeaveDAO();
        return leave.LeaveQuery(page);

    }
    public boolean LeaveInsert(Leave leaveModel) throws SQLException {
        LeaveDAO leaveDAO = new LeaveDAO();
        boolean le = leaveDAO.InsertLeave(leaveModel);
        if(le){
            return  true;
        }
        else
            return false;
    }
    public ArrayList<Leave> Query() throws SQLException {
        LeaveDAO leave = new LeaveDAO();
        return leave.Query();
    }
    public int QueryAll(){
       LeaveDAO leaveDAO = new LeaveDAO();
        return leaveDAO.queryLines();
    }
}
