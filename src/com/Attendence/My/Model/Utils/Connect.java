package com.Attendence.My.Model.Utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection("xxxx");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }
}
