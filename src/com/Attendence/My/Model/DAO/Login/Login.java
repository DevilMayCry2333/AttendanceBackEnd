package com.Attendence.My.Model.DAO.Login;

import com.Attendence.My.Model.DBUtils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
    public String query(String username) throws SQLException {
        String sql = "SELECT PassWord FROM tLogin " + "WHERE UserName='" + username + "'";
        DBUtils db = new DBUtils();
        ResultSet rs = null;
        Connection cn = db.getConnecton();
        String res = null;
        Statement st = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()){
                System.out.println("执行这里");
                res = rs.getString("password");
            }else {
                System.out.println("执行else");
                res = "用户不存在";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rs.close();
            st.close();
            cn.close();
        }
        return res;
    }
}
