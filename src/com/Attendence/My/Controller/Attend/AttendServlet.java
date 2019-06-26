package com.Attendence.My.Controller.Attend;

import com.Attendence.My.Model.Service.Attend.Attend;
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
import java.util.ArrayList;

@WebServlet(name = "AttendServlet",urlPatterns = "/AttendServlet")
public class AttendServlet extends HttpServlet {
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

        Attend attendService = new Attend();
        try {
            ArrayList<com.Attendence.My.Model.Entity.Attend.Attend> attendMod = attendService.QueryTable();
//            com.Attendence.My.Model.Entity.Attend.Attend []attendMod = attendService.QueryTable();
            JSONArray jsonArr = new JSONArray();
            attendService.DelTable();

            for (int i = 0; i < attendMod.size(); i++) {
                attendService.insertTable(attendMod.get(i));
                for (int j = 0; j < attendMod.get(i).getID().size(); j++) {
                    JSONObject json = new JSONObject();
                    json.put("Id",attendMod.get(i).getID().get(j));
                    json.put("EarlyTime",attendMod.get(i).getEarlyTime().get(j));
                    json.put("LateTime",attendMod.get(i).getLateTime().get(j));
                    json.put("EmpName",attendMod.get(i).getEmpName().get(j));
                    json.put("ClassId",attendMod.get(i).getClassId().get(j));
                    json.put("AttendStatus",attendMod.get(i).getAttendStatus().get(j));
                    jsonArr.add(json);
                }

            }
            PrintWriter out = response.getWriter();
            out.println(jsonArr.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
