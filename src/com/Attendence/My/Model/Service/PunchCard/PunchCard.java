package com.Attendence.My.Model.Service.PunchCard;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PunchCard {
    public JSONArray PunchQuery() throws SQLException {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        com.Attendence.My.Model.DAO.PunchCard.PunchCard pc = new com.Attendence.My.Model.DAO.PunchCard.PunchCard();
        ResultSet rs = pc.PunchQuery("select * from punch");
        while (rs.next()){
            json.put("PunchId",rs.getString("PunchId"));
            json.put("Scode",rs.getString("Scode"));
            json.put("UserName",rs.getString("UserName"));
            json.put("PunchDate",rs.getString("PunchDate"));
            json.put("Remarks",rs.getString("Remarks"));
            jsonArray.add(json);
        }
        return jsonArray;
    }
}
