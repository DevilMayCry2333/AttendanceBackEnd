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
                js.put("PSId",re.getString("PSId"));
                js.put("PSName",re.getString("PSName"));
                js.put("Salary",re.getBigDecimal("Salary"));
                js.put("BeginDate",re.getString("BeginDate"));
                js.put("EndDate",re.getString("EndDate"));
                Json.add(js);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Json;
    }
}
