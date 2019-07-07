package com.Attendence.My.Model.Service.Classes;

import com.Attendence.My.Model.DAO.Classes.ClassDAO;
import com.Attendence.My.Model.Entity.Class.ClassUpdate;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClassList {
     //查询班次的所有记录
     // 创建classtDao，传入page值，调用ClassQuery（）并返回结果值
    public ArrayList<ClassUpdate> ClassList(int page) throws SQLException {
        ClassDAO classDAO = new ClassDAO();
        return classDAO.ClassQuery(page);
    }
    //添加记录到班次表
    // 创建classtDao，传入要添加的记录的list值，调用InsertClass(list)并返回结果值
    public boolean AddClass(ArrayList<String> list) throws SQLException {
        ClassDAO dao = new ClassDAO();
        boolean re= dao.InsertClass(list);
        if (re){
            return true;
        }else {
            return false;
        }
    }

    //删除班次表的记录
    public boolean DeleteClass(String []del){
        ClassDAO cd = new ClassDAO();
        cd.DeleteClass(del);
        return true;
    }
    //添加班次表的记录
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
    //修改班次表的记录
    public boolean ClassUpdate(ClassUpdate classUpdate){
        ClassDAO classDAO=new ClassDAO();
        return classDAO.ClassUpdate(classUpdate);
    }
    //查询班次表的记录条数
    public int QueryAll() {
        ClassDAO el = new ClassDAO();
        return el.queryLines();
    }
    //查询班次表
    public ArrayList<ClassUpdate> Query() throws SQLException {

        ClassDAO classDAO = new ClassDAO();
        return classDAO.Query();
    }


}
