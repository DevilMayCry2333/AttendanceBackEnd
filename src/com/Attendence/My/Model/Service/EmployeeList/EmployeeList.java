package com.Attendence.My.Model.Service.EmployeeList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeList {
    public JSONArray EmployeeList(){
       JSONObject js= new JSONObject( );
       JSONArray Json=new JSONArray();
        com.Attendence.My.Model.DAO.EmployeeList.EmployeeList employee=new com.Attendence.My.Model.DAO.EmployeeList.EmployeeList();
        ResultSet re= null;
        try {
                re = employee.EmployQuery();
                while (re.next()){
                    js.put("xx",re.getString("id"));
                    js.put("x2",re.getString("user"));
                    Json.add(js);

                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return Json;
    }
    public boolean JsonEmployee(){
        JSONObject ejson=new JSONObject();
        com.Attendence.My.Model.DAO.EmployeeList.EmployeeList Jemployee=new com.Attendence.My.Model.DAO.EmployeeList.EmployeeList();
        boolean bol=Jemployee.InsertEmployee();
        if(bol==true){
            return  true;
        }
        else {
            return  false;
        }


    }

}
