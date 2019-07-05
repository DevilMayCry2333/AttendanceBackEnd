package com.Attendence.my.Model.Service.Department;

import com.Attendence.My.Model.Entity.Department.DepartmentList;
import com.Attendence.My.Model.Service.Department.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void department() {
        Department department = new Department();
        try {
            ArrayList<DepartmentList> departmentLists = department.Department(1);
            for (int i = 0; i < departmentLists.size(); i++) {
                assert departmentLists.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void insertDepartment() {
        Department department = new Department();
        DepartmentList departmentList = new DepartmentList();
        departmentList.setId(21);
        departmentList.setDepartmentId("266");
        departmentList.setDname("JUnitDepTest");
        departmentList.setDPrincipal("CEO");
        departmentList.setDability("管理");
        departmentList.setSdepartment("ROOT");
        assertEquals(true,department.InsertDepartment(departmentList));
    }



    @Test
    void updateDep() {
        Department department = new Department();
        DepartmentList departmentList = new DepartmentList();
        departmentList.setId(17);
        departmentList.setDepartmentId("666");
        departmentList.setDname("JUnitUpdateTest");
        departmentList.setDPrincipal("ROOT");
        departmentList.setDability("直接负责人");
        departmentList.setSdepartment("ROOT");
        try {
            assertEquals(true,department.UpdateDep(departmentList));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteDep() {
        String id = "18";
        Department department = new Department();
        try {
            assertEquals(true,department.deleteDep(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //单个删除
    }
    @Test
    void deleteDepartment() {
        //多个删除
        String []del = {"19","20"};
        Department department = new Department();
        assertEquals(true,department.DeleteDepartment(del));
    }

    @Test
    void query() {
        Department department = new Department();
        try {
            ArrayList<DepartmentList> arr = department.Query();
            for (int i = 0; i < arr.size(); i++) {
                assert arr.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}