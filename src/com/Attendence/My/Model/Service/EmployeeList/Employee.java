package com.Attendence.My.Model.Service.EmployeeList;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Employee.EmployeeInsert;
import com.Attendence.My.Model.Entity.Employee.EmployeeUpdate;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.Attendence.My.Model.DAO.EmployeeList.EmployeeList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee {
    //查询员工表的所有记录，传入page的值，调用EmployQuery方法并返回结果
    public ArrayList<com.Attendence.My.Model.Entity.Employee.EmployeeList> EmployeeList(int page) throws SQLException {
       JSONObject js= new JSONObject( );
       JSONArray Json=new JSONArray();
       com.Attendence.My.Model.DAO.EmployeeList.EmployeeList employee=new com.Attendence.My.Model.DAO.EmployeeList.EmployeeList();
       return employee.EmployQuery(page);

    }
    //添加EmpInsert记录到部门表
    public boolean AddEmp(EmployeeInsert EmpInsert) throws SQLException {
        EmployeeList dao = new EmployeeList();
        boolean re= dao.AddEmp(EmpInsert);
        if (re){
            return true;
        }else {
            return false;
        }

    }
    //修改EmpInsert记录到部门表
    public boolean UpdateEmp(EmployeeInsert empInsert) throws SQLException {
        EmployeeList dao = new EmployeeList();
        boolean re = dao.UpdateEmp(empInsert);
        if (re){
            return true;
        }else {
            return false;
        }
    }
    //删除记录
    public boolean deleteEmp(String id) throws SQLException {
        EmployeeList dao = new EmployeeList();
        boolean re = dao.DeleteEmp(id);
        if (re){
            return true;
        }else {
            return false;
        }
    }
    //删除记录
    public boolean DeleteAllEmp(String[] tearray) {
        EmployeeList cd = new EmployeeList();
        cd.DeleteAllEmp(tearray);
        return true;
    }
    //查询记录
    public int QueryAll(){
        EmployeeList el = new EmployeeList();
        return el.queryLines();
    }
    //查询记录
    public ArrayList<com.Attendence.My.Model.Entity.Employee.EmployeeList> Query() throws SQLException {
        EmployeeList el=new EmployeeList();
        return el.EmployQueryall();
    }
}
