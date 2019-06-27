package com.Attendence.My.Controller.Leave;

import com.Attendence.My.Model.Entity.Leave.Leave;
import com.Attendence.My.Model.Service.Leave.LeaveList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "LeaveServlet",urlPatterns = "/LeaveServlet")
public class LeaveServlet extends HttpServlet {
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

        int page = Integer.parseInt(request.getParameter("page"));
        JSONArray jsonArray = new JSONArray();
        LeaveList leave=new LeaveList();

        ArrayList<Leave> leaveArr = null;
        try {
            leaveArr = leave.LeaveList(page);
            for (int i = 0; i < leaveArr.size(); i++) {
                JSONObject js = new JSONObject();
                js.put("LeaveId",leaveArr.get(i).getLeaveId());
                js.put("LeaveName",leaveArr.get(i).getLeaveName());
                js.put("BeginDate",leaveArr.get(i).getBeginDate());
                js.put("EndDate",leaveArr.get(i).getEndDate());
                js.put("LeaveReason",leaveArr.get(i).getLeaveReason());
                jsonArray.add(js);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        out.println(jsonArray);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
