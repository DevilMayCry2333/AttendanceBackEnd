package com.Attendence.My.Model.Service.PaySalaryList;

import com.Attendence.My.Model.DAO.PaySalary.PaySalary;
import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Attend.Attend;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PaySalaryList {
    public ArrayList<com.Attendence.My.Model.Entity.PaySalary.PaySalary> PaySalayList(){
        JSONObject js= new JSONObject( );
        JSONArray Json=new JSONArray();
        PaySalary payDAO = new PaySalary();
        ArrayList<com.Attendence.My.Model.Entity.PaySalary.PaySalary> paySalary = null;
        try {
            paySalary = payDAO.PaySalaryQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paySalary;
    }
    public ArrayList<com.Attendence.My.Model.Entity.PaySalary.PaySalary> Query(){
        JSONObject js= new JSONObject( );
        JSONArray Json=new JSONArray();
        PaySalary payDAO = new PaySalary();
        ArrayList<com.Attendence.My.Model.Entity.PaySalary.PaySalary> paySalary = null;
        try {
            paySalary = payDAO.Query();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paySalary;
    }
}
