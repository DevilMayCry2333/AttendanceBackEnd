package com.Attendence.My.Controller.EmployeeList;

import com.Attendence.My.Model.Service.EmployeeList.Employee;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmployAllDelServlet",urlPatterns = "/EmployAllDelServlet")
public class EmployAllDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        //允许请求的方法
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType("text/javascript");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String [] tearray = request.getParameterValues("DelList");
//        for (int i = 0; i < tearray.length; i++) {
//            System.out.println(tearray[i]);
//        }
        Employee cl = new Employee();
        boolean res=cl.DeleteAllEmp(tearray);
        JSONObject json = new JSONObject();
        if(res){
            json.put("Res","true");
        }else {
            json.put("Res","false");
        }
        out.println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
