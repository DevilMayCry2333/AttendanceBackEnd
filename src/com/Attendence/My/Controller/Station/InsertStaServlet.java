package com.Attendence.My.Controller.Station;

import com.Attendence.My.Model.Service.Station.Station;
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

@WebServlet(name = "InsertStaServlet",urlPatterns = "/InsertStaServlet")
public class InsertStaServlet extends HttpServlet {
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

        String DepartmentId=request.getParameter("a");
        String Dname=request.getParameter("b");
        String Dprincipal=request.getParameter("c");
        String Dability= request.getParameter("d");
        String Sdepartment= request.getParameter("e");


        ArrayList<String> list = new ArrayList<>();
        list.add(DepartmentId);
        list.add(Dname);
        list.add(Dprincipal);
        list.add(Dability);
        list.add(Sdepartment);
        JSONObject json = new JSONObject();


        Station d= new Station();
        try {
            if(d.AddSta(list)){
                json.put("Res","true");
                System.out.println("yes");
            }else{
                json.put("Res","false");
                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
