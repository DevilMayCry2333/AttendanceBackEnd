package com.Attendence.My.Model.Service.Login;

import com.Attendence.My.Model.Entity.Login.LoginState;
import com.Attendence.My.Model.Utils.EncryBiz;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public String loginquery(String username,String password) throws SQLException {
        com.Attendence.My.Model.DAO.Login.Login lg = new com.Attendence.My.Model.DAO.Login.Login();
        int realpass = lg.updateLogin(username, password);
        switch (realpass){
            case 0:
                return "密码错误或者用户不存在";
            case 1:
                return "登录成功";
            case 2:
                return "用户已登录";
            default:
                return "default";
        }
    }
    public boolean deletLogin(String username){
        com.Attendence.My.Model.DAO.Login.Login lg = new com.Attendence.My.Model.DAO.Login.Login();
        return lg.deleteLogin(username);
    }
    public LoginState loginState(String username){
        com.Attendence.My.Model.DAO.Login.Login lg = new com.Attendence.My.Model.DAO.Login.Login();
        return lg.checkLogin(username);
    }
}
