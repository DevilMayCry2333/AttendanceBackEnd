package com.Attendence.My.Model.DAO.Login;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Utils.EncryBiz;

import java.sql.*;

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
        }finally {
            rs.close();
            st.close();
            cn.close();
        }
        return res;
    }
    public int updateLogin(String username,String inputPass){
        //1 - 登录成功
        //2 - 用户已在线
        //0 - 密码错误或者用户不存在
        DBUtils db = new DBUtils();
        Connection conn = db.getConnecton();
        try {
            PreparedStatement psmt = conn.prepareStatement("SELECT LoginCount FROM tLogin WHERE UserName = ?");
            psmt.setString(1,username);
            ResultSet rs = psmt.executeQuery();
            if(rs.next()){
                int loginCount = rs.getInt("LoginCount");
                if(loginCount == 1){
                    return 2;
                }else {
                    PreparedStatement login = conn.prepareStatement("SELECT PassWord FROM tLogin WHERE UserName = ?");
                    login.setString(1,username);
                    ResultSet rsL = login.executeQuery();
                    if(rsL.next()){
                        String md5str = rsL.getString("PassWord");
                        boolean real = EncryBiz.getSaltverifyMd5AndSha(inputPass,md5str);
                        if(real){
                            PreparedStatement update = conn.prepareStatement("UPDATE tLogin SET LoginCount = ? WHERE UserName = ?");
                            update.setInt(1,1);
                            update.setString(2,username);
                            update.executeUpdate();
                            return 1;
                        }else {
                            return 0;
                        }
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

    public boolean deleteLogin(String username){
        DBUtils db = new DBUtils();
        Connection conn = db.getConnecton();
        try {
            PreparedStatement psmt = conn.prepareStatement("UPDATE tLogin SET LoginCount = 0 WHERE UserName = ?");
            psmt.setString(1,username);
            int res = psmt.executeUpdate();
            if(res > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
