package com.Attendence.My.Controller.PaySalary;

import com.Attendence.My.Model.Entity.PaySalary.PaySalary;
import com.Attendence.My.Model.Service.PaySalaryList.PaySalaryList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "PaySalaryServlet",urlPatterns = "/PaySalaryServlet")
public class PaySalaryServlet extends HttpServlet {
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

        JSONArray jsonArray = new JSONArray();

        PaySalaryList station=new PaySalaryList();
        ArrayList<PaySalary> arrpay = station.PaySalayList();
        JSONObject json = new JSONObject();

        for (int i = 0; i < arrpay.size(); i++) {
            json.put("ClassId",arrpay.get(i).getClassId());
            json.put("EmpName",arrpay.get(i).getEmpName());
            json.put("Salary",arrpay.get(i).getSalary());
            json.put("BeginTime",arrpay.get(i).getBeginTime());
            json.put("EndTime",arrpay.get(i).getEndTime());
            jsonArray.add(json);
            System.out.println(json);

        }
        PrintWriter out = response.getWriter();
        out.println(jsonArray);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
