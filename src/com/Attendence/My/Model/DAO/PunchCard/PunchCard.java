package com.Attendence.My.Model.DAO.PunchCard;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.PunchCard.PunchCardInsert;
import com.Attendence.My.Model.Utils.Connect;

import java.sql.*;

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
        public boolean PunchCardInsert(PunchCardInsert punchCardmModel) throws SQLException{
            DBUtils dbUtils = new DBUtils();
            Connection connection = dbUtils.getConnecton();
            String sql = "insert into  punch(PunchId, ClassID, UserName, PunchDate, Remarks, Id) value  (?,?,?,?,?,?)";//sql语句
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,punchCardmModel.getPunchId());
            preparedStatement.setString(2,punchCardmModel.getClassId());
            preparedStatement.setString(3,punchCardmModel.getUserName());
            preparedStatement.setString(4,punchCardmModel.getPunchDate());
            preparedStatement.setString(5,punchCardmModel.getRemarks());
           // 班次，查询
            preparedStatement.setString(6,"1");

        int c =preparedStatement.executeUpdate();
        if(c == 1){
            return true;
        }
        else
            return false;
        }
}