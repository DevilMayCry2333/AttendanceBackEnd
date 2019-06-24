
package com.Attendence.My.Model.DAO.RepairCard;

import com.Attendence.My.Model.DBUtils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
