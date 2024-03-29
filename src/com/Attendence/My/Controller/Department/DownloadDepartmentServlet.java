package com.Attendence.My.Controller.Department;

import com.Attendence.My.Model.Entity.Department.DepartmentList;
import com.Attendence.My.Model.Service.Department.Department;
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

@WebServlet(name = "DownloadDepartmentServlet" , urlPatterns = "/DownloadDepartmentServlet")
public class DownloadDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> atable=new ArrayList<>();
        atable.add("DepartmentId");//创建列表
        atable.add("Dname");
        atable.add("Dprincipal");
        atable.add("Dability");
        atable.add("Sdepartment");
        Department department=new Department();
        JSONArray jsonArray=new JSONArray();
        try{
            ArrayList<DepartmentList> DepartmentList=department.Query();
            JSONObject json=new JSONObject();
            for (int i = 0; i <DepartmentList.size() ; i++) {
                json.put("DepartmentId",DepartmentList.get(i).getDepartmentId());//获得ID并放入json中
                json.put("Dname",DepartmentList.get(i).getDname());
                json.put("Dprincipal",DepartmentList.get(i).getDPrincipal());
                json.put("Dability",DepartmentList.get(i).getDability());
                json.put("Sdepartment",DepartmentList.get(i).getSdepartment());
                jsonArray.add(json);//json放入json数组
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        StringBuffer sb = GetExcel.getExcel("Station",atable,jsonArray);//生成Excel
        System.out.println(sb.toString());

        request.getSession().setAttribute("excel", sb.toString());//以字符串形式输出
        response.sendRedirect(Url.Url + "export.jsp");//跳转

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
