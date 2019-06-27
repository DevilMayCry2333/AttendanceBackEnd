
package com.Attendence.My.Model.DAO.RepairCard;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.RepairCard.RepairInsert;

import java.sql.*;
import java.util.ArrayList;

public class RepairCard {
    public ArrayList<com.Attendence.My.Model.Entity.RepairCard.RepairCard> RepairQuery (String sql) throws SQLException {

        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        Statement st = null;
        ResultSet rs = null;
        ArrayList<com.Attendence.My.Model.Entity.RepairCard.RepairCard> repairArr = new ArrayList<>();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                //            jsonObject.put("RepairId",rs.getString("RepairId"));
//            jsonObject.put("ClassId",rs.getString("ClassId"));
//            jsonObject.put("UserName",rs.getString("UserName"));
//            jsonObject.put("RepairDate",rs.getString("RepairDate"));
//            jsonObject.put("Reason",rs.getString("Reason"));
//            jsonArray.add(jsonObject);
                com.Attendence.My.Model.Entity.RepairCard.RepairCard repair = new com.Attendence.My.Model.Entity.RepairCard.RepairCard();
                repair.setId(rs.getInt("Id"));
                repair.setClassId(rs.getString("ClassId"));
                repair.setUserName(rs.getString("UserName"));
                repair.setRepairDate(rs.getString("RepairDate"));
                repair.setReason(rs.getString("Reason"));
                repair.setRepairId(rs.getString("RepairId"));
                repairArr.add(repair);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rs.close();
            st.close();
            con.close();
        }
        return repairArr;
    }

    public int RepairUpdate(com.Attendence.My.Model.Entity.RepairCard.RepairCard repairModel){
        String sql = "UPDATE repair SET RepairId ='" + repairModel.getRepairId() + "',Scode='" + repairModel.getClassId() + "',UserName='" + repairModel.getUserName() + "',Reason='" + repairModel.getReason() + "',RepairDate='" + repairModel.getRepairDate() + "',Id = '" + repairModel.getId() + "'WHERE Id = '" + repairModel.getId()+ "'";
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

    public boolean RepairCardInsert (RepairInsert repairModel) throws SQLException {
        DBUtils dbUtils = new DBUtils();
        Connection connection = dbUtils.getConnecton();
        String sql = "insert into repair(RepairId, ClassId, UserName, RepairDate, Reason) VALUES (?,?,?,?,?)";//sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,repairModel.getRepairId());
        preparedStatement.setString(2,repairModel.getClassID());
        preparedStatement.setString(3,repairModel.getUserName());
        preparedStatement.setString(4,repairModel.getRepairDate());
        preparedStatement.setString(5,repairModel.getReason());
        // 班次，查询

        int c = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        if(c==1){
            return true;
        }
        else
            return  false;
    }
    public ArrayList<com.Attendence.My.Model.Entity.RepairCard.RepairCard> Query (String sql) throws SQLException {

        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        Statement st = null;
        ResultSet rs = null;
        ArrayList<com.Attendence.My.Model.Entity.RepairCard.RepairCard> repairArr = new ArrayList<>();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                //            jsonObject.put("RepairId",rs.getString("RepairId"));
//            jsonObject.put("ClassId",rs.getString("ClassId"));
//            jsonObject.put("UserName",rs.getString("UserName"));
//            jsonObject.put("RepairDate",rs.getString("RepairDate"));
//            jsonObject.put("Reason",rs.getString("Reason"));
//            jsonArray.add(jsonObject);
                com.Attendence.My.Model.Entity.RepairCard.RepairCard repair = new com.Attendence.My.Model.Entity.RepairCard.RepairCard();
                repair.setId(rs.getInt("Id"));
                repair.setClassId(rs.getString("ClassId"));
                repair.setUserName(rs.getString("UserName"));
                repair.setRepairDate(rs.getString("RepairDate"));
                repair.setReason(rs.getString("Reason"));
                repair.setRepairId(rs.getString("RepairId"));
                repairArr.add(repair);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rs.close();
            st.close();
            con.close();
        }
        return repairArr;
    }

}
