package com.Attendence.My.Controller.Department;

import com.Attendence.My.Model.Entity.Department.DepartmentList;
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
import java.util.ArrayList;

@WebServlet(name = "DepartmentAddServlet",urlPatterns = "/DepartmentAddServlet")
public class DepartmentAddServlet extends HttpServlet {
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

        String DepartmentId=request.getParameter("a");
        String Dname=request.getParameter("b");
        String Dprincipal=request.getParameter("c");
        String Dability= request.getParameter("d");
        String Sdepartment= request.getParameter("e");
        DepartmentList dl = new DepartmentList();
        dl.setDepartmentId(DepartmentId);
        dl.setDname(Dname);
        dl.setDPrincipal(Dprincipal);
        dl.setDability(Dability);
        dl.setSdepartment(Sdepartment);
        Department d= new Department();
        JSONObject json = new JSONObject();

        boolean res = d.InsertDepartment(dl);
        if(res){
            json.put("Res","true");
        }else {
            json.put("Res","false");
        }
        PrintWriter out = response.getWriter();
        out.println(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
