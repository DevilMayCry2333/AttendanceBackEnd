package com.Attendence.My.Controller.Station;

import com.Attendence.My.utils.GetExcel;

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

        Map<String, ArrayList> map = new HashMap<>();
        ArrayList<String> IdColData = new ArrayList<>();
        IdColData.add("hello");
        ArrayList<String> JobIdColData = new ArrayList<>();
        JobIdColData.add("hello2");
        ArrayList<String> PnameColData = new ArrayList<>();
        PnameColData.add("hello3");
        ArrayList<String> AdepartmentData = new ArrayList<>();
        AdepartmentData.add("hello4");
        ArrayList<String> Isuperior = new ArrayList<>();
        Isuperior.add("Hello");
        ArrayList<String> JCategory = new ArrayList<>();
        JCategory.add("EEE");

        map.put("Pname", PnameColData);
        map.put("Id", IdColData);
        map.put("Adepartment",AdepartmentData);
        map.put("Isuperior",Isuperior);
        map.put("Jcategory",JCategory);
        map.put("JobId", JobIdColData);



//        StringBuffer sb = GetExcel.getExcel("Station",colname,map);
//        System.out.println(sb.toString());

//        request.getSession().setAttribute("excel", sb.toString());
        response.sendRedirect("http://localhost:8080/unnamed/export.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
