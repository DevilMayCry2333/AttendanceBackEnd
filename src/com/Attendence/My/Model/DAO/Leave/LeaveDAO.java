package com.Attendence.My.Model.DAO.Leave;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Leave.Leave;

import java.sql.*;
import java.util.ArrayList;

public class LeaveDAO {
    public ArrayList<Leave> LeaveQuery(int page) throws SQLException {
        String str="SELECT * from myleave LIMIT ?,? ";
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        ArrayList<Leave> leavArr = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet re = null;
        try {
            st = con.prepareStatement(str);
            st.setInt(1,page*10-10);
            st.setInt(2,10);
            re = st.executeQuery();
            while (re.next()){
                //                js.put("LeaveId",re1.getString("LeaveId"));
//                js.put("LeaveName",re1.getString("LeaveName"));
//                js.put("BeginDate",re1.getString("BeginDate"));
//                js.put("EndDate",re1.getString("EndDate"));
//                js.put("LeaveReason",re1.getString("LeaveReason"));
                Leave leave = new Leave();
                leave.setLeaveId(re.getString("LeaveId"));
                leave.setLeaveName(re.getString("LeaveName"));
                leave.setBeginDate(re.getString("BeginDate"));
                leave.setEndDate(re.getString("EndDate"));
                leave.setLeaveReason(re.getString("LeaveReason"));
                leavArr.add(leave);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            re.close();
            st.close();
            con.close();
        }
        return leavArr;
    }
    public boolean InsertLeave(Leave leave) throws SQLException {
        String st="INSERT INTO myleave (LeaveId, LeaveName, BeginDate, EndDate, LeaveReason, Id) VALUES (?,?,?,?,?,?) ";
        DBUtils db=new DBUtils();
        Connection conn=db.getConnecton();
        int c;
        PreparedStatement preparedStatement = conn.prepareStatement(st);
        preparedStatement.setString(1,leave.getLeaveId());
        preparedStatement.setString(2,leave.getLeaveName());
        preparedStatement.setString(3,leave.getBeginDate());
        preparedStatement.setString(4,leave.getEndDate());
        preparedStatement.setString(5,leave.getLeaveReason());
        preparedStatement.setString(6, String.valueOf(leave.getId()));

        c = preparedStatement.executeUpdate();
        preparedStatement.close();
        conn.close();
        if(c==1){
            return  true;
        }
        else {
            return false;
        }
    }
    public ArrayList<Leave> Query() throws SQLException {
        String str = "SELECT * from MyLeave";
        DBUtils dbUtils = new DBUtils();
        Connection con = dbUtils.getConnecton();
        ArrayList<Leave> leavArr = new ArrayList<>();
        Statement st = null;
        ResultSet re = null;
        try {
            st = con.createStatement();
            re = st.executeQuery(str);
            while (re.next()) {
                //                js.put("LeaveId",re1.getString("LeaveId"));
//                js.put("LeaveName",re1.getString("LeaveName"));
//                js.put("BeginDate",re1.getString("BeginDate"));
//                js.put("EndDate",re1.getString("EndDate"));
//                js.put("LeaveReason",re1.getString("LeaveReason"));
                Leave leave = new Leave();
                leave.setLeaveId(re.getString("LeaveId"));
                leave.setLeaveName(re.getString("LeaveName"));
                leave.setBeginDate(re.getString("BeginDate"));
                leave.setEndDate(re.getString("EndDate"));
                leave.setLeaveReason(re.getString("LeaveReason"));
                leavArr.add(leave);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            re.close();
            st.close();
            con.close();
        }
        return leavArr;
    }
    public int queryLines(){
        DBUtils db = new DBUtils();
        Connection conn = db.getConnecton();
        int res = 0;
        ResultSet rs = null;
        try {
            PreparedStatement psmt = conn.prepareStatement("SELECT count(Id) LeaveCount FROM myleave");
            rs = psmt.executeQuery();
            if(rs.next()){
                res = rs.getInt("LeaveCount");
                System.out.println(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
