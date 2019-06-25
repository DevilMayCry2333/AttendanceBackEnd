package com.Attendence.My.Model.DAO.EmployeeList;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Employee.EmployeeInsert;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeList {
    public ResultSet EmployQuery(int page) throws SQLException {
        String str="SELECT * FROM employ where id between '" + (page-1)*10 + "'and '"+(page)*10 + "'";
        System.out.println(str);
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

    public boolean UpdateEmployee(ArrayList<String> aa){
        //ResultSet c=null;
        boolean c=false;
        String str = "UPDATE Employ SET EmployId='" + aa.get(0) + "',UserName='" + aa.get(1) +
                "',Age='" + aa.get(2) + "',Nation='" +  aa.get(3) + "',IDNumber='" + aa.get(4) +
                "',salary='" +  aa.get(5) + "',Phone='" +  aa.get(6) + "',EmeContact='" + aa.get(7)
                + "',job='" +  aa.get(8) + "',Des='"+  aa.get(9)+"' where Id = 1" ;
        //String sql = "UPDATE Employee SET ";
        System.out.println(str);
            DBUtils db=new DBUtils();
            Connection con=db.getConnecton();
            try{
                Statement ste=con.createStatement();
                c=ste.execute(str);
            }catch (Exception e){
                e.printStackTrace( );
            }
        if (c==true){
            return  true;
        }
        else{
            return false;
        }
    }
        public ResultSet UpdateEmployQuery(String id) throws SQLException {
            String str="SELECT * FROM Employ where EmployId=id";
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
}
