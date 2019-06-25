package com.Attendence.My.Controller.EmployeeList;

import com.Attendence.My.Model.Entity.Employee.EmployeeInsert;
import com.Attendence.My.Model.Entity.Employee.EmployeeUpdate;
import com.Attendence.My.Model.Service.EmployeeList.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EmployeeUpdateServlet",urlPatterns = "/EmployeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {
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

        String id= request.getParameter("id");
        String EmployId=request.getParameter("a");
        String UserName=request.getParameter("b");
        String Age=request.getParameter("c");
        String Nation= request.getParameter("d");
        String IDnumber= request.getParameter("e");
        String Salary=request.getParameter("f");
        String Phone=request.getParameter("g");
        String EmeContact=request.getParameter("h");
        String Job = request.getParameter("i");
        String Desc = request.getParameter("j");
        String sex = request.getParameter("k");

        EmployeeInsert EmpInsert = new EmployeeInsert();
        EmpInsert.setId(Integer.parseInt(id));
        EmpInsert.setUserCode(EmployId);
        EmpInsert.setUserName(UserName);
        EmpInsert.setNation(Nation);
        EmpInsert.setIdCard(IDnumber);
        EmpInsert.setSalary(Salary);
        EmpInsert.setTel(Phone);
        EmpInsert.setEmergyContact(EmeContact);
        EmpInsert.setStation(Job);
        EmpInsert.setDesc(Desc);
        EmpInsert.setGender(sex);
        EmpInsert.setAge(Age);

        Employee s= new Employee();
        try {
            if(s.UpdateEmp(EmpInsert)){
                System.out.println("yes");
            }else{
                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
