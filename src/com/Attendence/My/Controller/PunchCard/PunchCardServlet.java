package com.Attendence.My.Controller.PunchCard;

import com.Attendence.My.Model.Service.PunchCard.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "PunchCardServlet",urlPatterns = "/PunchCardServlet")
public class PunchCardServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        //允许请求的方法
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");



//        out.println("<html><body>123</body></html>");
        PunchCard pc = new PunchCard();
        JSONArray js = new JSONArray();
        try {
            js = pc.PunchQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println(js);
//        try {
//            JSONArray js = pc.PunchQuery();
//            request.setAttribute("answer",js);
//            request.getRequestDispatcher("/index/sda").forward(request,response);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        request.getRequestDispatcher("/test.jsp").forward(request,response);
//        response.sendRedirect( request.getContextPath() + "/test.jsp");

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
