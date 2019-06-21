package com.Attendence.My.Model.DAO.RepairCrad;


import com.Attendence.My.Model.DBUtils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepairCrad {
    public ResultSet RepairQuery (String tablename){
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
            String sql = "SELECT * FROM " + tablename;
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  rs;

    }
}
