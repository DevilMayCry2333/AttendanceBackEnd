package com.Attendence.My.Model.Service.Login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public boolean loginquery(String username,String password) throws SQLException {
        com.Attendence.My.Model.DAO.Login.Login lg = new com.Attendence.My.Model.DAO.Login.Login();
        String realpass = lg.query(username);
            if(realpass.equals(password)){
                return true;
            }else {
                return false;
            }
    }
}
