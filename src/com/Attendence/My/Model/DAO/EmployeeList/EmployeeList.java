package com.Attendence.My.Model.DAO.EmployeeList;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Employee.EmployeeInsert;
import com.Attendence.My.Model.Entity.Employee.EmployeeUpdate;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeList {
    public ResultSet EmployQuery() throws SQLException {
        String str="SELECT * FROM employ";
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        ResultSet re=null;
        try {
            Statement st = con.createStatement();
            re = st.executeQuery(str);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return re;
    }

    public boolean AddEmp(ArrayList<String> list) throws SQLException {

//
//        String sql="INSERT INTO Employ( Id,EmployId, UserName, Age, Nation, IDNumber, salary, Phone, EmeContact, Job,Desc)values('" + list.get(0) +"','" + list.get(0) + "','"
//                + list.get(1) + "','" + list.get(2) +"','" + list.get(3) + "','"+ list.get(4) +"','"+ list.get(5) + "',' "+list.get(6)+" ','"+list.get(7)+"','"+list.get(8)+"','"+list.get(9)+"')";
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
        String sql = "insert into Employ value (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setInt(1,1);
        pstmt.setString(2,list.get(0));
        pstmt.setString(3,list.get(1));
        pstmt.setInt(4, Integer.parseInt(list.get(2)));
        pstmt.setString(5,list.get(3));
        pstmt.setString(6,list.get(4));
        pstmt.setDouble(7, Double.parseDouble(list.get(5)));
        pstmt.setString(8,list.get(6));
        pstmt.setString(9,list.get(7));
        pstmt.setString(10,list.get(8));
        pstmt.setString(11,list.get(9));
        pstmt.setString(12,list.get(10));


        int c = pstmt.executeUpdate();

        if(c==1){
            return  true;
        }
        else {
            return false;
        }
    }
}
