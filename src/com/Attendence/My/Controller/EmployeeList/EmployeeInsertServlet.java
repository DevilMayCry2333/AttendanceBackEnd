package com.Attendence.My.Controller.EmployeeList;

import com.Attendence.My.Model.DAO.EmployeeList.EmployeeList;
import com.Attendence.My.Model.Entity.Employee.EmployeeInsert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "EmployeeInsertServlet",urlPatterns = "/EmployeeInsertServlet")
public class EmployeeInsertServlet extends HttpServlet {
/*
    private String userName;
    private String userCode;
    private String Nation;
    private String IdCard;
    private String Salary;
    private String tel;
    private String EmergyContact;
    private String Station;
    private String Desc;

 */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        //允许请求的方法
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        EmployeeInsert empInsert = new EmployeeInsert();
        empInsert.setUserName(request.getParameter("userName"));
        empInsert.setUserCode(request.getParameter("userCode"));
        empInsert.setNation(request.getParameter("Nation"));
        empInsert.setIdCard(request.getParameter("IdCard"));
        empInsert.setSalary(request.getParameter("Salary"));
        empInsert.setTel(request.getParameter("tel"));
        empInsert.setEmergyContact(request.getParameter("EmergyContact"));
        empInsert.setStation(request.getParameter("Station"));
        empInsert.setDesc(request.getParameter("Desc"));

        com.Attendence.My.Model.Service.EmployeeList.Employee elService =
                new com.Attendence.My.Model.Service.EmployeeList.Employee();
        try {
            elService.AddEmp(empInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("http://localhost/AttendanceFrontEnd/index.html");



//        System.out.println(empInsert.getDesc());

//        PrintWriter out = response.getWriter();
//        out.println(request.getParameter("userCode"));

//        System.out.println(request.getParameter("userCode"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
