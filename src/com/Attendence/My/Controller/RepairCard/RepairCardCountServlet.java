package com.Attendence.My.Controller.RepairCard;

import com.Attendence.My.Model.Service.RepairCard.RepairCard;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RepairCardCountServlet" , urlPatterns = "/RepairCardCountServlet")
public class RepairCardCountServlet extends HttpServlet {
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

        RepairCard repairCard = new RepairCard();
        JSONObject json = new JSONObject();
        json.put("Count", repairCard.QueryAll());
        PrintWriter pl = response.getWriter();
        pl.println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
