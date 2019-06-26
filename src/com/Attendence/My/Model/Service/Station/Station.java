package com.Attendence.My.Model.Service.Station;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Station.StationList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Station {
    public ArrayList<StationList> StationQuery() throws SQLException {
        com.Attendence.My.Model.DAO.Station.Station station=new com.Attendence.My.Model.DAO.Station.Station();
        return station.StationQuery();
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
    public  boolean DeleteStation(String id) {
        com.Attendence.My.Model.DAO.Station.Station station = new com.Attendence.My.Model.DAO.Station.Station();
        boolean c = false;
        try {
            c = station.DeleteSta(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (c == true) {
            return true;
        } else {
            return false;
        }
    }
    public  boolean DeleteStation(String[] del){
        com.Attendence.My.Model.DAO.Station.Station station2=new com.Attendence.My.Model.DAO.Station.Station();
        station2.DeleteStation(del);
        return true;
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
}
