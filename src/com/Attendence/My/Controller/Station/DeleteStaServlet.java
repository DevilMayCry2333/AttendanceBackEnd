package com.Attendence.My.Controller.Station;

import com.Attendence.My.Model.Service.Station.Station;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteStaServlet",urlPatterns = "/DeleteStaServlet")
public class DeleteStaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean c=false;
        Station station=new Station();
        c=station.DeleteStation();
        if (c==true){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("xxx.jsp");
            requestDispatcher.forward(request,response);

        }
        else {
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("xxx.jsp");
            requestDispatcher.forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}
