package com.Attendence.My.Model.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/attendence?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user="root";
    String password="123456";
    Connection conn=null;
    public Connection getConnecton(){
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  conn;
    }
}
