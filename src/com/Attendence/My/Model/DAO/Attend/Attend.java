package com.Attendence.My.Model.DAO.Attend;

import com.Attendence.My.Model.DBUtils.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class Attend {




    public ArrayList<com.Attendence.My.Model.Entity.Attend.Attend> QueryAttend() throws SQLException {


        ArrayList<String> PunchID = new ArrayList<>();
        ArrayList<String> EmpName = new ArrayList<>();
        ArrayList<String> EarlyTime = new ArrayList<>();
        ArrayList<String> LateTime = new ArrayList<>();
        ArrayList<String> AttendStatus = new ArrayList<>();
        ArrayList<String> ClassId = new ArrayList<>();

        ArrayList<String> PunchID2 = new ArrayList<>();
        ArrayList<String> EmpName2 = new ArrayList<>();
        ArrayList<String> EarlyTime2 = new ArrayList<>();
        ArrayList<String> LateTime2 = new ArrayList<>();
        ArrayList<String> AttendStatus2 = new ArrayList<>();
        ArrayList<String> ClassId2 = new ArrayList<>();
        ArrayList<String> Status2 = new ArrayList<>();

        ArrayList<String> PunchID3 = new ArrayList<>();
        ArrayList<String> EmpName3 = new ArrayList<>();
        ArrayList<String> EarlyTime3 = new ArrayList<>();
        ArrayList<String> LateTime3 = new ArrayList<>();
        ArrayList<String> AttendStatus3 = new ArrayList<>();
        ArrayList<String> ClassId3 = new ArrayList<>();
        ArrayList<String> Status3 = new ArrayList<>();

        ArrayList<String> PunchID4 = new ArrayList<>();
        ArrayList<String> EmpName4 = new ArrayList<>();
        ArrayList<String> EarlyTime4 = new ArrayList<>();
        ArrayList<String> LateTime4 = new ArrayList<>();
        ArrayList<String> AttendStatus4 = new ArrayList<>();
        ArrayList<String> ClassId4 = new ArrayList<>();
        ArrayList<String> Status4 = new ArrayList<>();



        DBUtils db = new DBUtils();
        Connection conn = db.getConnecton();
        com.Attendence.My.Model.Entity.Attend.Attend []ASs = new com.Attendence.My.Model.Entity.Attend.Attend[4];

        com.Attendence.My.Model.Entity.Attend.Attend attendMod =
                new com.Attendence.My.Model.Entity.Attend.Attend();


        com.Attendence.My.Model.Entity.Attend.Attend attendMod2 = new com.Attendence.My.Model.Entity.Attend.Attend();
        com.Attendence.My.Model.Entity.Attend.Attend attendMod3 = new com.Attendence.My.Model.Entity.Attend.Attend();
        com.Attendence.My.Model.Entity.Attend.Attend attendMod4 = new com.Attendence.My.Model.Entity.Attend.Attend();
        
        ArrayList<com.Attendence.My.Model.Entity.Attend.Attend> as = new ArrayList<>();
        
        
        String Normal = "SELECT * FROM realall";
        String LateMorning = "SELECT * FROM latemorning";
        String EarlyAfternoon = "SELECT * FROM earlyafternoon";
//        String AbsDay = "SELECT * FROM absday";

        Statement st = null;
        Statement st2 = null;
        Statement st3 = null;
        Statement st4 = null;
        ResultSet rss = null;
        ResultSet rss2 = null;
        ResultSet rss3 = null;
//        ResultSet rss4 = null;

        try {
            st = conn.createStatement();
            st2 = conn.createStatement();
            st3 = conn.createStatement();
            st4 = conn.createStatement();

            rss = st.executeQuery(Normal);
            rss2 = st2.executeQuery(LateMorning);
            rss3 = st3.executeQuery(EarlyAfternoon);
//            rss4 = st4.executeQuery(AbsDay);

            int i = 0;



//            PunchID.clear();
//            EmpName.clear();
//            EarlyTime.clear();
//            LateTime.clear();
//            ClassId.clear();
//            AttendStatus.clear();

            while (rss2.next()){
                String username = rss2.getString("UserName");
                EmpName2.add(username);
                EarlyTime2.add(rss2.getString("t1"));
                LateTime2.add(rss2.getString("t2"));
                ClassId2.add(rss2.getString("ClassId"));
                AttendStatus2.add("迟到");
            }

            attendMod2.setEmpName(EmpName2);
            attendMod2.setEarlyTime(EarlyTime2);
            attendMod2.setLateTime(LateTime2);
            attendMod2.setClassId(ClassId2);
            attendMod2.setAttendStatus(AttendStatus2);


//            PunchID.clear();
//            EmpName.clear();
//            EarlyTime.clear();
//            LateTime.clear();
//            ClassId.clear();
//            AttendStatus.clear();

            while (rss3.next()){
                String username = rss3.getString("UserName");
                EmpName3.add(username);
                EarlyTime3.add(rss3.getString("t1"));
                LateTime3.add(rss3.getString("t2"));
                ClassId3.add(rss3.getString("ClassId"));
                AttendStatus3.add("早退");
            }
//            rss3.close();
            attendMod3.setEmpName(EmpName3);
            attendMod3.setEarlyTime(EarlyTime3);
            attendMod3.setLateTime(LateTime3);
            attendMod3.setClassId(ClassId3);
            attendMod3.setAttendStatus(AttendStatus3);



            while (rss.next()){
                int flag = 1;
                String name = rss.getString("UserName");
                for (int j = 0; j < attendMod2.getClassId().size(); j++) {
                    if(name.equals(attendMod2.getEmpName().get(j))){
                        flag = 0;
                    }
                }
                for (int j = 0; j < attendMod3.getClassId().size(); j++) {
                    if(name.equals(attendMod3.getEmpName().get(j))){
                        flag = 0;
                    }
                }
                if(flag==1) {

                    String early = rss.getString("EarlyTime");
                    String late = rss.getString("LatTime");
                    EmpName.add(name);
                    EarlyTime.add(early);
                    LateTime.add(late);
                    ClassId.add(rss.getString("ClassId"));
                    if (early.equals("缺勤") || late.equals("缺勤"))
                        AttendStatus.add("旷工");
                    else
                        AttendStatus.add("正常");
                }
            }

            attendMod.setEmpName(EmpName);
            attendMod.setEarlyTime(EarlyTime);
            attendMod.setLateTime(LateTime);
            attendMod.setClassId(ClassId);
            attendMod.setAttendStatus(AttendStatus);



//            PunchID.clear();
//            EmpName.clear();
//            EarlyTime.clear();
//            LateTime.clear();
//            ClassId.clear();
//            AttendStatus.clear();
//            String r1 = "缺勤";
//            String r2 = "缺勤";
//            while (rss4.next()){
//                EmpName4.add(rss4.getString("UserName"));
//                try {
//                    r1 = rss4.getString("EarlyTime");
//                    r2 = rss4.getString("LatTime");
//                }catch (Exception e){
//                    ;
//                }
//                EarlyTime4.add(r1);
//                LateTime4.add(r2);
//                ClassId4.add(rss4.getString("ClassId"));
//                AttendStatus4.add("旷工");
//                i++;
//            }
//            rss4.close();

//            attendMod4.setEarlyTime(EarlyTime4);
//            attendMod4.setLateTime(LateTime4);
//            attendMod4.setEmpName(EmpName4);
//            attendMod4.setClassId(ClassId4);
//            attendMod4.setAttendStatus(AttendStatus4);
//
//            PunchID.clear();
//            EmpName.clear();
//            EarlyTime.clear();
//            LateTime.clear();
//            ClassId.clear();
//            AttendStatus.clear();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rss.close();
            rss2.close();
            rss3.close();
//            rss4.close();;
            st.close();
            st2.close();
            st3.close();
//            st4.close();
            conn.close();
        }
        as.add(attendMod);
        as.add(attendMod2);
        as.add(attendMod3);
//        as.add(attendMod4);


        return as;

    }

    public boolean insertTable(com.Attendence.My.Model.Entity.Attend.Attend attend){
        DBUtils dbu = new DBUtils();
        Connection conn = dbu.getConnecton();
        try {

            for (int i = 0; i <attend.getEmpName().size(); i++) {
                PreparedStatement psmt = conn.prepareStatement("INSERT INTO Attend(EarlyTime, LateTime, EmpName, ClassId, AttendStatus) VALUES (?,?,?,?,?)");
                psmt.setString(1,attend.getEarlyTime().get(i));
                psmt.setString(2,attend.getLateTime().get(i));
                psmt.setString(3,attend.getEmpName().get(i));
                psmt.setString(4,attend.getClassId().get(i));
                psmt.setString(5,attend.getAttendStatus().get(i));
                psmt.executeUpdate();
                psmt.close();
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean DelTable(){
        DBUtils db = new DBUtils();
        Connection conn = db.getConnecton();
        PreparedStatement psdel = null;
        try {
            psdel = conn.prepareStatement("DELETE FROM Attend");
            psdel.executeUpdate();
            psdel.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
      return true;

    }
    public ArrayList<com.Attendence.My.Model.Entity.Attend.Attend> Query() throws SQLException {


        ArrayList<String> PunchID = new ArrayList<>();
        ArrayList<String> EmpName = new ArrayList<>();
        ArrayList<String> EarlyTime = new ArrayList<>();
        ArrayList<String> LateTime = new ArrayList<>();
        ArrayList<String> AttendStatus = new ArrayList<>();
        ArrayList<String> ClassId = new ArrayList<>();

        ArrayList<String> PunchID2 = new ArrayList<>();
        ArrayList<String> EmpName2 = new ArrayList<>();
        ArrayList<String> EarlyTime2 = new ArrayList<>();
        ArrayList<String> LateTime2 = new ArrayList<>();
        ArrayList<String> AttendStatus2 = new ArrayList<>();
        ArrayList<String> ClassId2 = new ArrayList<>();

        ArrayList<String> PunchID3 = new ArrayList<>();
        ArrayList<String> EmpName3 = new ArrayList<>();
        ArrayList<String> EarlyTime3 = new ArrayList<>();
        ArrayList<String> LateTime3 = new ArrayList<>();
        ArrayList<String> AttendStatus3 = new ArrayList<>();
        ArrayList<String> ClassId3 = new ArrayList<>();

        ArrayList<String> PunchID4 = new ArrayList<>();
        ArrayList<String> EmpName4 = new ArrayList<>();
        ArrayList<String> EarlyTime4 = new ArrayList<>();
        ArrayList<String> LateTime4 = new ArrayList<>();
        ArrayList<String> AttendStatus4 = new ArrayList<>();
        ArrayList<String> ClassId4 = new ArrayList<>();



        DBUtils db = new DBUtils();
        Connection conn = db.getConnecton();
        com.Attendence.My.Model.Entity.Attend.Attend []ASs = new com.Attendence.My.Model.Entity.Attend.Attend[4];

        com.Attendence.My.Model.Entity.Attend.Attend attendMod =
                new com.Attendence.My.Model.Entity.Attend.Attend();


        com.Attendence.My.Model.Entity.Attend.Attend attendMod2 = new com.Attendence.My.Model.Entity.Attend.Attend();
        com.Attendence.My.Model.Entity.Attend.Attend attendMod3 = new com.Attendence.My.Model.Entity.Attend.Attend();
        com.Attendence.My.Model.Entity.Attend.Attend attendMod4 = new com.Attendence.My.Model.Entity.Attend.Attend();

        ArrayList<com.Attendence.My.Model.Entity.Attend.Attend> as = new ArrayList<>();


        String Normal = "SELECT * FROM intw";
        String LateMorning = "SELECT * FROM latemorning";
        String EarlyAfternoon = "SELECT * FROM earlyafternoon";
        String AbsDay = "SELECT * FROM absday";

        Statement st = null;
        Statement st2 = null;
        Statement st3 = null;
        Statement st4 = null;
        ResultSet rss = null;
        ResultSet rss2 = null;
        ResultSet rss3 = null;
        ResultSet rss4 = null;

        try {
            st = conn.createStatement();
            st2 = conn.createStatement();
            st3 = conn.createStatement();
            st4 = conn.createStatement();

            rss = st.executeQuery(Normal);
            rss2 = st2.executeQuery(LateMorning);
            rss3 = st3.executeQuery(EarlyAfternoon);
            rss4 = st4.executeQuery(AbsDay);

            int i = 0;

            while (rss.next()){
                EmpName.add(rss.getString("UserName"));
                EarlyTime.add(rss.getString("t1"));
                LateTime.add(rss.getString("t2"));
                ClassId.add(rss.getString("ClassId"));
                AttendStatus.add("正常");
            }
//            rss.close();

            attendMod.setEmpName(EmpName);
            attendMod.setEarlyTime(EarlyTime);
            attendMod.setLateTime(LateTime);
            attendMod.setClassId(ClassId);
            attendMod.setAttendStatus(AttendStatus);

//            PunchID.clear();
//            EmpName.clear();
//            EarlyTime.clear();
//            LateTime.clear();
//            ClassId.clear();
//            AttendStatus.clear();

            while (rss2.next()){
                EmpName2.add(rss2.getString("UserName"));
                EarlyTime2.add(rss2.getString("t1"));
                LateTime2.add(rss2.getString("t2"));
                ClassId2.add(rss2.getString("ClassId"));
                AttendStatus2.add("迟到");
            }
//            rss2.close();

            attendMod2.setEmpName(EmpName2);
            attendMod2.setEarlyTime(EarlyTime2);
            attendMod2.setLateTime(LateTime2);
            attendMod2.setClassId(ClassId2);
            attendMod2.setAttendStatus(AttendStatus2);


//            PunchID.clear();
//            EmpName.clear();
//            EarlyTime.clear();
//            LateTime.clear();
//            ClassId.clear();
//            AttendStatus.clear();

            while (rss3.next()){
                EmpName3.add(rss3.getString("UserName"));
                EarlyTime3.add(rss3.getString("t1"));
                LateTime3.add(rss3.getString("t2"));
                ClassId3.add(rss3.getString("ClassId"));
                AttendStatus3.add("早退");
            }
//            rss3.close();
            attendMod3.setEmpName(EmpName3);
            attendMod3.setEarlyTime(EarlyTime3);
            attendMod3.setLateTime(LateTime3);
            attendMod3.setClassId(ClassId3);
            attendMod3.setAttendStatus(AttendStatus3);

//            PunchID.clear();
//            EmpName.clear();
//            EarlyTime.clear();
//            LateTime.clear();
//            ClassId.clear();
//            AttendStatus.clear();
            String r1 = "缺勤";
            String r2 = "缺勤";
            while (rss4.next()){
                EmpName4.add(rss4.getString("UserName"));
                try {
                    r1 = rss4.getString("EarlyTime");
                    r2 = rss4.getString("LatTime");
                }catch (Exception e){
                    ;
                }
                EarlyTime4.add(r1);
                LateTime4.add(r2);
                ClassId4.add(rss4.getString("ClassId"));
                AttendStatus4.add("旷工");
            }
//            rss4.close();

            attendMod4.setEarlyTime(EarlyTime4);
            attendMod4.setLateTime(LateTime4);
            attendMod4.setEmpName(EmpName4);
            attendMod4.setClassId(ClassId4);
            attendMod4.setAttendStatus(AttendStatus4);
//
//            PunchID.clear();
//            EmpName.clear();
//            EarlyTime.clear();
//            LateTime.clear();
//            ClassId.clear();
//            AttendStatus.clear();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rss.close();
            rss2.close();
            rss3.close();
            rss4.close();;
            st.close();
            st2.close();
            st3.close();
            st4.close();
            conn.close();
        }
        as.add(attendMod);
        as.add(attendMod2);
        as.add(attendMod3);
        as.add(attendMod4);


        return as;

    }
}
