package com.Attendence.My.Model.DAO.Station;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Station.StationList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;

public class Station {
    public ArrayList<StationList> StationQuery() throws SQLException {
        String sql="SELECT * FROM Station";
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        Statement sta= null;
        ArrayList<StationList> StationArr = new ArrayList<>();
        ResultSet re=null;
        try{
            sta = con.createStatement();
            re = sta.executeQuery(sql);
            while (re.next()){
                StationList sl = new StationList();
                sl.setId(re.getInt("Id"));
                sl.setJobId(re.getString("JobId"));
                sl.setPname(re.getString("Pname"));
                sl.setAdepartment(re.getString("Adepartment"));
                sl.setIsuperior(re.getString("Isuperior"));
                sl.setJcategory(re.getString("Jcategory"));
                StationArr.add(sl);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            re.close();
            sta.close();
            con.close();
        }
        return StationArr;
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
        pstmt.close();
        con.close();
        if(c==1){
            return  true;
        }
        else {
            return false;
        }
    }
    public boolean DeleteStation(String[] del) {
        StringBuffer sql = new StringBuffer("DELETE FROM Station WHERE Id in(");
        for (int i = 0; i < del.length; i++) {
            if (i==del.length-1){
                sql.append("'" + del[i] + "')");
            }else {
                sql.append("'" + del[i] + "',");
            }
        }
        System.out.println(sql);
        DBUtils dbUtils=new DBUtils();
        Connection cn = dbUtils.getConnecton();
        try {
            Statement st = cn.createStatement();
            st.executeUpdate(sql.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
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
        pstmt.close();
        con.close();
        if(c==1){
            return  true;
        }
        else {
            return false;
        }
    }

    public boolean DeleteSta(String id) throws SQLException {
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        String sql = "delete from Station where Id=?";
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, Integer.parseInt(id));

        int c = pstmt.executeUpdate();
        pstmt.close();
        con.close();
        if(c==1){
            return  true;
        }
        else {
            return false;
        }
    }
}
