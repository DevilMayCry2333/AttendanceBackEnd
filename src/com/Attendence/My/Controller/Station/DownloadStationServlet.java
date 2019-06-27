package com.Attendence.My.Controller.Station;

import com.Attendence.My.Model.Entity.Station.StationList;
import com.Attendence.My.Model.Service.Station.Station;
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

@WebServlet(name = "DownloadStationServlet", urlPatterns = "/DownloadStationServlet")
public class DownloadStationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> atable=new ArrayList<>();
        atable.add("JobId");
        atable.add("Pname");
        atable.add("Adepartment");
        atable.add("Isuperior");
        atable.add("Jcategory");
        Station station=new Station();
        JSONArray jsonArray=new JSONArray();
        try{
            ArrayList<StationList> StationList =station.Query();
            for (int i = 0; i <StationList.size() ; i++) {
                JSONObject json = new JSONObject();
                json.put("JobId",StationList.get(i).getJobId());
                json.put("Pname",StationList.get(i).getPname());
                json.put("Adepartment",StationList.get(i).getAdepartment());
                json.put("Isuperior",StationList.get(i).getIsuperior());
                json.put("Jcategory",StationList.get(i).getJcategory());
                jsonArray.add(json);
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
