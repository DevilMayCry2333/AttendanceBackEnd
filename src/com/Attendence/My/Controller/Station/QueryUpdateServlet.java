package com.Attendence.My.Controller.Station;

import com.Attendence.My.Model.Entity.Station.StationList;
import com.Attendence.My.Model.Service.Station.Station;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QueryUpdateServlet",urlPatterns = "/QueryUpdateServlet")
public class QueryUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        //允许请求的方法
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("text/javascript");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.print(request.getParameter("id"));
        Station station = new Station();
        JSONObject json = new JSONObject();
        StationList stationList = station.updateQuery(Integer.parseInt(request.getParameter("id")));
        json.put("JobId",stationList.getJobId());
        json.put("Jcategory",stationList.getJcategory());
        json.put("Isuperior",stationList.getIsuperior());
        json.put("Adepartment",stationList.getAdepartment());
        json.put("Pname",stationList.getPname());
        PrintWriter out = response.getWriter();
        out.println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
