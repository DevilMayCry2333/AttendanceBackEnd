package com.Attendence.My.Model.DAO.Department;

import com.Attendence.My.Model.DBUtils.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class Department {
    public ResultSet DepartmentQuery(){
        String sql="SELECT * FROM Department";
        ResultSet re=null;
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        Statement sta= null;
        try {
            sta = con.createStatement();
            re=sta.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return re;
    }
    public  boolean InsertDepartment(){
        String st="INSERT INTO xx vaues (?,?,?)";
        DBUtils db=new DBUtils();
        Connection conn=db.getConnecton();
        boolean cc=false;
        try {
            Statement ste = conn.createStatement();
            cc = ste.execute(st);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (cc==true){
            return true;
        }
        else return false;
    }
    public  boolean DeleteDepartment(String []del){
        String str="DELETE FROM xx WHERE id in($id)";
        DBUtils dbu=new DBUtils();
        Connection conne=dbu.getConnecton();
        boolean ccc=false;
        try{
            Statement sta=conne.createStatement();
            ccc=sta.execute(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ccc=true){
            return true;
        }
        else {
            return false;
        }
    }


    public boolean Dep(ArrayList<String> list) throws SQLException {

        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        String sql = "insert into Department value (null,?,?,?,?,?)";
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

    public boolean UpdateDep(ArrayList<String> list) throws SQLException {
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        String sql = "update Department set DepartmentId=?,Dname=?,Dprincipal=?,Dability=?,Sdepartment=? where Id = ?";
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

    public boolean DeleteDep(String id) throws SQLException {
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        String sql = "delete from Department where Id=?";
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, Integer.parseInt(id));

        int c = pstmt.executeUpdate();

        if(c==1){
            return  true;
        }
        else {
            return false;
        }
    }
}
