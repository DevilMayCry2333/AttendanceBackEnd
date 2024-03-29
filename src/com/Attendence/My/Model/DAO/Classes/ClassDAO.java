package com.Attendence.My.Model.DAO.Classes;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Class.ClassUpdate;

import java.sql.*;
import java.util.ArrayList;

public class ClassDAO {
    public ArrayList<ClassUpdate> ClassQuery(int page) throws SQLException {
        String str="SELECT * from Classes LIMIT ?,?";
        System.out.println(str);
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        ResultSet re=null;
        ArrayList<ClassUpdate> ClassArr = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(str);
            st.setInt(1,page*10-10);
            st.setInt(2,10);
            re = st.executeQuery();
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

    public int queryLines() {
        DBUtils db = new DBUtils();
        Connection conn = db.getConnecton();
        int res = 0;
        ResultSet rs = null;
        try {
            PreparedStatement psmt = conn.prepareStatement("SELECT count(Id) ClassCount FROM Classes");
            rs = psmt.executeQuery();
            if(rs.next()){
                res = rs.getInt("ClassCount");
                System.out.println(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<ClassUpdate> Query() throws SQLException {
        String str="SELECT * from Classes";
        System.out.println(str);
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        ResultSet re=null;
        ArrayList<ClassUpdate> ClassArr = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(str);
            re = st.executeQuery();
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

}
