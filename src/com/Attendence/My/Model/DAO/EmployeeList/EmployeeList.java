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
    public ArrayList<com.Attendence.My.Model.Entity.Employee.EmployeeList> EmployQuery(int page) throws SQLException {
        String str="SELECT * FROM Employ LIMIT ?,?";
        System.out.println(str);
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        ResultSet re=null;
        ArrayList<com.Attendence.My.Model.Entity.Employee.EmployeeList> earr = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(str);
            st.setInt(1,page*10-10);
            st.setInt(2,10);
            re = st.executeQuery();
            //                    js.put("Id",re.getString("Id"));
//                    js.put("EmployId",re.getString("EmployId"));
//                    js.put("UserName",re.getString("UserName"));
//                    js.put("Gender",re.getString("Gender"));
//                    js.put("Age",re.getInt("Age"));
//                    js.put("Nation",re.getString("Nation"));
//                    js.put("Job",re.getString("Job"));
            while (re.next()){
                com.Attendence.My.Model.Entity.Employee.EmployeeList emm = new com.Attendence.My.Model.Entity.Employee.EmployeeList();
                emm.setId(re.getInt("Id"));
                emm.setUserCode(re.getString("EmployId"));
                emm.setUserName(re.getString("UserName"));
                emm.setGender(re.getString("Gender"));
                emm.setAge(re.getString("Age"));
                emm.setNation(re.getString("Nation"));
                emm.setStation(re.getString("Job"));
                earr.add(emm);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            re.close();
            st.close();
            con.close();
        }
        return earr;
    }

    public boolean AddEmp(EmployeeInsert EmpInsert) throws SQLException {

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
        pstmt.setString(12,EmpInsert.getClassId());
        //班次ID是需要查询的
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

    public boolean UpdateEmp(EmployeeInsert EmpInsert) throws SQLException {
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        String sql = "update Employ set EmployId=?, UserName=?, Nation=?, IDNumber=?, salary=?, Phone=?, EmeContact=?, Job=?, Describle=?, Age=?, Gender=? where Id = ?";
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
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
        pstmt.setString(12, String.valueOf(EmpInsert.getId()));

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

    public boolean DeleteEmp(String id) throws SQLException {
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        String sql = "delete from Employ where id=?";
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


    public boolean DeleteAllEmp(String []del){
        StringBuffer sql = new StringBuffer("DELETE FROM Employ WHERE Id in(");
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

    public int queryLines(){
        DBUtils db = new DBUtils();
        Connection conn = db.getConnecton();
        int res = 0;
        ResultSet rs = null;
        try {
            PreparedStatement psmt = conn.prepareStatement("SELECT count(Id) EmpCount FROM Employ");
            rs = psmt.executeQuery();
            if(rs.next()){
                res = rs.getInt("EmpCount");
                System.out.println(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public ArrayList<com.Attendence.My.Model.Entity.Employee.EmployeeList> EmployQueryall() throws SQLException {
        String str="SELECT * FROM Employ";
        System.out.println(str);
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        ResultSet re=null;
        ArrayList<com.Attendence.My.Model.Entity.Employee.EmployeeList> earr = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(str);
            re = st.executeQuery();
            //                    js.put("Id",re.getString("Id"));
//                    js.put("EmployId",re.getString("EmployId"));
//                    js.put("UserName",re.getString("UserName"));
//                    js.put("Gender",re.getString("Gender"));
//                    js.put("Age",re.getInt("Age"));
//                    js.put("Nation",re.getString("Nation"));
//                    js.put("Job",re.getString("Job"));
            while (re.next()){
                com.Attendence.My.Model.Entity.Employee.EmployeeList emm = new com.Attendence.My.Model.Entity.Employee.EmployeeList();
                emm.setId(re.getInt("Id"));
                emm.setUserCode(re.getString("EmployId"));
                emm.setUserName(re.getString("UserName"));
                emm.setGender(re.getString("Gender"));
                emm.setAge(re.getString("Age"));
                emm.setNation(re.getString("Nation"));
                emm.setStation(re.getString("Job"));
                emm.setIdCard(re.getString("IDNumber"));
                emm.setSalary(re.getString("salary"));
                emm.setTel(re.getString("Phone"));
                emm.setEmergyContact(re.getString("EmeContact"));
                emm.setStation(re.getString("Job"));
                emm.setDesc(re.getString("Describle"));
                earr.add(emm);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            re.close();
            st.close();
            con.close();
        }
        return earr;
    }
}

