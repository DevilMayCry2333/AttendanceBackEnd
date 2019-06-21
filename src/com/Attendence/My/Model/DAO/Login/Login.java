package com.Attendence.My.Model.DAO.Login;

import com.Attendence.My.Model.DBUtils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
    public ResultSet query(String username){
        String sql = "SELECT PassWord FROM tLogin " + "WHERE UserName='" + username + "'";
        DBUtils db = new DBUtils();
        ResultSet rs = null;
        Connection cn = db.getConnecton();
        try {
            Statement st = cn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
