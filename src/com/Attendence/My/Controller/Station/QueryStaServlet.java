package com.Attendence.My.Controller.Station;

import com.Attendence.My.Model.Entity.Station.StationList;
import com.Attendence.My.Model.Service.Station.Station;
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

@WebServlet(name = "QueryStaServlet",urlPatterns = "/QueryStaServlet")
public class QueryStaServlet extends HttpServlet {
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

        Station station = new Station();

        ArrayList<StationList> stationList = null;
        JSONArray jsonArr = new JSONArray();
        try {
            stationList = station.StationQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < stationList.size(); i++) {
                JSONObject json = new JSONObject();
                json.put("Id",stationList.get(i).getId());
                json.put("JobId",stationList.get(i).getJobId());
                json.put("Pname",stationList.get(i).getPname());
                json.put("Adepartment",stationList.get(i).getAdepartment());
                json.put("Isuperior",stationList.get(i).getIsuperior());
                json.put("Jcategory",stationList.get(i).getJcategory());
                jsonArr.add(json);
        }
        PrintWriter out = response.getWriter();
        out.println(jsonArr);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
