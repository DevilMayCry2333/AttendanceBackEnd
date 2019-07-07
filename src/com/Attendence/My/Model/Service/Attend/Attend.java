package com.Attendence.My.Model.Service.Attend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Attend {
    /**
     *     private String []ID;
     *     private String []EmpCode;
     *     private String []EmpName;
     *     private String []EarlyTime;
     *     private String []LateTime;
     *     private String []AttendStatus;
     *
     */

    //查询考勤表的所有记录
    // 创建attentDao，调用QueryAttend（），并将结果赋值给ArrayList as，返回as
    public ArrayList<com.Attendence.My.Model.Entity.Attend.Attend> QueryTable() throws SQLException {
        com.Attendence.My.Model.DAO.Attend.Attend attendDao = new com.Attendence.My.Model.DAO.Attend.Attend();
        ArrayList<com.Attendence.My.Model.Entity.Attend.Attend>  as = attendDao.QueryAttend();

        return as;

    }
    //插入记录到考勤表
    // 创建attentDao，传入一个attend的实体类对象，调用insertTable（）方法并返回结果
    public boolean insertTable(com.Attendence.My.Model.Entity.Attend.Attend attend){
        com.Attendence.My.Model.DAO.Attend.Attend AttendDAO = new com.Attendence.My.Model.DAO.Attend.Attend();
        return AttendDAO.insertTable(attend);
    }
    //删除考勤表记录
    //创建attentDao，调用DelTable方法并返回
    public boolean DelTable(){
        com.Attendence.My.Model.DAO.Attend.Attend attend = new com.Attendence.My.Model.DAO.Attend.Attend();
        return attend.DelTable();
    }

    //查询考勤记录
    //创建attentDao，调用Query方法并返回
    public ArrayList<com.Attendence.My.Model.Entity.Attend.Attend> Query() throws SQLException {
        com.Attendence.My.Model.DAO.Attend.Attend attendDao = new com.Attendence.My.Model.DAO.Attend.Attend();
        return attendDao.Query();

    }
}
