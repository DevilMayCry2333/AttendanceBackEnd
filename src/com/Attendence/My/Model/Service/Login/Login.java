package com.Attendence.My.Model.Service.Login;

import com.Attendence.My.Model.Utils.EncryBiz;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public boolean loginquery(String username,String password) throws SQLException {
        com.Attendence.My.Model.DAO.Login.Login lg = new com.Attendence.My.Model.DAO.Login.Login();
        String realpass = lg.query(username);
            if(EncryBiz.getSaltverifyMd5AndSha(password, realpass)){
                return true;
            }else {
                return false;
            }
    }
}
