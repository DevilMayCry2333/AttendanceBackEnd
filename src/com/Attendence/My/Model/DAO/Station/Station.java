package com.Attendence.My.Model.DAO.Station;

import com.Attendence.My.Model.DBUtils.DBUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;

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
    public boolean  InsertStation(ArrayList<String> list) throws SQLException {
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        String sql = "insert into Station value (null,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);


        pstmt.setString(1,list.get(0));
        pstmt.setString(2,list.get(1));
        pstmt.setString(3,list.get(2));
        pstmt.setString(4,list.get(3));
        pstmt.setString(5,list.get(4));


        int c = pstmt.executeUpdate();

        if(c==1){
            return  true;
        }
        else {
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


    public boolean UpdateSta(ArrayList<String> list) throws SQLException {
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        String sql = "update Station set JobId=?,Pname=?,Adepartment=?,Isuperior=?,Jcategory=? where Id = ?";
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,list.get(1));
        pstmt.setString(2,list.get(2));
        pstmt.setString(3,list.get(3));
        pstmt.setString(4,list.get(4));
        pstmt.setString(5,list.get(5));
        pstmt.setInt(6, Integer.parseInt(list.get(0)));

        int c = pstmt.executeUpdate();

        if(c==1){
            return  true;
        }
        else {
            return false;
        }
    }
}
