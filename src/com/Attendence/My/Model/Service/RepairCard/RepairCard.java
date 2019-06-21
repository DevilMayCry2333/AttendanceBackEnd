package com.Attendence.My.Model.Service.RepairCard;

import com.Attendence.My.Model.DAO.RepairCrad.RepairCrad;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairCard {
    public JSONArray RepairQuery() throws SQLException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        RepairCrad rc = new RepairCrad();

        ResultSet rs = rc.RepairQuery("repair");
        while (rs.next()){
            jsonObject.put("RepairId",rs.getString("RepairId"));
            jsonObject.put("Scode",rs.getString("Scode"));
            jsonObject.put("UserName",rs.getString("UserName"));
            jsonObject.put("RepairDate",rs.getString("RepairDate"));
            jsonObject.put("Reason",rs.getString("Reason"));
            jsonArray.add(jsonObject);

        }
        return jsonArray;
    }


}
