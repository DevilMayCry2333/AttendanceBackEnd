package com.Attendence.My.Model.Service.Leave;

import com.Attendence.My.Model.DAO.Leave.LeaveDAO;
import com.Attendence.My.Model.Entity.Leave.Leave;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaveList {
    public JSONArray LeaveList(){
        JSONObject js= new JSONObject( );
        JSONArray Json=new JSONArray();
        LeaveDAO leave = new LeaveDAO();
        ResultSet re1= null;
        try {
            re1 = leave.LeaveQuery();
            while (re1.next()){
                js.put("LeaveId",re1.getString("LeaveId"));
                js.put("LeaveName",re1.getString("LeaveName"));
                js.put("BeginDate",re1.getString("BeginDate"));
                js.put("EndDate",re1.getString("EndDate"));
                js.put("LeaveReason",re1.getString("LeaveReason"));
                Json.add(js);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Json;
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
}
