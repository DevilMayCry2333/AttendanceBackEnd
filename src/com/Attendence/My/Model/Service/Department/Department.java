package com.Attendence.My.Model.Service.Department;

import com.Attendence.My.Model.Entity.Department.DepartmentList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Department {
    public ArrayList<DepartmentList> Department() throws SQLException {
        JSONArray JsonArr=new JSONArray();
        JSONObject JS=new JSONObject();
        com.Attendence.My.Model.DAO.Department.Department department=new com.Attendence.My.Model.DAO.Department.Department();
        return department.DepartmentQuery();
    }
    public  boolean InsertDepartment(DepartmentList dlist){
        com.Attendence.My.Model.DAO.Department.Department dep=new com.Attendence.My.Model.DAO.Department.Department();
        boolean res = dep.InsertDepartment(dlist);
        return res;
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


    public boolean UpdateDep(DepartmentList dlist) throws SQLException {
        com.Attendence.My.Model.DAO.Department.Department dao = new com.Attendence.My.Model.DAO.Department.Department();
        boolean re = dao.UpdateDep(dlist);
        if (re){
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteDep(String id) throws SQLException {
        com.Attendence.My.Model.DAO.Department.Department dao = new com.Attendence.My.Model.DAO.Department.Department();
        boolean re = dao.DeleteDep(id);
        if (re){
            return true;
        }else {
            return false;
        }
    }
}
