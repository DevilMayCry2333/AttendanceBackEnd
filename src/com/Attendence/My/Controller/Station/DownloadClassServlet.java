package com.Attendence.My.Controller.Station;

import com.Attendence.My.Model.Service.Classes.ClassList;
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

        List<String> colname = new ArrayList<>();
        colname.add("Id");
        colname.add("ClassId");
        colname.add("Cname");
        colname.add("Mtime");
        colname.add("Atime");

        ClassList Cl = new ClassList();
        JSONArray jsonArr = Cl.ClassList();
        StringBuffer sb = GetExcel.getExcel("Station",colname,jsonArr);
        System.out.println(sb.toString());

        request.getSession().setAttribute("excel", sb.toString());
        response.sendRedirect("http://localhost:8080/unnamed/export.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
