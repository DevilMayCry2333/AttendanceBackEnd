package com.Attendence.My.Model.DAO.PunchCard;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Utils.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PunchCard {
    public ResultSet PunchQuery(String sql){
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
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public int PunchUpdate(com.Attendence.My.Model.Entity.PunchCard.PunchCard punchModel){
        String sql = "UPDATE punch SET PunchId ='" + punchModel.getID() + "',Scode='" + punchModel.getSCode() + "',UserName='" + punchModel.getUserName() + "',PunchDate='" + punchModel.getPunchDate() + "',Remarks='" + punchModel.getRemarks() + "'WHERE Id = '" + punchModel.getID() + "'";
        System.out.println(sql);

        int line = 0;
        DBUtils cn = new DBUtils();
        Connection conn = cn.getConnecton();
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            line = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }

}