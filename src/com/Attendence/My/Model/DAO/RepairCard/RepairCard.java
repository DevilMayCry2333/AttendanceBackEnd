
package com.Attendence.My.Model.DAO.RepairCard;

import com.Attendence.My.Model.DBUtils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepairCard {
    public ResultSet RepairQuery (String sql){

        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  rs;

    }
}
