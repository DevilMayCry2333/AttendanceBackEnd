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

@WebServlet(name = "ClassDeleteServlet" ,urlPatterns = "/ClassDeleteServlet")
public class ClassDeleteServlet extends HttpServlet {
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
        String [] tearray = request.getParameterValues("DelList");//获得前端传来的数组
//        for (int i = 0; i < tearray.length; i++) {
//            System.out.println(tearray[i]);
//        }
        ClassList cl = new ClassList();
        boolean res = cl.DeleteClass(tearray);
        JSONObject json = new JSONObject();
        if(res){
            json.put("Res","true");//判断是否删除成功
        }else {
            json.put("Res","false");
        }
        out.println(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
