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
    public ArrayList<com.Attendence.My.Model.Entity.Employee.EmployeeList> EmployeeList(int page) throws SQLException {
       JSONObject js= new JSONObject( );
       JSONArray Json=new JSONArray();
       com.Attendence.My.Model.DAO.EmployeeList.EmployeeList employee=new com.Attendence.My.Model.DAO.EmployeeList.EmployeeList();
       return employee.EmployQuery(page);

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

    public boolean UpdateEmp(EmployeeInsert empInsert) throws SQLException {
        EmployeeList dao = new EmployeeList();
        boolean re = dao.UpdateEmp(empInsert);
        if (re){
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteEmp(String id) throws SQLException {
        EmployeeList dao = new EmployeeList();
        boolean re = dao.DeleteEmp(id);
        if (re){
            return true;
        }else {
            return false;
        }
    }
}
