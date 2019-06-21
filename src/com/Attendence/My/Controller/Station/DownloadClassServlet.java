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
        List<String> colname = new ArrayList<>();
        colname.add("Id");
        colname.add("JobId");
        colname.add("Pname");
        colname.add("Adepartment");
        colname.add("Isuperior");
        colname.add("Jcategory");


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
//        Isuperior.add("")
        ArrayList<String> JCategory = new ArrayList<>();

        map.put("Id", IdColData);
        map.put("JobId", JobIdColData);
        map.put("Pname", PnameColData);
        map.put("Adepartment",AdepartmentData);
        map.put("Isuperior",Isuperior);
        map.put("JCategory",JCategory);

//        StringBuffer sb = GetExcel.getExcel("Station",colname);

//        request.getSession().setAttribute("excel", sb.toString());
        response.sendRedirect(request.getContextPath() + "/export.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
