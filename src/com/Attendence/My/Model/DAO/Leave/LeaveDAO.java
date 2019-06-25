package com.Attendence.My.Model.DAO.Leave;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Leave.Leave;

import java.sql.*;
import java.util.ArrayList;

public class LeaveDAO {
    public ResultSet LeaveQuery() throws SQLException {
        String str="SELECT * from MyLeave";
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        ResultSet re = null;
        try {
            Statement st = con.createStatement();
            re = st.executeQuery(str);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return re;
    }
    public boolean InsertLeave(Leave leave) throws SQLException {
        String st="INSERT INTO myleave (LeaveId, LeaveName, BeginDate, EndDate, LeaveReason, Id) vaues(?,?,?,?,?,?) ";
        DBUtils db=new DBUtils();
        Connection conn=db.getConnecton();
        int c;
        PreparedStatement preparedStatement = conn.prepareStatement(st);
        preparedStatement.setString(1,leave.getLeaveId());
        preparedStatement.setString(2,leave.getLeaveName());
        preparedStatement.setString(3,leave.getBeginDate());
        preparedStatement.setString(4,leave.getEndDate());
        preparedStatement.setString(5,leave.getLeaveReason());
        preparedStatement.setString(6,"1");
        c = preparedStatement.executeUpdate();

        if(c==1){
            return  true;
        }
        else {
            return false;
        }
    }
}
