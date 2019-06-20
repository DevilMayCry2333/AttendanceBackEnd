package com.Attendence.My.Controller.Station;

import com.Attendence.My.Model.Service.Station.Station;
import net.sf.json.JSONArray;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QueryStaServlet",urlPatterns = "/QueryStaServlet")
public class QueryStaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONArray jsonArray=new JSONArray();
        Station station=new Station();
        jsonArray=station.StationQuery();
        request.setAttribute("jsonArr",jsonArray);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("xxx.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
