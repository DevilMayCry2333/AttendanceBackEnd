package com.Attendence.My.Model.Service.Login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public boolean loginquery(String username,String password) throws SQLException {
        com.Attendence.My.Model.DAO.Login.Login lg = new com.Attendence.My.Model.DAO.Login.Login();
        ResultSet rs = lg.query(username);
        if (rs.next()){
            String realpass = rs.getString("password");
            if(realpass.equals(password)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
