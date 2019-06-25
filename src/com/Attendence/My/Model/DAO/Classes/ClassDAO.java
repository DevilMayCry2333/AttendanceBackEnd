package com.Attendence.My.Model.DAO.Classes;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Class.ClassUpdate;

import java.sql.*;
import java.util.ArrayList;

public class ClassDAO {
    public ResultSet ClassQuery() throws SQLException {
        String str="SELECT * from Classes";
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        ResultSet re = null;
        try {
            Statement st = con.createStatement();
            re = st.executeQuery(str);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return re;
    }

    public boolean InsertClass(ArrayList<String> list) throws SQLException {
//        String sql="INSERT INTO Classes(ClassId,Cname,Mtime,Atime)values('" + list.get(0) + "','"
//                + list.get(1) + "','" + list.get(2) +"','" + list.get(3) + "')";
//        DBUtils db=new DBUtils();
//        Connection conn=db.getConnecton();
//        boolean c = false;
//        try {
//            Statement stt=conn.createStatement();
//            c=stt.execute(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if(c==true){
//            return  true;
//        }
//        else {
//            return false;
//        }


        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        String sql = "insert into Classes(ClassId, Cname, Mtime, Atime)  value (?,?,?,?)";
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, list.get(0));
        pstmt.setString(2, list.get(1));
        pstmt.setString(3, list.get(2));
        pstmt.setString(4, list.get(3));

        int c = pstmt.executeUpdate();

        if (c == 1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean DeleteClass(String []del){
        StringBuffer sql = new StringBuffer("DELETE FROM Classes WHERE Id in(");
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

}
