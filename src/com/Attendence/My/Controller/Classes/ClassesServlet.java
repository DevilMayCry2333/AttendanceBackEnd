package com.Attendence.My.Controller.Classes;

import com.Attendence.My.Model.Entity.Class.ClassUpdate;
import com.Attendence.My.Model.Service.Classes.ClassList;
import net.sf.json.JSONArray;
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

@WebServlet(name = "ClassesServlet",urlPatterns = "/ClassesServlet")
public class ClassesServlet extends HttpServlet {
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


        ClassList c=new ClassList();
        JSONArray jsonArray = new JSONArray();
        ArrayList<ClassUpdate> ClassUpdate = null;
        try {
            ClassUpdate = c.ClassList();
            for (int i = 0; i < ClassUpdate.size(); i++) {
                JSONObject json = new JSONObject();
                json.put("Id",ClassUpdate.get(i).getId());
                json.put("ClassId",ClassUpdate.get(i).getClassId());
                json.put("Cname",ClassUpdate.get(i).getCname());
                json.put("Mtime",ClassUpdate.get(i).getMtime());
                json.put("Atime",ClassUpdate.get(i).getAtime());
                jsonArray.add(json);
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
