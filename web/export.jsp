<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="application/msexcel"%>
<%
    response.setContentType("application/msexcel;charset=UTF-8");
    response.setHeader("Content-disposition", "attachment; filename=test.xls");
    response.setHeader("Access-Control-Allow-Origin","*");
    //允许请求的方法
    response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setContentType("text/javascript");
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

%>
<html>
    <head>
        <title>Excel</title>
    </head>
    <body>
        <%
            String str = new String(session.getAttribute("excel").toString());
            out.print(str);
        %>
    </body>
</html>
