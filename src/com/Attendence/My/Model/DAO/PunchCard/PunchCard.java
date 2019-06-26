package com.Attendence.My.Model.DAO.PunchCard;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.PunchCard.PunchCardInsert;
import com.Attendence.My.Model.Utils.Connect;

import java.sql.*;
import java.util.ArrayList;

public class PunchCard {
    public ArrayList<com.Attendence.My.Model.Entity.PunchCard.PunchCard> PunchQuery(String sql) throws SQLException {
        DBUtils cn = new DBUtils();
        Connection conn = cn.getConnecton();
        ArrayList<com.Attendence.My.Model.Entity.PunchCard.PunchCard> punchArr = new ArrayList<>();

        ResultSet rs = null;
        Statement st = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                com.Attendence.My.Model.Entity.PunchCard.PunchCard punch = new com.Attendence.My.Model.Entity.PunchCard.PunchCard();
                punch.setID(rs.getInt("Id"));
                punch.setClassId(rs.getString("ClassId"));
                punch.setUserName(rs.getString("UserName"));
                punch.setPunchDate(rs.getString("PunchDate"));
                punch.setRemarks(rs.getString("Remarks"));
                punch.setPunchId(rs.getString("PunchId"));
                punchArr.add(punch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rs.close();
            st.close();
            conn.close();
        }
        return punchArr;
    }
    public int PunchUpdate(com.Attendence.My.Model.Entity.PunchCard.PunchCard punchModel){
        String sql = "UPDATE punch SET PunchId ='" + punchModel.getID() + "',ClassId='" + punchModel.getClassId() + "',UserName='" + punchModel.getUserName() + "',PunchDate='" + punchModel.getPunchDate() + "',Remarks='" + punchModel.getRemarks() + "'WHERE Id = '" + punchModel.getID() + "'";
        System.out.println(sql);

        int line = 0;
        DBUtils cn = new DBUtils();
        Connection conn = cn.getConnecton();
        Statement st = null;
        try {
            st = conn.createStatement();
            line = st.executeUpdate(sql);
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }
        public boolean PunchCardInsert(PunchCardInsert punchCardmModel) throws SQLException{
            DBUtils dbUtils = new DBUtils();
            Connection connection = dbUtils.getConnecton();
            String sql = "insert into  punch(PunchId, ClassID, UserName, PunchDate, Remarks) value  (?,?,?,?,?)";//sql语句
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,punchCardmModel.getPunchId());
            preparedStatement.setString(2,punchCardmModel.getClassId());
            preparedStatement.setString(3,punchCardmModel.getUserName());
            preparedStatement.setString(4,punchCardmModel.getPunchDate());
            preparedStatement.setString(5,punchCardmModel.getRemarks());
           // 班次，查询

        int c =preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        if(c == 1){
            return true;
        }
        else
            return false;
        }
}