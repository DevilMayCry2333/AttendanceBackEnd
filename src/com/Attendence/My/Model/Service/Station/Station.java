package com.Attendence.My.Model.Service.Station;

import com.Attendence.My.Model.DBUtils.DBUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Station {
    public JSONArray StationQuery() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        ResultSet re=null;
        com.Attendence.My.Model.DAO.Station.Station station=new com.Attendence.My.Model.DAO.Station.Station();
        try{
            re=station.StationQuery();
            while (re.next()) {
                jsonObject.put("aasf",re.getString("xx"));
                jsonArray.add(jsonObject);
            }
            }catch (Exception e){
            e.printStackTrace();
        }
        return jsonArray;
    }
    public boolean InsertStation(){
        com.Attendence.My.Model.DAO.Station.Station station=new com.Attendence.My.Model.DAO.Station.Station();
        boolean c=false;
        try{
            c=station.InsertStation();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (c==true){
            return true;
        }
        else return false;
    }
    public  boolean DeleteStation(){
        com.Attendence.My.Model.DAO.Station.Station station=new com.Attendence.My.Model.DAO.Station.Station();
        boolean c=false;
        try {
            c=station.DeleteStation();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (c==true){
            return true;
        }
        else{
            return false;
        }
    }
}
