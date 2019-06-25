package com.Attendence.My.Controller.Classes;

import com.Attendence.My.Model.Service.Classes.ClassList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ClassInsertServlet",urlPatterns = "/ClassInsertServlet")
public class ClassInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean c=false;
        ClassList tt=new ClassList();
        ArrayList<String> al = new ArrayList<>();
        al.add(request.getParameter("ClassId"));
        al.add(request.getParameter("Cname"));
        al.add(request.getParameter("Mtime"));
        al.add(request.getParameter("Atime"));
        al.add(request.getParameter("Remark"));
        try {
            c=tt.InsertClass(al);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (c==true){
            response.sendRedirect("xx");

        }
        else {
            response.sendRedirect("xx");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
