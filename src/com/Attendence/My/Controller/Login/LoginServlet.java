package com.Attendence.My.Controller.Login;

import com.Attendence.My.Model.Service.Login.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@javax.servlet.annotation.WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        String UserName=request.getParameter("username");
        String PassWord=request.getParameter("password");
        Login lo = new Login();
        try {
            boolean rs = lo.loginquery(UserName,PassWord);
            if (rs==true){
//                request.getRequestDispatcher("index.html").forward(request,response);
                response.sendRedirect( "http://localhost/AttendanceFrontEnd/index.html");

            }
            else {
//                request.getRequestDispatcher("login.html");
                response.sendRedirect( "http://localhost/AttendanceFrontEnd/login.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        PrintWriter out=response.getWriter();
//        out.println("<html><body>222</body></html>");


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
