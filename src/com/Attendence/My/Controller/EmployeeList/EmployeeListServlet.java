package com.Attendence.My.Controller.EmployeeList;

import com.Attendence.My.Model.Service.EmployeeList.EmployeeList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeListServlet",urlPatterns = "/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONArray js = new JSONArray();
        EmployeeList em=new EmployeeList();
        js=em.EmployeeList();
        request.setAttribute("jsonArr",js);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("xxx.jsp");
        requestDispatcher.forward(request,response);

//        js.put("user","132");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
