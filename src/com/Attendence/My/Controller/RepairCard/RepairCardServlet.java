package com.Attendence.My.Controller.RepairCard;

import com.Attendence.My.Model.Service.RepairCard.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RepairCardServlet",urlPatterns = "/RepairCardServlet")
public class RepairCardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//        out.println("<html><body>123</body></html>");
        RepairCard repairCard = new RepairCard();
        try {
            JSONArray jsonArray = repairCard.RepairQuery();
            out.println(jsonArray.toString());
//            request.setAttribute("answer",js);
//            request.getRequestDispatcher("/index/sda").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        request.getRequestDispatcher("/test.jsp").forward(request,response);
//        response.sendRedirect( request.getContextPath() + "/test.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
