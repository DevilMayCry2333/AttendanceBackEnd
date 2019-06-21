<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="application/msexcel"%>
<%
    response.setContentType("application/msexcel;charset=UTF-8");
    response.setHeader("Content-disposition", "attachment; filename=test.xls");
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
