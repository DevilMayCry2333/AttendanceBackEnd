package com.Attendence.My.Controller.Department;

import com.Attendence.My.Model.Service.Department.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertDeServlet",urlPatterns = "/InsertDeServlet")
public class InsertDeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          boolean cc=false;
        Department de=new Department();
        cc=de.InsertDepartment();
        if (cc==true){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("xxx.jsp");
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
