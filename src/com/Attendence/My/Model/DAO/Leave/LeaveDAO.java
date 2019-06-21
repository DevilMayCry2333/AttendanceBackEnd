package com.Attendence.My.Model.DAO.Leave;

import com.Attendence.My.Model.DBUtils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public boolean InsertLeave(ArrayList<String> al){
        String st="INSERT INTO Leave vaues(?,?,?,?,?) ";
        DBUtils db=new DBUtils();
        Connection conn=db.getConnecton();
        boolean c = false;
        try {
            Statement stt=conn.createStatement();
            c=stt.execute(st);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(c==true){
            return  true;
        }
        else {
            return false;
        }
    }
}
