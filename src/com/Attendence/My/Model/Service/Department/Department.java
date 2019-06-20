package com.Attendence.My.Model.Service.Department;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Department {
    public JSONArray Department(){
        com.Attendence.My.Model.DAO.Department.Department department=new com.Attendence.My.Model.DAO.Department.Department();
        ResultSet re=null;
        JSONArray JsonArr=new JSONArray();
        JSONObject JS=new JSONObject();
        try {
            re = department.DepartmentQuery();
            while (re.next()){
                JS.put("xx",re.getString("xx"));
                JS.put("x2",re.getString("xx"));
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
    public  boolean DeleteDepartment(){
        com.Attendence.My.Model.DAO.Department.Department depa=new com.Attendence.My.Model.DAO.Department.Department();
        boolean dept=depa.DeleteDepartment();
        if (dept==true){
            return true;
        }
        else{
            return false;
        }
    }

}
