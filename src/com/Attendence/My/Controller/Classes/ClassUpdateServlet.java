package com.Attendence.My.Controller.Classes;

import com.Attendence.My.Model.Entity.Class.ClassUpdate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClassUpdateServlet")
public class ClassUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassUpdate classUpdate=new ClassUpdate();
        classUpdate.setClassId(request.getParameter("ClassId"));
        classUpdate.setCname(request.getParameter("Cname"));
        classUpdate.setMtime(request.getParameter("Mtime"));
        classUpdate.setAtime(request.getParameter("Atime"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
