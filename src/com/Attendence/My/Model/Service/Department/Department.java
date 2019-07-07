package com.Attendence.My.Model.Service.Department;

import com.Attendence.My.Model.Entity.Department.DepartmentList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Department {
    //查询部门表的所有记录，传入page的值，调用DepartmentQuery方法并返回结果
    public ArrayList<DepartmentList> Department(int page) throws SQLException {
        JSONArray JsonArr=new JSONArray();
        JSONObject JS=new JSONObject();
        com.Attendence.My.Model.DAO.Department.Department department=new com.Attendence.My.Model.DAO.Department.Department();
        return department.DepartmentQuery(page);
    }
    //添加dlist记录到部门表
    public  boolean InsertDepartment(DepartmentList dlist) {
        com.Attendence.My.Model.DAO.Department.Department dep = new com.Attendence.My.Model.DAO.Department.Department();
        boolean res = dep.InsertDepartment(dlist);
        return res;
    }
    //删除记录
    public  boolean DeleteDepartment(String[] del){//批量删除
        com.Attendence.My.Model.DAO.Department.Department cd = new com.Attendence.My.Model.DAO.Department.Department();
        cd.DeleteDepartment(del);
        return true;
    }

    //修改记录
    public boolean UpdateDep(DepartmentList dlist) throws SQLException {
        com.Attendence.My.Model.DAO.Department.Department dao = new com.Attendence.My.Model.DAO.Department.Department();
        boolean re = dao.UpdateDep(dlist);
        if (re){
            return true;
        }else {
            return false;
        }
    }
    //删除记录
    public boolean deleteDep(String id) throws SQLException {
        com.Attendence.My.Model.DAO.Department.Department dao = new com.Attendence.My.Model.DAO.Department.Department();
        boolean re = dao.DeleteDep(id);
        if (re){
            return true;
        }else {
            return false;
        }
    }
    //查询记录
    public Object QueryAll() {
        com.Attendence.My.Model.DAO.Department.Department dq = new com.Attendence.My.Model.DAO.Department.Department();
        return dq.queryLines();
    }
    //查询记录
    public ArrayList<DepartmentList> Query() throws SQLException {
        JSONArray JsonArr = new JSONArray();
        JSONObject JS = new JSONObject();
        com.Attendence.My.Model.DAO.Department.Department department = new com.Attendence.My.Model.DAO.Department.Department();
        return department.Query();
    }
}
