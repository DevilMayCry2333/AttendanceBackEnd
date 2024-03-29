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

@WebServlet(name = "DepartmentUpdateServlet",urlPatterns = "/DepartmentUpdateServlet")
public class DepartmentUpdateServlet extends HttpServlet {
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

        String id= request.getParameter("id");//获取前端的id
        String DepartmentId=request.getParameter("a");
        String Dname=request.getParameter("b");
        String Dprincipal=request.getParameter("c");
        String Dability= request.getParameter("d");
        String Sdepartment= request.getParameter("e");

        DepartmentList dl = new DepartmentList();
        dl.setId(Integer.parseInt(id));//发送id
        dl.setDepartmentId(DepartmentId);
        dl.setDname(Dname);
        dl.setDPrincipal(Dprincipal);
        dl.setDability(Dability);
        dl.setSdepartment(Sdepartment);

        Department du= new Department();
        JSONObject json = new JSONObject();
        try {
            boolean res = du.UpdateDep(dl);
            if(res){
                json.put("Res","true");
            }else {
                json.put("Res","false");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println(json);//判断是否更新成功并把结果发送给前端

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
