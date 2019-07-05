package com.Attendence.my.Model.Service.Classes;

import com.Attendence.My.Model.Entity.Class.ClassUpdate;
import com.Attendence.My.Model.Service.Classes.ClassList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClassListTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void classList() {
        ClassList cl = new ClassList();
        try {
            ArrayList<ClassUpdate> cll = cl.ClassList(1);
            for (int i = 0; i < cll.size(); i++) {
                assert  cll.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void insertClass() {
        /**
         * ClassId, Cname, Mtime, Atime
         */
        ArrayList<String> al = new ArrayList<>();
        al.add("444");
        al.add("JUnitTest2");
        al.add("10:07:00");
        al.add("21:00:00");
        ClassList cl = new ClassList();
        assertEquals(true,cl.InsertClass(al));
    }



    @Test
    void classUpdate() {
        ClassUpdate clu = new ClassUpdate();
        clu.setId(30);
        clu.setClassId("666");
        clu.setAtime("08:00:00");
        clu.setMtime("19:00:00");
        clu.setCname("JUnitUpdate");
        clu.setDesc("None");
        ClassList cl = new ClassList();
        assertEquals(true,cl.ClassUpdate(clu));

    }

    @Test
    void deleteClass() {
        String []del = {"31"};
        ClassList cl = new ClassList();
        cl.DeleteClass(del);
    }


    @Test
    void query() {
        ClassList cl = new ClassList();
        try {
            ArrayList<ClassUpdate> classUpdates = cl.Query();
            for (int i = 0; i < classUpdates.size(); i++) {
                assert classUpdates.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}