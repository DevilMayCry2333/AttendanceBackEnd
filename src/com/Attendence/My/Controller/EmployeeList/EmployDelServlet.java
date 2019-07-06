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
import java.sql.SQLException;

@WebServlet(name = "EmployDelServlet",urlPatterns = "/EmployDelServlet")
public class EmployDelServlet extends HttpServlet {
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

        String id= request.getParameter("id");//获取前端的ID
        Employee ed= new Employee();
        JSONObject json = new JSONObject();
        PrintWriter out = response.getWriter();

        try {
            if(ed.deleteEmp(id)){
//                System.out.println("yes");
                json.put("Res","true");//判断是否删除成功如果成功则返回结果true
            }else{
                json.put("Res","false");
//                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println(json);//向前端发送json的结果
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
