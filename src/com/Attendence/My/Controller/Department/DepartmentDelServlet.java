package com.Attendence.My.Controller.Department;

import com.Attendence.My.Model.Service.Department.Department;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "DepartmentDelServlet",urlPatterns = "/DepartmentDelServlet")
public class DepartmentDelServlet extends HttpServlet {
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

        String id= request.getParameter("id");
        Department dd= new Department();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        try {
//            int result=0;
            if(dd.deleteDep(id)){
                System.out.println("yes");
                json.put("Res","true");
//                PrintWriter out = response.getWriter();
//                result=1;
//                out.write(result);
            }else{
                json.put("Res","false");
                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println(json.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
