package com.Attendence.My.Controller.Department;

import com.Attendence.My.Model.Entity.Department.DepartmentList;
import com.Attendence.My.Model.Entity.Station.StationList;
import com.Attendence.My.Model.Service.Department.Department;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "DepartmentServlet",urlPatterns = "/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        //允许请求的方法
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        JSONArray jsonArray = new JSONArray();
        int page = Integer.parseInt(request.getParameter("page"));//获取前端当前页数
        System.out.println(page);
        //                JS.put("Id",re.getString("Id"));
//                JS.put("DepartmentId",re.getString("DepartmentId"));
//                JS.put("Dname",re.getString("Dname"));
//                JS.put("Dprincipal",re.getString("Dprincipal"));
//                JS.put("Dability",re.getString("Dability"));
//                JS.put("Sdepartment",re.getString("Sdepartment"));
//                JsonArr.add(JS);

        Department department=new Department();
        try {
            ArrayList<DepartmentList> DepartmentList = department.Department(page);
            for (int i = 0; i < DepartmentList.size(); i++) {
                JSONObject json = new JSONObject();
                json.put("Id",DepartmentList.get(i).getId());//获取ID存入json
                json.put("DepartmentId",DepartmentList.get(i).getDepartmentId());
                json.put("Dname",DepartmentList.get(i).getDname());
                json.put("Dprincipal",DepartmentList.get(i).getDPrincipal());
                json.put("Dability",DepartmentList.get(i).getDability());
                json.put("Sdepartment",DepartmentList.get(i).getSdepartment());
                jsonArray.add(json);//json存入jaonArray中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        out.println(jsonArray);//发送jsonArray给前端
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
