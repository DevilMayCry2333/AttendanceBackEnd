
package com.Attendence.My.Model.DAO.RepairCard;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.RepairCard.RepairInsert;

import java.sql.*;

public class RepairCard {
    public ResultSet RepairQuery (String sql){

        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  rs;
    }

    public int RepairUpdate(com.Attendence.My.Model.Entity.RepairCard.RepairCard repairModel){
        String sql = "UPDATE repair SET RepairId ='" + repairModel.getRepairId() + "',Scode='" + repairModel.getSCode() + "',UserName='" + repairModel.getUserName() + "',Reason='" + repairModel.getReason() + "',RepairDate='" + repairModel.getRepairDate() + "',Id = '" + repairModel.getId() + "'WHERE Id = '" + repairModel.getId()+ "'";
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

    public boolean RepairCardInsert (RepairInsert repairModel) throws SQLException {
        DBUtils dbUtils = new DBUtils();
        Connection connection = dbUtils.getConnecton();
        String sql = "insert into repair(RepairId, ClassID, UserName, PunchDate, Remarks, Id) value  (?,?,?,?,?,?)";//sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,repairModel.getRepairId());
        preparedStatement.setString(2,repairModel.getClassID());
        preparedStatement.setString(3,repairModel.getUserName());
        preparedStatement.setString(4,repairModel.getRepairDate());
        preparedStatement.setString(5,repairModel.getReason());
        // 班次，查询
        preparedStatement.setString(6,"1");

        int c = preparedStatement.executeUpdate();
        if(c==1){
            return true;
        }
        else
            return  false;
    }

}
