package com.Attendence.My.Controller.Attend;

import com.Attendence.My.Model.Service.Attend.Attend;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DownAttendServlet" , urlPatterns = "/DownAttendServlet")
public class DownAttendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> atable=new ArrayList<>();
        atable.add("EmpName");
        atable.add("EarlyTime");
        atable.add("LateTime");
        atable.add("AttendStatus");
        atable.add("ClassId");
        JSONArray jsonArray=new JSONArray();
        Attend a=new Attend();
        try{
            ArrayList<com.Attendence.My.Model.Entity.Attend.Attend> Attend=a.Query();
            JSONObject json=new JSONObject();
            for (int i = 0; i <Attend.size(); i++) {
                for (int j = 0; j < Attend.get(i).getEmpName().size(); j++) {
                    System.out.print(Attend.get(i).getEmpName().get(j));
                    json.put("EmpName",Attend.get(i).getEmpName().get(j));
                    json.put("EarlyTime",Attend.get(i).getEarlyTime().get(j));
                    json.put("LateTime",Attend.get(i).getLateTime().get(j));
                    json.put("AttendStatus",Attend.get(i).getAttendStatus().get(j));
                    json.put("ClassId",Attend.get(i).getClassId().get(j));
                    jsonArray.add(json);
                }

            }
        } catch (SQLException e) {
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
