package com.Attendence.my.Model.Service.EmployeeList;

import com.Attendence.My.Model.Entity.Employee.EmployeeInsert;
import com.Attendence.My.Model.Entity.Employee.EmployeeList;
import com.Attendence.My.Model.Service.EmployeeList.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void employeeList() {
        Employee employee = new Employee();
        try {
            ArrayList<EmployeeList> employeeLists = employee.EmployeeList(1);
            for (int i = 0; i < employeeLists.size(); i++) {
                assert employeeLists.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    void addEmp() {
        Employee employee = new Employee();
        EmployeeInsert employeeInsert = new EmployeeInsert();
        employeeInsert.setId(29);
        employeeInsert.setUserCode("2222");
        employeeInsert.setUserName("Update");
        employeeInsert.setNation("中国");
        employeeInsert.setIdCard("350122");
        employeeInsert.setSalary("10000");
        employeeInsert.setTel("137");
        employeeInsert.setEmergyContact("137");
        employeeInsert.setStation("测试");
        employeeInsert.setDesc("描述");
        employeeInsert.setAge("13");
        employeeInsert.setGender("男");
        employeeInsert.setClassId("214");
        try {
            assertEquals(true,employee.AddEmp(employeeInsert));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateEmp() {
        Employee employee = new Employee();
        EmployeeInsert employeeInsert = new EmployeeInsert();
        employeeInsert.setId(28);
        employeeInsert.setUserCode("66666");
        employeeInsert.setUserName("Update");
        employeeInsert.setNation("中国");
        employeeInsert.setIdCard("350122");
        employeeInsert.setSalary("10000");
        employeeInsert.setTel("137");
        employeeInsert.setEmergyContact("137");
        employeeInsert.setStation("测试");
        employeeInsert.setDesc("描述");
        employeeInsert.setAge("13");
        employeeInsert.setGender("男");
        employeeInsert.setClassId("214");
        try {
            assertEquals(true,employee.UpdateEmp(employeeInsert));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteEmp() {
        String id = "27";
        Employee employee = new Employee();
        try {
            assertEquals(true,employee.deleteEmp(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteAllEmp() {
        String []del = {"26","25"};
        Employee employee = new Employee();
        assertEquals(true,employee.DeleteAllEmp(del));
    }

    @Test
    void query() {
        Employee employee = new Employee();
        try {
            ArrayList<EmployeeList> employeeLists = employee.Query();
            for (int i = 0; i < employeeLists.size(); i++) {
                assert employeeLists.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}