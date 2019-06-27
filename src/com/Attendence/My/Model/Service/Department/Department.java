package com.Attendence.My.Model.Service.Department;

import com.Attendence.My.Model.Entity.Department.DepartmentList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Department {
    public ArrayList<DepartmentList> Department(int page) throws SQLException {
        JSONArray JsonArr=new JSONArray();
        JSONObject JS=new JSONObject();
        com.Attendence.My.Model.DAO.Department.Department department=new com.Attendence.My.Model.DAO.Department.Department();
        return department.DepartmentQuery(page);
    }
    public  boolean InsertDepartment(DepartmentList dlist) {
        com.Attendence.My.Model.DAO.Department.Department dep = new com.Attendence.My.Model.DAO.Department.Department();
        boolean res = dep.InsertDepartment(dlist);
        return res;
    }
    public  boolean DeleteDepartment(String[] del){//批量删除
        com.Attendence.My.Model.DAO.Department.Department cd = new com.Attendence.My.Model.DAO.Department.Department();
        cd.DeleteDepartment(del);
        return true;
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

    public Object QueryAll() {
        com.Attendence.My.Model.DAO.Department.Department dq = new com.Attendence.My.Model.DAO.Department.Department();
        return dq.queryLines();
    }

    public ArrayList<DepartmentList> Query() throws SQLException {
        JSONArray JsonArr = new JSONArray();
        JSONObject JS = new JSONObject();
        com.Attendence.My.Model.DAO.Department.Department department = new com.Attendence.My.Model.DAO.Department.Department();
        return department.Query();
    }
}
