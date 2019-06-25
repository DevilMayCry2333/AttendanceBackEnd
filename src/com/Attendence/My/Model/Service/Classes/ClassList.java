package com.Attendence.My.Model.Service.Classes;

import com.Attendence.My.Model.DAO.Classes.ClassDAO;
import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Class.ClassUpdate;
import com.Attendence.My.Model.Entity.Employee.EmployeeUpdate;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClassList {
    public JSONArray ClassList(){
        JSONObject js= new JSONObject( );
        JSONArray Json=new JSONArray();
        ClassDAO classDAO = new ClassDAO();
        ResultSet re1= null;
        try {
            re1 = classDAO.ClassQuery();
            while (re1.next()){
                js.put("Id",re1.getString("Id"));
                js.put("ClassId",re1.getString("ClassId"));
                js.put("Cname",re1.getString("Cname"));
                js.put("Mtime",re1.getString("Mtime"));
                js.put("Atime",re1.getString("Atime"));
               Json.add(js);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Json;
    }

    public boolean AddClass(ArrayList<String> list) throws SQLException {
        ClassDAO dao = new ClassDAO();
        boolean re= dao.InsertClass(list);
        if (re){
            return true;
        }else {
            return false;
        }


    }

    public boolean DeleteClass(String []del){
        ClassDAO cd = new ClassDAO();
        cd.DeleteClass(del);
        return true;

    }
    public boolean InsertClass(ArrayList<String> al){
        ClassDAO cd=new ClassDAO();
        boolean cc=false;
        try {
            if(cc==cd.InsertClass(al)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean ClassUpdate(ClassUpdate classUpdate){
        ClassDAO classDAO=new ClassDAO();
        return classDAO.ClassUpdate(classUpdate);
    }
}
