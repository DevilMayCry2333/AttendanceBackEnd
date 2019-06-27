package com.Attendence.My.Model.Service.PunchCard;

import com.Attendence.My.Model.Entity.PunchCard.PunchCardInsert;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PunchCard {
    public ArrayList<com.Attendence.My.Model.Entity.PunchCard.PunchCard> PunchQuery() throws SQLException {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        com.Attendence.My.Model.DAO.PunchCard.PunchCard pc = new com.Attendence.My.Model.DAO.PunchCard.PunchCard();
        return pc.PunchQuery("SELECT * from Punch");

    }

    public ArrayList<com.Attendence.My.Model.Entity.PunchCard.PunchCard> Query() throws SQLException {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        com.Attendence.My.Model.DAO.PunchCard.PunchCard pc = new com.Attendence.My.Model.DAO.PunchCard.PunchCard();
        return pc.Query("SELECT * from Punch");

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
