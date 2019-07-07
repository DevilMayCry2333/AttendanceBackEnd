package com.Attendence.My.Model.Service.Leave;

import com.Attendence.My.Model.DAO.Leave.LeaveDAO;
import com.Attendence.My.Model.Entity.Leave.Leave;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeaveList {
    //查询请假单表的所有记录，传入page的值，调用LeaveQuery方法并返回结果
    public ArrayList<Leave> LeaveList(int page) throws SQLException {
        LeaveDAO leave = new LeaveDAO();
        return leave.LeaveQuery(page);

    }
    //添加 leaveModel记录到请假单
    public boolean LeaveInsert(Leave leaveModel) throws SQLException {
        LeaveDAO leaveDAO = new LeaveDAO();
        boolean le = leaveDAO.InsertLeave(leaveModel);
        if(le){
            return  true;
        }
        else
            return false;
    }
    //查询记录
    public ArrayList<Leave> Query() throws SQLException {
        LeaveDAO leave = new LeaveDAO();
        return leave.Query();
    }
    //查询记录
    public int QueryAll(){
       LeaveDAO leaveDAO = new LeaveDAO();
        return leaveDAO.queryLines();
    }
}
