package com.Attendence.My.Controller.Login;

import com.Attendence.My.Model.Service.Login.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UnLoginServlet", urlPatterns = "/UnLoginServlet")
public class UnLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Login lg = new Login();
        String username = request.getParameter("username");
        System.out.print(username);

        lg.deletLogin(username);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
