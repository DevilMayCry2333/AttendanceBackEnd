package com.Attendence.My.Model.Service.EmployeeList;

import com.Attendence.My.Model.Entity.Employee.EmployeeInsert;
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
                    js.put("EmployId",re.getString("EmployId"));
                    js.put("UserName",re.getString("UserName"));
                    js.put("Gender",re.getString("Gender"));
                    js.put("Age",re.getInt("Age"));
                    js.put("Nation",re.getString("Nation"));
                    js.put("Job",re.getString("Job"));
                    Json.add(js);

                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return Json;
    }
    public boolean insertEmployee(EmployeeInsert employInsert){
        com.Attendence.My.Model.DAO.EmployeeList.EmployeeList emList =
                new com.Attendence.My.Model.DAO.EmployeeList.EmployeeList();
        return emList.InsertEmployee(employInsert);
    }

}
