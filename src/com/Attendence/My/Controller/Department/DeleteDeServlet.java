package com.Attendence.My.Controller.Department;

import com.Attendence.My.Model.Service.Department.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteDeServlet",urlPatterns = "/DeleteDeServlet")
public class DeleteDeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department der=new Department();
        boolean bol=false;
        bol=der.DeleteDepartment();
        if(bol==true){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("xx.jsp");
            requestDispatcher.forward(request,response);
        }
        else {
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("xxx.jsp");
            requestDispatcher.forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}
