package com.Attendence.My.Model.Entity.RepairCard;

import com.Attendence.My.Model.DAO.RepairCrad.RepairCrad;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairCard {
    public JSONObject RepairQuery() throws SQLException {
        JSONObject jsonObject = new JSONObject();
        RepairCrad rc = new RepairCrad();
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
