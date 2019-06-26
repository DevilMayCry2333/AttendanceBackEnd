package com.Attendence.My.Controller.PunchCard;

import com.Attendence.My.Model.Service.PunchCard.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "PunchCardServlet",urlPatterns = "/PunchCardServlet")
public class PunchCardServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        //允许请求的方法
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("text/javascript");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        //                json.put("PunchId",rs.getString("PunchId"));
//            json.put("Scode",rs.getString("ClassId"));
//            json.put("UserName",rs.getString("UserName"));
//            json.put("PunchDate",rs.getString("PunchDate"));
//            json.put("Remarks",rs.getString("Remarks"));
//            jsonArray.add(json);

        PunchCard pc = new PunchCard();
        JSONArray js = new JSONArray();
        try {
            ArrayList<com.Attendence.My.Model.Entity.PunchCard.PunchCard> PunchArr = pc.PunchQuery();
            for (int i = 0; i < PunchArr.size(); i++) {
                JSONObject json = new JSONObject();
                json.put("Id",PunchArr.get(i).getID());
                json.put("PunchId",PunchArr.get(i).getPunchId());
                json.put("ClassId",PunchArr.get(i).getClassId());
                json.put("UserName",PunchArr.get(i).getUserName());
                json.put("PunchDate",PunchArr.get(i).getPunchDate());
                json.put("Remarks",PunchArr.get(i).getRemarks());
                js.add(json);
                System.out.println(json);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        out.println(js);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
