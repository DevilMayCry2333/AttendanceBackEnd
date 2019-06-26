package com.Attendence.My.Controller.Leave;

import com.Attendence.My.Model.Entity.Leave.Leave;
import com.Attendence.My.Model.Service.Leave.LeaveList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "InsertLeaveServlet",urlPatterns = "/InsertLeaveServlet")
public class InsertLeaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        //允许请求的方法
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Leave leave = new Leave();
        leave.setLeaveId(request.getParameter("LeaveId"));
        leave.setLeaveName(request.getParameter("LeaveName"));
        leave.setBeginDate(request.getParameter("BeginDate"));
        leave.setEndDate(request.getParameter("EndDate"));
        leave.setLeaveReason(request.getParameter("LeaveReason"));

        LeaveList leaveList = new LeaveList();
        try {
            leaveList.LeaveInsert(leave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        response.sendRedirect("http://localhost/AttendanceFrontEnd/index.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
