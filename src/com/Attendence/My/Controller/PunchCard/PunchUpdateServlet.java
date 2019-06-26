package com.Attendence.My.Controller.PunchCard;

import com.Attendence.My.Model.Entity.PunchCard.PunchCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PunchUpdateServlet" ,urlPatterns = "/PunchUpdateServlet")
public class PunchUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

//        PunchCard punchCard = new PunchCard();
        com.Attendence.My.Model.Service.PunchCard.PunchCard punchCard = new com.Attendence.My.Model.Service.PunchCard.PunchCard();

        PunchCard punchCardModel = new PunchCard();
//        punchCardModel.setSCode(request.getParameter("Scode"));
//        punchCardModel.setID(Integer.parseInt(request.getParameter("Id")));
//        punchCardModel.setPunchDate(request.getParameter("PunchDate"));
//        punchCardModel.setPunchId(request.getParameter("PunchId"));
//        punchCardModel.setRemarks(request.getParameter("Remarks"));
        punchCardModel.setClassId("123");
        punchCardModel.setID(1);
        punchCardModel.setPunchDate("2019-06-24");
        punchCardModel.setPunchId("666");
        punchCardModel.setRemarks("333");


        if(punchCard.PunchUpdate(punchCardModel)!=0){  //执行更改
            PrintWriter out = response.getWriter();
            out.println("修改成功");
        }
        else{
            PrintWriter out = response.getWriter();
            out.println("修改失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
