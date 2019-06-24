package com.Attendence.My.Controller.Classes;

import com.Attendence.My.Model.DAO.Classes.ClassDAO;
import com.Attendence.My.Model.Service.Classes.ClassList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

        String Ccode=request.getParameter("Ccode");
        String Cname=request.getParameter("Cname");
        String EarlyTimeSelect=request.getParameter("EarlyTimeSelect");
        String LateTimeSelect= request.getParameter("LateTimeSelect");
        String desc = request.getParameter("desc");

        ArrayList<String> list = new ArrayList<>();
        list.add(Ccode);
        list.add(Cname);
        list.add(EarlyTimeSelect);
        list.add(LateTimeSelect);

        ClassList s= new ClassList();
        if(s.AddClass(list)){
            System.out.println("yes");
        }else{
            System.out.println("error");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}