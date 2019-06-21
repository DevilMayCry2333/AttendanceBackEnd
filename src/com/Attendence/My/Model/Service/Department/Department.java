package com.Attendence.My.Model.Service.Department;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Department {
    public JSONArray Department(){
        JSONArray JsonArr=new JSONArray();
        JSONObject JS=new JSONObject();
        com.Attendence.My.Model.DAO.Department.Department department=new com.Attendence.My.Model.DAO.Department.Department();
        ResultSet re=null;
        try {
            re = department.DepartmentQuery();
            while (re.next()){
                JS.put("DepartmentId",re.getString("DepartmentId"));
                JS.put("Dname",re.getString("Dname"));
                JS.put("Dprincipal",re.getString("Dprincipal"));
                JS.put("Dability",re.getString("Dability"));
                JS.put("Sdepartment",re.getString("Sdepartment"));
                JsonArr.add(JS);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JsonArr;
    }
    public  boolean InsertDepartment(){
        com.Attendence.My.Model.DAO.Department.Department dep=new com.Attendence.My.Model.DAO.Department.Department();
        JSONObject ejson=new JSONObject();
        boolean bol=dep.InsertDepartment();
        if(bol==true){
            return  true;
        }
        else {
            return  false;
        }
    }
    public  boolean DeleteDepartment(String[] del){
        com.Attendence.My.Model.DAO.Department.Department depa=new com.Attendence.My.Model.DAO.Department.Department();
        boolean dept=depa.DeleteDepartment(del);
        if (dept==true){
            return true;
        }
        else{
            return false;
        }
    }

}
