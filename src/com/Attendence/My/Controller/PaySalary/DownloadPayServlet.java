package com.Attendence.My.Controller.PaySalary;

import com.Attendence.My.Model.Entity.PaySalary.PaySalary;
import com.Attendence.My.Model.Service.PaySalaryList.PaySalaryList;
import com.Attendence.My.Model.Utils.Url;
import com.Attendence.My.utils.GetExcel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DownloadPayServlet", urlPatterns = "/DownloadPayServlet")
public class DownloadPayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> atable=new ArrayList<>();
        atable.add("PSId");
        atable.add("PSName");
        atable.add("Salary");
        atable.add("BeginDate");
        atable.add("EndDate");
        JSONArray jsonArray=new JSONArray();
        PaySalaryList paySalaryList=new PaySalaryList();
        try{
            ArrayList<PaySalary> PaySalary=paySalaryList.Query();
            JSONObject json=new JSONObject();
            for (int i = 0; i <PaySalary.size() ; i++) {
                json.put("PSId",PaySalary.get(i).getClassId());
                json.put("PSName",PaySalary.get(i).getEmpName());
                json.put("Salary",PaySalary.get(i).getSalary());
                json.put("BeginDate",PaySalary.get(i).getBeginTime());
                json.put("EndDate",PaySalary.get(i).getEndTime());
                jsonArray.add(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuffer sb = GetExcel.getExcel("Station",atable,jsonArray);
        System.out.println(sb.toString());

        request.getSession().setAttribute("excel", sb.toString());
        response.sendRedirect(Url.Url + "export.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
