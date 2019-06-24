package com.Attendence.My.Model.Entity.RepairCard;

import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairCard {
    public JSONObject RepairQuery() throws SQLException {
        JSONObject jsonObject = new JSONObject();
        com.Attendence.My.Model.DAO.RepairCard.RepairCard rc = new com.Attendence.My.Model.DAO.RepairCard.RepairCard();
        ResultSet rs = rc.RepairQuery("");
        while (rs.next()){
            jsonObject.put("RepairId",rs.getString("RepairId"));
            jsonObject.put("Scode",rs.getString("Scode"));
            jsonObject.put("UserName",rs.getString("UserName"));
            jsonObject.put("RepairDate",rs.getDate("RepairDate"));
            jsonObject.put("Reason",rs.getString("Reason"));
        }
        return jsonObject;
    }


}
