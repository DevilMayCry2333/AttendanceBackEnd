package com.Attendence.My.Controller.EmployeeList;

import com.Attendence.My.Model.Entity.Employee.EmployeeInsert;
import com.Attendence.My.Model.Service.EmployeeList.Employee;
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

@WebServlet(name = "EmployeeAddServlet",urlPatterns = "/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
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

        String EmployId=request.getParameter("a");//获取ID
        String UserName=request.getParameter("b");
        String Age=request.getParameter("c");
        String Nation= request.getParameter("d");
        String IDnumber= request.getParameter("e");
        String Salary=request.getParameter("f");
        String Phone=request.getParameter("g");
        String EmeContact=request.getParameter("h");
        String Job = request.getParameter("i");
        String Desc = request.getParameter("j");
        String sex = request.getParameter("k");


        EmployeeInsert EmpInsert = new EmployeeInsert();
        EmpInsert.setUserCode(EmployId);//发送更新后的EmloyId
        EmpInsert.setUserName(UserName);
        EmpInsert.setNation(Nation);
        EmpInsert.setIdCard(IDnumber);
        EmpInsert.setSalary(Salary);
        EmpInsert.setTel(Phone);
        EmpInsert.setEmergyContact(EmeContact);
        EmpInsert.setStation(Job);
        EmpInsert.setDesc(Desc);
        EmpInsert.setGender(sex);
        EmpInsert.setAge(Age);
        EmpInsert.setClassId("2");


//        ArrayList<String> list = new ArrayList<>();
//        list.add(EmployId);
//        list.add(UserName);
//        list.add(Age);
//        list.add(Nation);
//        list.add(IDnumber);
//        list.add(Salary);
//        list.add(Phone);
//        list.add(EmeContact);
//        list.add(Job);
//        list.add(Desc);
//        list.add(sex);

        Employee s= new Employee();
        JSONObject json = new JSONObject();

        try {
            if(s.AddEmp(EmpInsert)){
                System.out.println("yes");
                json.put("Res","true");//判断插入的结果并放入json
            }else{
                System.out.println("error");
                json.put("Res","false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println(json);//向前端返回json

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
