package com.Attendence.My.Model.DAO.Department;

import com.Attendence.My.Model.DBUtils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Department {
    public ResultSet DepartmentQuery(){
        String sql="SELECT * FROM xxx";
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


}
