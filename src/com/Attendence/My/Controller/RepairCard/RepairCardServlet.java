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
import java.util.ArrayList;

@WebServlet(name = "RepairCardServlet",urlPatterns = "/RepairCardServlet")
public class RepairCardServlet extends HttpServlet {
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
        JSONArray jsonArray = new JSONArray();
        RepairCard repairCard = new RepairCard();
        try {
            ArrayList<com.Attendence.My.Model.Entity.RepairCard.RepairCard> arrRepair = repairCard.RepairQuery();
            for (int i = 0; i < arrRepair.size(); i++) {
                JSONObject json = new JSONObject();
                json.put("RepairId",arrRepair.get(i).getRepairId());
                json.put("ClassId",arrRepair.get(i).getClassId());
                json.put("UserName",arrRepair.get(i).getUserName());
                json.put("RepairDate",arrRepair.get(i).getRepairId());
                json.put("Reason",arrRepair.get(i).getReason());
                System.out.println(json);
                jsonArray.add(json);
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
