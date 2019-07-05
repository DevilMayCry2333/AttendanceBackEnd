package com.Attendence.My.Model.Service.Classes;

import com.Attendence.My.Model.DAO.Classes.ClassDAO;
import com.Attendence.My.Model.Entity.Class.ClassUpdate;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClassList {
    public ArrayList<ClassUpdate> ClassList(int page) throws SQLException {

        ClassDAO classDAO = new ClassDAO();
        return classDAO.ClassQuery(page);
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
        try {
            if(cd.InsertClass(al)){
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

    public int QueryAll() {
        ClassDAO el = new ClassDAO();
        return el.queryLines();
    }

    public ArrayList<ClassUpdate> Query() throws SQLException {

        ClassDAO classDAO = new ClassDAO();
        return classDAO.Query();
    }


}
