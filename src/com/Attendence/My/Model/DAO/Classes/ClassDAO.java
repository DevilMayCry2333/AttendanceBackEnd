package com.Attendence.My.Model.DAO.Classes;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Class.ClassUpdate;

import java.sql.*;
import java.util.ArrayList;

public class ClassDAO {
    public ArrayList<ClassUpdate> ClassQuery() throws SQLException {
        String str="SELECT * from Classes";
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        ArrayList<ClassUpdate> ClassArr = new ArrayList<>();
        ResultSet re = null;
        Statement st = null;
        try {
            st = con.createStatement();
            re = st.executeQuery(str);
            while (re.next()){
                //                js.put("Id",re1.getString("Id"));
//                js.put("ClassId",re1.getString("ClassId"));
//                js.put("Cname",re1.getString("Cname"));
//                js.put("Mtime",re1.getString("Mtime"));
//                js.put("Atime",re1.getString("Atime"));
                ClassUpdate classUpdate = new ClassUpdate();
                classUpdate.setId(re.getInt("Id"));
                classUpdate.setClassId(re.getString("ClassId"));
                classUpdate.setCname(re.getString("Cname"));
                classUpdate.setMtime(re.getString("Mtime"));
                classUpdate.setAtime(re.getString("Atime"));
                ClassArr.add(classUpdate);


            }
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            re.close();
            st.close();
            con.close();
        }
        return ClassArr;
    }

    public boolean InsertClass(ArrayList<String> list) throws SQLException {
//        String sql="INSERT INTO Classes(ClassId,Cname,Mtime,Atime)values('" + list.get(0) + "','"
//                + list.get(1) + "','" + list.get(2) +"','" + list.get(3) + "')";
//        DBUtils db=new DBUtils();
//        Connection conn=db.getConnecton();
//        boolean c = false;
//        try {
//            Statement stt=conn.createStatement();
//            c=stt.execute(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if(c==true){
//            return  true;
//        }
//        else {
//            return false;
//        }


        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        String sql = "insert into Classes(ClassId, Cname, Mtime, Atime)  value (?,?,?,?)";
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, list.get(0));
        pstmt.setString(2, list.get(1));
        pstmt.setString(3, list.get(2));
        pstmt.setString(4, list.get(3));

        int c = pstmt.executeUpdate();
        pstmt.close();
        con.close();
        if (c == 1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean ClassUpdate(ClassUpdate classUpdate){
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        try {
            PreparedStatement psmt = con.prepareStatement("UPDATE Classes SET ClassId = ? ,Classes.Cname = ? , Classes.Mtime = ? , Classes.Atime = ? , Classes.Descri = ? WHERE Classes.Id = ?");
            psmt.setString(1,classUpdate.getClassId());
            psmt.setString(2,classUpdate.getCname());
            psmt.setString(3,classUpdate.getMtime());
            psmt.setString(4,classUpdate.getAtime());
            psmt.setString(5,classUpdate.getDesc());
            psmt.setInt(6,classUpdate.getId());
            int res = psmt.executeUpdate();
            System.out.println(res);
            psmt.close();
            con.close();

            if(res > 0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean DeleteClass(String []del){
        StringBuffer sql = new StringBuffer("DELETE FROM Classes WHERE Id in(");
        for (int i = 0; i < del.length; i++) {
            if (i==del.length-1){
                sql.append("'" + del[i] + "')");
            }else {
                sql.append("'" + del[i] + "',");
            }
        }
        System.out.println(sql);
        DBUtils dbUtils=new DBUtils();
        Connection cn = dbUtils.getConnecton();
        try {
            Statement st = cn.createStatement();
            st.executeUpdate(sql.toString());
            st.close();
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

}
