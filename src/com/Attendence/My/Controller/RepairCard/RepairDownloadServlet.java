package com.Attendence.My.Controller.RepairCard;

import com.Attendence.My.Model.Entity.PunchCard.PunchCard;
import com.Attendence.My.Model.Entity.RepairCard.RepairCard;
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

@WebServlet(name = "RepairDownloadServlet",urlPatterns = "/RepairDownloadServlet")
public class RepairDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> colname = new ArrayList<>();
        colname.add("RepairId");
        colname.add("ClassId");
        colname.add("UserName");
        colname.add("RepairDate");
        colname.add("Reason");
        colname.add("Id");

        com.Attendence.My.Model.Service.RepairCard.RepairCard repairCard = new com.Attendence.My.Model.Service.RepairCard.RepairCard();


        JSONArray jsonArr = new JSONArray();
        try {
            ArrayList<RepairCard> RepairArr = repairCard.RepairQuery();

            for (int i = 0; i < RepairArr.size(); i++) {
                JSONObject json = new JSONObject();
                json.put("RepairId",RepairArr.get(i).getRepairId());
                json.put("ClassId",RepairArr.get(i).getClassId());
                json.put("UserName",RepairArr.get(i).getUserName());
                json.put("RepairDate",RepairArr.get(i).getRepairDate());
                json.put("Reason",RepairArr.get(i).getReason());
                json.put("Id",RepairArr.get(i).getId());
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
