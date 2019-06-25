package com.Attendence.My.Controller.Station;

import com.Attendence.My.Model.Service.Station.Station;
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

@WebServlet(name = "StationUpdateServlet",urlPatterns = "/StationUpdateServlet")
public class StationUpdateServlet extends HttpServlet {
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

        String id= request.getParameter("id");
        String DepartmentId=request.getParameter("a");
        String Dname=request.getParameter("b");
        String Dprincipal=request.getParameter("c");
        String Dability= request.getParameter("d");
        String Sdepartment= request.getParameter("e");


        ArrayList<String> list = new ArrayList<>();
        list.add(id);
        list.add(DepartmentId);
        list.add(Dname);
        list.add(Dprincipal);
        list.add(Dability);
        list.add(Sdepartment);

        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        Station station= new Station();
        try {
            if(station.UpdateSta(list)){
                System.out.println("yes");
                json.put("Res","true");
            }else{
                System.out.println("error");
                json.put("Res","false");
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
