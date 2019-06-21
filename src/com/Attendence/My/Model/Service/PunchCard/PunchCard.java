package com.Attendence.My.Model.Service.PunchCard;

import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PunchCard {
    public JSONObject PunchQuery() throws SQLException {
        JSONObject json = new JSONObject();

        com.Attendence.My.Model.DAO.PunchCard.PunchCard pc = new com.Attendence.My.Model.DAO.PunchCard.PunchCard();
        ResultSet rs = pc.PunchQuery("xxxx");
        while (rs.next()){
            json.put("PunchId",rs.getString("PunchId"));
            json.put("Scode",rs.getString("Scode"));
            json.put("UserName",rs.getString("UserName"));
            json.put("PunchDate",rs.getString("PunchDate"));
            json.put("Remarks",rs.getString("Remarks"));
        }
        return json;
    }
}
