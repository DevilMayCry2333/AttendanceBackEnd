package com.Attendence.My.Model.Service.PaySalaryList;

import com.Attendence.My.Model.DAO.PaySalary.PaySalary;
import com.Attendence.My.Model.DBUtils.DBUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaySalaryList {
    public JSONArray PaySalayList(){
        JSONObject js= new JSONObject( );
        JSONArray Json=new JSONArray();
        PaySalary paysalary = new PaySalary();

        ResultSet re= null;
        try {
            re = paysalary.PaySalaryQuery();
            while (re.next()){
                js.put("ClassId",re.getString("ClassId"));
                js.put("EmpName",re.getString("EmpName"));
                js.put("Salary",re.getInt("Salary"));
                js.put("BeginTime",re.getString("BeginTime"));
                js.put("EndTime",re.getString("EndTime"));
                Json.add(js);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Json;
    }
}
