package com.Attendence.My.Controller.PunchCard;

import com.Attendence.My.Model.Entity.PunchCard.PunchCardInsert;
import com.Attendence.My.Model.Service.PunchCard.PunchCard;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "PunchInsertServlet",urlPatterns = "/PunchInsertServlet")
public class PunchInsertServlet extends HttpServlet {
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

        PunchCardInsert punchCardInsert = new PunchCardInsert();
        punchCardInsert.setPunchId(request.getParameter("PunchId"));
        punchCardInsert.setClassId(request.getParameter("ClassId"));
        punchCardInsert.setUserName(request.getParameter("UserName"));
        punchCardInsert.setPunchDate(request.getParameter("PunchDate"));
        punchCardInsert.setRemarks(request.getParameter("Remarks"));
        JSONObject json = new JSONObject();
        PunchCard punchService = new PunchCard();
        PrintWriter out = response.getWriter();
        try {
            boolean res = punchService.PunchInsert(punchCardInsert);
            if(res){
                json.put("Res","true");
            }else {
                json.put("Res","false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
