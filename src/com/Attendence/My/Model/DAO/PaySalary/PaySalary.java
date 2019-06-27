package com.Attendence.My.Model.DAO.PaySalary;

import com.Attendence.My.Model.DBUtils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PaySalary {
    public ArrayList<com.Attendence.My.Model.Entity.PaySalary.PaySalary> PaySalaryQuery() throws SQLException {
        String str="SELECT * FROM pay";
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        ArrayList<com.Attendence.My.Model.Entity.PaySalary.PaySalary> arrPay = new ArrayList<>();
        ResultSet re = null;
        Statement st = null;
        try {
            st = con.createStatement();
            re = st.executeQuery(str);
            while (re.next()){
                com.Attendence.My.Model.Entity.PaySalary.PaySalary pay = new com.Attendence.My.Model.Entity.PaySalary.PaySalary();
                pay.setClassId(re.getString("ClassId"));
                pay.setEmpName(re.getString("EmpName"));
                pay.setSalary(re.getInt("Salary"));
                pay.setBeginTime(re.getString("BeginTime"));
                pay.setEndTime(re.getString("EndTime"));
                arrPay.add(pay);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            re.close();
            st.close();
            con.close();
        }
        return arrPay;

    }
    public boolean InsertPaySalary(){
        String st="INSERT INTO PaySalary vaues(?,?,?,?,?) ";
        DBUtils db=new DBUtils();
        Connection conn=db.getConnecton();
        Statement stt = null;
        boolean c = false;
        try {
            stt=conn.createStatement();
            c=stt.execute(st);
            stt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(c==true){
            return  true;
        }
        else {
            return false;
        }
    }
    public ArrayList<com.Attendence.My.Model.Entity.PaySalary.PaySalary> Query() throws SQLException {
        String str="SELECT * FROM pay";
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        ArrayList<com.Attendence.My.Model.Entity.PaySalary.PaySalary> arrPay = new ArrayList<>();
        ResultSet re = null;
        Statement st = null;
        try {
            st = con.createStatement();
            re = st.executeQuery(str);
            while (re.next()){
                com.Attendence.My.Model.Entity.PaySalary.PaySalary pay = new com.Attendence.My.Model.Entity.PaySalary.PaySalary();
                pay.setClassId(re.getString("ClassId"));
                pay.setEmpName(re.getString("EmpName"));
                pay.setSalary(re.getInt("Salary"));
                pay.setBeginTime(re.getString("BeginTime"));
                pay.setEndTime(re.getString("EndTime"));
                arrPay.add(pay);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            re.close();
            st.close();
            con.close();
        }
        return arrPay;

    }
}
