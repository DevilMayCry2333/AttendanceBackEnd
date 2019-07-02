package com.Attendence.My.Controller.Login;

import com.Attendence.My.Model.Service.Login.Login;
import com.Attendence.My.Model.Utils.EncryBiz;
import com.Attendence.My.Model.Utils.Url;
import net.sf.json.JSONObject;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@javax.servlet.annotation.WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        //允许请求的方法
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        //请求参数编码设置
        request.setCharacterEncoding("UTF-8");

        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        response.setContentType("text/javascript;charset=utf-8");

        String UserName=request.getParameter("username");
        String PassWord=request.getParameter("password");
        System.out.println(UserName);

        JSONObject json = new JSONObject();
        Login lo = new Login();
//        String a = "root";
//        String b = "123";
//        String c ="49c032802743b23f39b1304eb9414951cf0ad21389290f22";
//        boolean res = EncryBiz.getSaltverifyMd5AndSha(b,c);
//        System.out.println(res);

        try {
            String rs = lo.loginquery(UserName,PassWord);

            if (rs.equals("登录成功")){
                json.put("Res","true");
                json.put("Data",rs);
            }
            else {
                json.put("Res","false");
                json.put("Data",rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println(json);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
