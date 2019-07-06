package com.Attendence.My.Controller.Classes;

import com.Attendence.My.Model.DAO.Classes.ClassDAO;
import com.Attendence.My.Model.Service.Classes.ClassList;
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

@WebServlet(name = "AddClassServlet",urlPatterns = "/AddClassServlet")
public class AddClassServlet extends HttpServlet {
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

        String Ccode=request.getParameter("Ccode");//前端获取数据
        String Cname=request.getParameter("Cname");
        String EarlyTimeSelect=request.getParameter("EarlyTimeSelect");
        String LateTimeSelect= request.getParameter("LateTimeSelect");
        String desc = request.getParameter("desc");

        ArrayList<String> list = new ArrayList<>();
        list.add(Ccode);//添加数据到list
        list.add(Cname);
        list.add(EarlyTimeSelect);
        list.add(LateTimeSelect);

        ClassList s= new ClassList();
        JSONObject json = new JSONObject();
        PrintWriter out = response.getWriter();
        try {
            if(s.AddClass(list)){
                json.put("Res","true");//判断是否添加成功
                System.out.println("yes");
            }else{
                json.put("Res","false");
                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
