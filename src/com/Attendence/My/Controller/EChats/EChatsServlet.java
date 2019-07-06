package com.Attendence.My.Controller.EChats;

import com.Attendence.My.Model.Entity.PaySalary.PaySalary;
import com.Attendence.My.Model.Service.PaySalaryList.PaySalaryList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "EChatsServlet" , urlPatterns = "/EChatsServlet")
public class EChatsServlet extends HttpServlet {
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

        PaySalaryList pay = new PaySalaryList();
        ArrayList<PaySalary> arrPay = pay.PaySalayList();
        JSONObject yLabel = new JSONObject();

        JSONObject data = new JSONObject();
        ArrayList<String> yLabelData = new ArrayList<>();

        JSONObject all = new JSONObject();
        yLabel.put("type","category");
        JSONObject show = new JSONObject();
        show.put("show","false");

        yLabel.put("axisLine",show);
        yLabel.put("axisLabel",show);
        yLabel.put("axisTick",show);
        yLabel.put("splitLine",show);

        JSONArray dataSerData = new JSONArray();

        for (int i = 0; i < arrPay.size(); i++) {
            JSONObject tmp = new JSONObject();
            yLabelData.add(arrPay.get(i).getEmpName());//添加EmpName
            tmp.put("value",arrPay.get(i).getSalary());//获取Salary
            tmp.put("label","labelRight");
            dataSerData.add(tmp);
        }
        yLabel.put("data",yLabelData);
        JSONObject dataSer = new JSONObject();
        dataSer.put("name","薪水");
        dataSer.put("type","bar");
        dataSer.put("stack","总量");
        JSONObject normal = new JSONObject();
        normal.put("show","true");
        normal.put("formatter","{b}");
        dataSer.put("label",normal);
        dataSer.put("data",dataSerData);

        data.put("yAxis",yLabel);
        JSONArray series = new JSONArray();
        series.add(dataSer);

        data.put("series",series);


        PrintWriter out = response.getWriter();
        out.println(data);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
