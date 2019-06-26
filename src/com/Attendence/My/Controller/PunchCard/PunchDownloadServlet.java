package com.Attendence.My.Controller.PunchCard;

import com.Attendence.My.Model.Entity.Class.ClassUpdate;
import com.Attendence.My.Model.Entity.PunchCard.PunchCard;
import com.Attendence.My.Model.Service.Classes.ClassList;
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

@WebServlet(name = "PunchDownloadServlet", urlPatterns = "/PunchDownloadServlet")
public class PunchDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> colname = new ArrayList<>();
        colname.add("PunchId");
        colname.add("ClassId");
        colname.add("UserName");
        colname.add("PunchDate");
        colname.add("Remarks");
        colname.add("Id");

        com.Attendence.My.Model.Service.PunchCard.PunchCard punch = new com.Attendence.My.Model.Service.PunchCard.PunchCard();

        JSONArray jsonArr = new JSONArray();
        try {
            ArrayList<PunchCard> PunchArr = punch.PunchQuery();

            for (int i = 0; i < PunchArr.size(); i++) {
                JSONObject json = new JSONObject();
                json.put("PunchId",PunchArr.get(i).getPunchId());
                json.put("ClassId",PunchArr.get(i).getClassId());
                json.put("UserName",PunchArr.get(i).getUserName());
                json.put("PunchDate",PunchArr.get(i).getPunchDate());
                json.put("Remarks",PunchArr.get(i).getRemarks());
                json.put("Id",PunchArr.get(i).getID());
                jsonArr.add(json);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        StringBuffer sb = GetExcel.getExcel("Station",colname,jsonArr);
        System.out.println(sb.toString());

        request.getSession().setAttribute("excel", sb.toString());
        response.sendRedirect("http://localhost:8080/unnamed/export.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
