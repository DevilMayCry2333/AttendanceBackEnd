package com.Attendence.My.Model.Service.PunchCard;

import com.Attendence.My.Model.Entity.PunchCard.PunchCardInsert;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import java.sql.ResultSet;
import java.sql.SQLException;

public class PunchCard {
    public JSONArray PunchQuery() throws SQLException {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        com.Attendence.My.Model.DAO.PunchCard.PunchCard pc = new com.Attendence.My.Model.DAO.PunchCard.PunchCard();
        ResultSet rs = pc.PunchQuery("SELECT * from Punch");
        while (rs.next()){
            json.put("PunchId",rs.getString("PunchId"));
            json.put("Scode",rs.getString("ClassId"));
            json.put("UserName",rs.getString("UserName"));
            json.put("PunchDate",rs.getString("PunchDate"));
            json.put("Remarks",rs.getString("Remarks"));
            jsonArray.add(json);
        }
        return jsonArray;
    }

    public int PunchUpdate (com.Attendence.My.Model.Entity.PunchCard.PunchCard punchModel) {
//        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = new JSONArray();
        com.Attendence.My.Model.DAO.PunchCard.PunchCard punchCard = new com.Attendence.My.Model.DAO.PunchCard.PunchCard();

//        System.out.println(sql);
        int line = punchCard.PunchUpdate( punchModel);
        return line;
    }
    public boolean PunchInsert(PunchCardInsert punchModel) throws SQLException {
        com.Attendence.My.Model.DAO.PunchCard.PunchCard punchCard = new com.Attendence.My.Model.DAO.PunchCard.PunchCard();
        boolean re = punchCard.PunchCardInsert(punchModel);
        if(re){
            return true;
        }else{
            return false;
        }

    }
}
