package com.Attendence.My.Model.DAO.Department;

import com.Attendence.My.Model.DBUtils.DBUtils;
import com.Attendence.My.Model.Entity.Department.DepartmentList;

import java.sql.*;
import java.util.ArrayList;

public class Department {
    public ArrayList<DepartmentList> DepartmentQuery() throws SQLException {
        String sql="SELECT * FROM Department";
        ResultSet re=null;
        DBUtils dbUtils=new DBUtils();
        Connection con=dbUtils.getConnecton();
        ArrayList<DepartmentList> arrD = new ArrayList<>();
        Statement sta= null;
        try {
            sta = con.createStatement();
            re=sta.executeQuery(sql);
            while (re.next()){
                DepartmentList dl = new DepartmentList();
                dl.setId(re.getInt("Id"));
                dl.setDepartmentId(re.getString("DepartmentId"));
                dl.setDname(re.getString("Dname"));
                dl.setDPrincipal(re.getString("Dprincipal"));
                dl.setDability(re.getString("Dability"));
                dl.setSdepartment(re.getString("Sdepartment"));
                arrD.add(dl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            re.close();
            sta.close();
            con.close();
        }
        return arrD;
    }
    public  boolean InsertDepartment(DepartmentList dl){
        String st="INSERT INTO Department(DepartmentId, Dname, Dprincipal, Dability, Sdepartment) VALUES (?,?,?,?,?)";
        DBUtils db=new DBUtils();
        Connection conn=db.getConnecton();
        PreparedStatement psmt = null;
        int res = 0;
        try {
            psmt = conn.prepareStatement(st);
            psmt.setString(1,dl.getDepartmentId());
            psmt.setString(2,dl.getDname());
            psmt.setString(3,dl.getDPrincipal());
            psmt.setString(4,dl.getDability());
            psmt.setString(5,dl.getSdepartment());
            res = psmt.executeUpdate();
            psmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(res > 0)
            return true;
        return false;
    }

    public  boolean DeleteDepartment(String []del){ //批量删除
        StringBuffer sql = new StringBuffer("DELETE FROM Department WHERE Id in(");
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

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean UpdateDep(DepartmentList dlist) throws SQLException {
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        String sql = "update Department set DepartmentId=?,Dname=?,Dprincipal=?,Dability=?,Sdepartment=? where Id = ?";
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,dlist.getDepartmentId());
        pstmt.setString(2,dlist.getDname());
        pstmt.setString(3,dlist.getDPrincipal());
        pstmt.setString(4,dlist.getDability());
        pstmt.setString(5,dlist.getSdepartment());
        pstmt.setInt(6, dlist.getId());

        int c = pstmt.executeUpdate();
        pstmt.close();
        con.close();


        if(c==1){
            return  true;
        }
        else {
            return false;
        }
    }

    public boolean DeleteDep(String id) throws SQLException {
        DBUtils dbUtils=new DBUtils();
        Connection con= dbUtils.getConnecton();
        String sql = "delete from Department where Id=?";
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, Integer.parseInt(id));

        int c = pstmt.executeUpdate();
        pstmt.close();
        con.close();

        if(c==1){
            return  true;
        }
        else {
            return false;
        }
    }


}
