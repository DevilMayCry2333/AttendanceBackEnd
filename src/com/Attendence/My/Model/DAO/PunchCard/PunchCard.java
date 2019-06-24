package com.Attendence.My.Model.DAO.PunchCard;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Utils.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PunchCard {
    public ResultSet PunchQuery(String sql){
        DBUtils cn = new DBUtils();
        Connection conn = cn.getConnecton();
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }
}