package com.Attendence.My.Model.DAO.EmployeeList;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Employee.EmployeeInsert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeList {
    public ResultSet EmployQuery() throws SQLException {
        String str="SELECT * FROM employ";
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        ResultSet re=null;
        try {
            Statement st = con.createStatement();
            re = st.executeQuery(str);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return re;
    }

    public boolean InsertEmployee(EmployeeInsert empInsert){
        DBUtils db=new DBUtils();
        Connection conn=db.getConnecton();
        try {
            Statement st = conn.createStatement();
            String sql =
                    "INSERT INTO Employ (EmployId,UserName,Nation,IDNumber,salary,Phone,EmeContact,Job,Describle) " +
                            "Values" +
                "('" + empInsert.getUserCode() +
                            "','" + empInsert.getUserName() +
                    "','" + empInsert.getNation() + "','" + empInsert.getIdCard() + "','" + empInsert.getSalary() +
                    "','" + empInsert.getTel() + "','" + empInsert.getEmergyContact() + "','" +empInsert.getStation()
                    + "','" + empInsert.getDesc() + "')";
            System.out.println(sql);
            int result = st.executeUpdate(sql);

            if (result>0){
                return true;
            }
//            System.out.println(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
