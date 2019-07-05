package com.Attendence.My.Model.DAO.Login;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Login.LoginState;
import com.Attendence.My.Model.Utils.EncryBiz;

import java.sql.*;

public class Login {
    public int updateLogin(String username,String inputPass){
        //1 - 登录成功
        //2 - 用户已在线
        //0 - 密码错误或者用户不存在
        DBUtils db = new DBUtils();
        Connection conn = db.getConnecton();
        PreparedStatement psmt = null;
        PreparedStatement login = null;
        PreparedStatement update = null;
        ResultSet rs = null;
        ResultSet rsL = null;
        try {
            psmt = conn.prepareStatement("SELECT LoginCount FROM tLogin WHERE UserName = ?");
            psmt.setString(1,username);
            rs = psmt.executeQuery();
            if(rs.next()){
                int loginCount = rs.getInt("LoginCount");
//                if(loginCount == 1){
//                    return 2;
//                }else {
                    login = conn.prepareStatement("SELECT PassWord FROM tLogin WHERE UserName = ?");
                    login.setString(1,username);
                    rsL = login.executeQuery();
                    if(rsL.next()){
                        String md5str = rsL.getString("PassWord");
                        boolean real = EncryBiz.getSaltverifyMd5AndSha(inputPass,md5str);
                        if(real){
                            update = conn.prepareStatement("UPDATE tLogin SET LoginCount = ? WHERE UserName = ?");
                            update.setInt(1,1);
                            update.setString(2,username);
                            update.executeUpdate();
                            return 1;
                        }else {
                            return 0;
                        }
                    }
//                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rsL.close();
                rs.close();
                update.close();
                login.close();
                psmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return -1;

    }

    public boolean deleteLogin(String username){
        DBUtils db = new DBUtils();
        Connection conn = db.getConnecton();
        PreparedStatement psmt = null;
        try {
            psmt = conn.prepareStatement("UPDATE tLogin SET LoginCount = 0 WHERE UserName = ?");
            psmt.setString(1,username);
            int res = psmt.executeUpdate();
            if(res > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                psmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
    public LoginState checkLogin(String username){
        DBUtils db = new DBUtils();
        Connection conn = db.getConnecton();
        LoginState ls = new LoginState();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            psmt = conn.prepareStatement("SELECT LoginCount FROM tLogin WHERE UserName = ?");
            psmt.setString(1,username);
            rs = psmt.executeQuery();
            if(rs.next()){
                if(rs.getInt("LoginCount")==1){
                    ls.setLoginState(true);
                }else {
                    ls.setLoginState(false);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                psmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return ls;
    }
}
