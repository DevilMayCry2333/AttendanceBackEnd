package com.Attendence.My.Model.Entity.Department;

public class DepartmentList {
    private int Id;
    private String DepartmentId;
    private String Dname;
    private String DPrincipal;
    private String Dability;
    private String Sdepartment;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(String departmentId) {
        DepartmentId = departmentId;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getDPrincipal() {
        return DPrincipal;
    }

    public void setDPrincipal(String DPrincipal) {
        this.DPrincipal = DPrincipal;
    }

    public String getDability() {
        return Dability;
    }

    public void setDability(String dability) {
        Dability = dability;
    }

    public String getSdepartment() {
        return Sdepartment;
    }

    public void setSdepartment(String sdepartment) {
        Sdepartment = sdepartment;
    }
}
