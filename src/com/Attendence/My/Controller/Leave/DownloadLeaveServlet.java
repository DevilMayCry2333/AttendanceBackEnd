package com.Attendence.My.Controller.Leave;

import com.Attendence.My.Model.Entity.Leave.Leave;
import com.Attendence.My.Model.Service.Leave.LeaveList;
import com.Attendence.My.utils.GetExcel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DownloadLeaveServlet")
public class DownloadLeaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> atable=new ArrayList<>();
        atable.add("LeaveId");
        atable.add("LeaveName");
        atable.add("BeginDate");
        atable.add("EndDate");
        atable.add("LeaveReason");
        JSONArray jsonArray=new JSONArray();
        LeaveList leaveList=new LeaveList();
        try{
            ArrayList<Leave> Leave=leaveList.Query();
            JSONObject json=new JSONObject();
            for (int i = 0; i <Leave.size() ; i++) {
                json.put("LeaveId",Leave.get(i).getLeaveId());
                json.put("LeaveName",Leave.get(i).getLeaveName());
                json.put("BeginDate",Leave.get(i).getBeginDate());
                json.put("EndDate",Leave.get(i).getEndDate());
                json.put("LeaveReason",Leave.get(i).getLeaveReason());
                jsonArray.add(json);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        StringBuffer sb = GetExcel.getExcel("Station",atable,jsonArray);
        System.out.println(sb.toString());

        request.getSession().setAttribute("excel", sb.toString());
        response.sendRedirect("http://localhost:8080/AttendanceBackEnd_war_exploded/export.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
