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


    public ArrayList<com.Attendence.My.Model.Entity.Attend.Attend> QueryTable() throws SQLException {
        com.Attendence.My.Model.DAO.Attend.Attend attendDao = new com.Attendence.My.Model.DAO.Attend.Attend();
        ArrayList<com.Attendence.My.Model.Entity.Attend.Attend>  as = attendDao.QueryAttend();

        return as;

    }
    public boolean insertTable(com.Attendence.My.Model.Entity.Attend.Attend attend){
        com.Attendence.My.Model.DAO.Attend.Attend AttendDAO = new com.Attendence.My.Model.DAO.Attend.Attend();
        return AttendDAO.insertTable(attend);
    }
    public boolean DelTable(){
        com.Attendence.My.Model.DAO.Attend.Attend attend = new com.Attendence.My.Model.DAO.Attend.Attend();
        return attend.DelTable();
    }
    public ArrayList<com.Attendence.My.Model.Entity.Attend.Attend> Query() throws SQLException {
        com.Attendence.My.Model.DAO.Attend.Attend attendDao = new com.Attendence.My.Model.DAO.Attend.Attend();
        ArrayList<com.Attendence.My.Model.Entity.Attend.Attend>  as = attendDao.Query();

        return as;

    }
}
