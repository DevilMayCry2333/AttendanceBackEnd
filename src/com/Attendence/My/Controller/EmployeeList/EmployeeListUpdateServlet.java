package com.Attendence.My.Controller.EmployeeList;

import com.Attendence.My.Model.Entity.EmployeeList.EmployeeListUpdate;

import com.Attendence.My.Model.Service.EmployeeList.Employee;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EmployeeListUpdateServlet",urlPatterns = "/EmployeeListUpdateServlet")
public class EmployeeListUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> arrayList=new ArrayList<>();
        boolean c=false;

        Employee tt=new Employee();

        EmployeeListUpdate elu = new EmployeeListUpdate();
        elu.setEmployId("123");

        c=tt.UpdateEmployee(arrayList);
//        if (c==true){
//            response.sendRedirect("xx");
//
//        }else {
//            response.sendRedirect("xx");
//        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
