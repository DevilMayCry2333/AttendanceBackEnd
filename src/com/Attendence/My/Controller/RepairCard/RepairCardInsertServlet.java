package com.Attendence.My.Controller.RepairCard;

import com.Attendence.My.Model.Entity.RepairCard.RepairInsert;
import com.Attendence.My.Model.Service.RepairCard.RepairCard;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RepairCardInsertServlet",urlPatterns = "/RepairCardInsertServlet")
public class RepairCardInsertServlet extends HttpServlet {
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

        RepairInsert repairInsert = new RepairInsert();
        repairInsert.setRepairId(request.getParameter("RepairId"));
        repairInsert.setClassID(request.getParameter("ClassId"));
        repairInsert.setUserName(request.getParameter("UserName"));
        repairInsert.setRepairDate(request.getParameter("RepairDate"));
        repairInsert.setReason(request.getParameter("Reason"));
        JSONObject json = new JSONObject();
        RepairCard repairService = new RepairCard();
        try {
            boolean res = repairService.RepairInsert(repairInsert);
            if(res){
                json.put("Res","true");
            }else {
                json.put("Res","false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
