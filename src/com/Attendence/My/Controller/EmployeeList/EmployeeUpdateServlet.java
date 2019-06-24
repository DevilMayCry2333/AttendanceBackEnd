package com.Attendence.My.Controller.EmployeeList;

import com.Attendence.My.Model.Entity.Employee.EmployeeUpdate;
import com.Attendence.My.Model.Service.EmployeeList.EmployeeList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeUpdate employeeUpdate=new EmployeeUpdate();
        employeeUpdate.setUserName(request.getParameter("UserName"));
        employeeUpdate.setUserCode(request.getParameter("userCode"));
        employeeUpdate.setNation(request.getParameter("Nation"));
        employeeUpdate.setIdCard(request.getParameter("IdCard"));
        employeeUpdate.setSalary(request.getParameter("Salary"));
        employeeUpdate.setTel(request.getParameter("tel"));
        employeeUpdate.setEmergyContact(request.getParameter("EmergyContact"));
        employeeUpdate.setStation(request.getParameter("Station"));
        employeeUpdate.setDesc(request.getParameter("Desc"));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
