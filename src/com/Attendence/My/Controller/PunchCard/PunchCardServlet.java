package com.Attendence.My.Controller.PunchCard;

import com.Attendence.My.Model.Service.PunchCard.PunchCard;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "PunchCardServlet",urlPatterns = "/PunchCardServlet")
public class PunchCardServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>123</body></html>");
//        PunchCard pc = new PunchCard();
//        try {
//            JSONObject js = pc.PunchQuery();
//            request.setAttribute("answer",js);
//            request.getRequestDispatcher("/index/sda").forward(request,response);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        request.getRequestDispatcher("/test.jsp").forward(request,response);
        response.sendRedirect( request.getContextPath() + "/test.jsp");

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
