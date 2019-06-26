package com.Attendence.My.Controller.RepairCard;

import com.Attendence.My.Model.Service.RepairCard.RepairCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RepairUpdateServlet",urlPatterns = "/RepairUpdateServlet")
public class RepairUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        RepairCard repairCard = new RepairCard();
        com.Attendence.My.Model.Entity.RepairCard.RepairCard  repairModel= new com.Attendence.My.Model.Entity.RepairCard.RepairCard();
//        repairModel.setId(Integer.parseInt(request.getParameter("id")));
//        repairModel.setSCode(request.getParameter("Scode"));
//        repairModel.setUserName(request.getParameter("UserName"));
//        repairModel.setReason(request.getParameter("Reason"));
//        repairModel.setRepairDate(request.getParameter("Date"));
//        repairModel.setRepairId(request.getParameter("RepairId"));
       repairModel.setId(1);
        repairModel.setClassId("123");
        repairModel.setUserName("123");
        repairModel.setReason("123");
        repairModel.setRepairDate("1111-11-11");
        repairModel.setRepairId("123");



        if(repairCard.RepairUpdate(repairModel)!=0){  //执行更改
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
