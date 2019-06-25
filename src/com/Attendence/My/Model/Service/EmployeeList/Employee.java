package com.Attendence.My.Model.Service.EmployeeList;

import com.Attendence.My.Model.Entity.Employee.EmployeeInsert;
import com.Attendence.My.Model.Entity.Employee.EmployeeUpdate;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.Attendence.My.Model.DAO.EmployeeList.EmployeeList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee {
    public JSONArray EmployeeList(int page){
       JSONObject js= new JSONObject( );
       JSONArray Json=new JSONArray();
        com.Attendence.My.Model.DAO.EmployeeList.EmployeeList employee=new com.Attendence.My.Model.DAO.EmployeeList.EmployeeList();
        ResultSet re= null;
        try {
                re = employee.EmployQuery(page);
                while (re.next()){
                    js.put("Id",re.getString("Id"));
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

    public boolean UpdateEmployee(ArrayList<String> aa){
        com.Attendence.My.Model.DAO.EmployeeList.EmployeeList employeeList=new com.Attendence.My.Model.DAO.EmployeeList.EmployeeList();
        boolean cc=employeeList.UpdateEmployee(aa);
        if (cc==true){
            return true;
        }
        else {
            return false;
        }
    }
    public JSONArray  UpdateEmployQuery(String id) {
        JSONObject js = new JSONObject();
        JSONArray Json = new JSONArray();
        com.Attendence.My.Model.DAO.EmployeeList.EmployeeList employeeList = new com.Attendence.My.Model.DAO.EmployeeList.EmployeeList();
        ResultSet re = null;
        try {
            re = employeeList.UpdateEmployQuery(id);
            while (re.next()) {
                js.put("EmployId", re.getString("EmployId"));
                js.put("UserName", re.getString("UserName"));
                js.put("Gender", re.getString("Gender"));
                js.put("Age", re.getInt("Age"));
                js.put("Nation", re.getString("Nation"));
                js.put("Job", re.getString("Job"));
                Json.add(js);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Json;
    }

    public boolean AddEmp(EmployeeInsert EmpInsert) throws SQLException {
        EmployeeList dao = new EmployeeList();
        boolean re= dao.AddEmp(EmpInsert);
        if (re){
            return true;
        }else {
            return false;
        }

    }

}
