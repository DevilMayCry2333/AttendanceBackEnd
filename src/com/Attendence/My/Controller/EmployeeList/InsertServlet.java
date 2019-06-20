package com.Attendence.My.Controller.EmployeeList;

import com.Attendence.My.Model.Service.EmployeeList.EmployeeList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertServlet",urlPatterns = "/InsertServlet")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeList emp=new EmployeeList();
        boolean aa=emp.JsonEmployee();
        if(aa==true){
            //request.setAttribute("jsonArr",aa);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("xxx.jsp");
            requestDispatcher.forward(request,response);
        }
        else {
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("xxx.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
