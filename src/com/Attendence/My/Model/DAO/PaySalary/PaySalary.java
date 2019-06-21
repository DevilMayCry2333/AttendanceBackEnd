package com.Attendence.My.Model.DAO.PaySalary;

import com.Attendence.My.Model.DBUtils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaySalary {
    public ResultSet PaySalaryQuery() throws SQLException {
        String str="SELECT * FROM PaySalary";
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
    public boolean InsertPaySalary(){
        String st="INSERT INTO PaySalary vaues(?,?,?,?,?) ";
        DBUtils db=new DBUtils();
        Connection conn=db.getConnecton();
        boolean c = false;
        try {
            Statement stt=conn.createStatement();
            c=stt.execute(st);

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
}
