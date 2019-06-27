package com.Attendence.My.Controller.EmployeeList;

import com.Attendence.My.Model.Entity.Employee.EmployeeList;
import com.Attendence.My.Model.Service.EmployeeList.Employee;
import com.Attendence.My.utils.GetExcel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DownloadEmployServlet")
public class DownloadEmployServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> etable=new ArrayList<>();
        etable.add("EmployId");
        etable.add("UserName");
        etable.add("Age");
        etable.add("Nation");
        etable.add("IDCard");
        etable.add("salary");
        etable.add("Phone");
        etable.add("EmeContact");
        etable.add("Job");
        etable.add("Des");
        etable.add("Gender");
        Employee employee=new Employee();
        JSONArray jsonArray=new JSONArray();
        try{
            ArrayList<EmployeeList> EmployeeList =employee.Query();
            for (int i = 0; i <EmployeeList.size() ; i++) {
                JSONObject json = new JSONObject();
                json.put("EmployId",EmployeeList.get(i).getId());
                json.put("UserName",EmployeeList.get(i).getUserName());
                json.put("Age",EmployeeList.get(i).getAge());
                json.put("Nation",EmployeeList.get(i).getNation());
                json.put("IdCard",EmployeeList.get(i).getIdCard());
                json.put("salary",EmployeeList.get(i).getSalary());
                json.put("Phone",EmployeeList.get(i).getTel());
                json.put("EmeContact",EmployeeList.get(i).getEmergyContact());
                json.put("Job",EmployeeList.get(i).getStation());
                json.put("Des",EmployeeList.get(i).getDesc());
                json.put("Gender",EmployeeList.get(i).getGender());
                jsonArray.add(json);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        StringBuffer sb = GetExcel.getExcel("Station",etable,jsonArray);
        System.out.println(sb.toString());

        request.getSession().setAttribute("excel", sb.toString());
        response.sendRedirect("http://localhost:8080/AttendanceBackEnd_war_exploded/export.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
