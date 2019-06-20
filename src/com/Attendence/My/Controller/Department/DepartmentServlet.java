package com.Attendence.My.Controller.Department;

import com.Attendence.My.Model.Service.Department.Department;
import net.sf.json.JSONArray;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DepartmentServlet",urlPatterns = "/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONArray array=new JSONArray();
        Department department=new Department();
        array=department.Department();
        request.setAttribute("jsonArr",array);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("xxx.jsp");
        requestDispatcher.forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
