package com.Attendence.My.Model.Service.Station;

import com.Attendence.My.Model.DBUtils.DBUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Station {
    public JSONArray StationQuery() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        ResultSet re=null;
        com.Attendence.My.Model.DAO.Station.Station station=new com.Attendence.My.Model.DAO.Station.Station();
        try{
            re=station.StationQuery();
            while (re.next()) {
                jsonObject.put("Id",re.getString("Id"));
                jsonObject.put("JobId",re.getString("JobId"));
                jsonObject.put("Pname",re.getString("Pname"));
                jsonObject.put("Adepartment",re.getString("Adepartment"));
                jsonObject.put("Isuperior",re.getString("Isuperior"));
                jsonObject.put("Jcategory",re.getString("Jcategory"));

                jsonArray.add(jsonObject);
            }
            }catch (Exception e){
            e.printStackTrace();
        }
        return jsonArray;
    }
//    public boolean InsertStation(ArrayList<String> list){
//        com.Attendence.My.Model.DAO.Station.Station station=new com.Attendence.My.Model.DAO.Station.Station();
//        boolean c=false;
//        try{
//            c=station.InsertStation(list);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        if (c==true){
//            return true;
//        }
//        else return false;
//    }
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

    public boolean AddSta(ArrayList<String> list) throws SQLException {
        com.Attendence.My.Model.DAO.Station.Station dao= new com.Attendence.My.Model.DAO.Station.Station();
        boolean re= dao.InsertStation(list);
        if (re){
            return true;
        }else {
            return false;
        }
    }

    public boolean UpdateSta(ArrayList<String> list) throws SQLException {

        com.Attendence.My.Model.DAO.Station.Station dao = new com.Attendence.My.Model.DAO.Station.Station();
        boolean re = dao.UpdateSta(list);
        if (re){
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteSta(String id) throws SQLException {
        com.Attendence.My.Model.DAO.Station.Station dao = new com.Attendence.My.Model.DAO.Station.Station();
        boolean re = dao.DeleteSta(id);
        if (re){
            return true;
        }else {
            return false;
        }
    }
}
