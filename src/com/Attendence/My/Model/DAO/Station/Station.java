package com.Attendence.My.Model.DAO.Station;

import com.Attendence.My.Model.DBUtils.DBUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Station {
    public ResultSet StationQuery(){
        String sql="SELECT * FROM station";
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        ResultSet re=null;
        try{
            Statement sta=con.createStatement();
            re = sta.executeQuery(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return re;
    }
    public boolean  InsertStation(){
        String sql="INSERT INTO Station vaues(?,?,?)";
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        boolean c=false;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
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
    public boolean DeleteStation() {
        String sql = "DELETE FROM xx WHERE id in($id)";
        DBUtils dbUtils = new DBUtils();
        Connection con = dbUtils.getConnecton();
        boolean c = false;
        try {
            Statement sta = con.createStatement();
            c = sta.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (c == true) {
            return true;
        } else {
            return false;
        }
    }

}
