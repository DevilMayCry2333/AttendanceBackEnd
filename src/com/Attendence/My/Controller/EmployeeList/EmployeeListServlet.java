package com.Attendence.My.Controller.EmployeeList;

import com.Attendence.My.Model.Entity.Employee.EmployeeList;
import com.Attendence.My.Model.Service.EmployeeList.Employee;
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

@WebServlet(name = "EmployeeListServlet",urlPatterns = "/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet {
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
        int page = Integer.parseInt(request.getParameter("page"));

//        int  page=1;
        //int page=Integer.valueOf(pages).intValue();
        Employee employeeList=new Employee();
        try {
            ArrayList<EmployeeList> arrEmp = employeeList.EmployeeList(page);
            for (int i = 0; i < arrEmp.size(); i++) {
                JSONObject js = new JSONObject();
                    js.put("Id",arrEmp.get(i).getId());
                    js.put("EmployId",arrEmp.get(i).getUserCode());
                    js.put("UserName",arrEmp.get(i).getUserName());
                    js.put("Gender",arrEmp.get(i).getGender());
                    js.put("Age",arrEmp.get(i).getAge());
                    js.put("Nation",arrEmp.get(i).getNation());
                    js.put("Job",arrEmp.get(i).getStation());
                    jsonArray.add(js);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println(jsonArray);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
