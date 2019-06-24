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

    public boolean AddEmp(EmployeeInsert EmpInsert) throws SQLException {

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
        String sql = "insert into Employ(EmployId, UserName, Nation, IDNumber, salary, Phone, EmeContact, Job, Describle, Age, Gender, ClassId)  value (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);


        pstmt.setString(1,EmpInsert.getUserCode());
        pstmt.setString(2,EmpInsert.getUserName());
        pstmt.setString(3, EmpInsert.getNation());
        pstmt.setString(4,EmpInsert.getIdCard());
        pstmt.setString(5,EmpInsert.getSalary());
        pstmt.setString(6, EmpInsert.getTel());
        pstmt.setString(7,EmpInsert.getEmergyContact());
        pstmt.setString(8,EmpInsert.getStation());
        pstmt.setString(9,EmpInsert.getDesc());
        pstmt.setString(10,EmpInsert.getAge());
        pstmt.setString(11,EmpInsert.getGender());
        //班次ID是需要查询的
        pstmt.setString(12,"1");



        int c = pstmt.executeUpdate();

        if(c==1){
            return  true;
        }
        else {
            return false;
        }
    }
}
