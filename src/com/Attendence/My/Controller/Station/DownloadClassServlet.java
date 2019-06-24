package com.Attendence.My.Controller.Station;

import com.Attendence.My.utils.GetExcel;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DownloadClassServlet" , urlPatterns = "/DownloadClassServlet")
public class DownloadClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        StringBuffer sb = GetExcel.getExcel("Station",colname);
        JSONArray jsonArr = new JSONArray();
        JSONObject json = new JSONObject();

        List<String> colname = new ArrayList<>();
        colname.add("Pname");
        colname.add("Id");
        colname.add("Adepartment");
        colname.add("Isuperior");
        colname.add("Jcategory");
        colname.add("JobId");

        json.put("Pname","123");
        json.put("Id","222");
        json.put("Adepartment","333");
        json.put("Isuperior","444");
        json.put("Jcategory","555");
        json.put("JobId","666");
        jsonArr.add(json);


        StringBuffer sb = GetExcel.getExcel("Station",colname,jsonArr);
        System.out.println(sb.toString());

        request.getSession().setAttribute("excel", sb.toString());
        response.sendRedirect("http://localhost:8080/unnamed/export.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
