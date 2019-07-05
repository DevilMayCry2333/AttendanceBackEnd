package com.Attendence.my.Model.Service.Attend;

import com.Attendence.My.Model.Service.Attend.Attend;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AttendTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void queryTable() {
        Attend attend = new Attend();
        try {
            ArrayList<com.Attendence.My.Model.Entity.Attend.Attend> arr = attend.QueryTable();
            for (int i = 0; i < arr.size(); i++) {
                com.Attendence.My.Model.Entity.Attend.Attend attend1 = arr.get(i);
                assert attend1!=null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}