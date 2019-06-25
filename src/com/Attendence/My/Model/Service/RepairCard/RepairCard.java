package com.Attendence.My.Model.Service.RepairCard;

import com.Attendence.My.Model.Entity.RepairCard.RepairInsert;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairCard {
    public JSONArray RepairQuery() throws SQLException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        com.Attendence.My.Model.DAO.RepairCard.RepairCard rc = new com.Attendence.My.Model.DAO.RepairCard.RepairCard();
        ResultSet rs = rc.RepairQuery("select * from repair");
        while (rs.next()){
            jsonObject.put("RepairId",rs.getString("RepairId"));
            jsonObject.put("ClassId",rs.getString("ClassId"));
            jsonObject.put("UserName",rs.getString("UserName"));
            jsonObject.put("RepairDate",rs.getString("RepairDate"));
            jsonObject.put("Reason",rs.getString("Reason"));
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
    public int RepairUpdate(com.Attendence.My.Model.Entity.RepairCard.RepairCard repairModel){
        com.Attendence.My.Model.DAO.RepairCard.RepairCard repairCard = new com.Attendence.My.Model.DAO.RepairCard.RepairCard();
        int line = repairCard.RepairUpdate(repairModel);
        return line;
    }
    public boolean RepairInsert(RepairInsert repairInsert) throws SQLException {
        com.Attendence.My.Model.DAO.RepairCard.RepairCard repairCard = new com.Attendence.My.Model.DAO.RepairCard.RepairCard();
        boolean re = repairCard.RepairCardInsert(repairInsert);
        if(re){
            return true;
        }
        else
            return false;
    }
}
