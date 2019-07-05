package com.Attendence.my.Model.Service.Leave;

import com.Attendence.My.Model.Entity.Leave.Leave;
import com.Attendence.My.Model.Service.Leave.LeaveList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LeaveListTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void leaveList() {
        LeaveList leaveList = new LeaveList();
        try {
            ArrayList<Leave> leaves = leaveList.LeaveList(1);
            for (int i = 0; i < leaves.size(); i++) {
                assert leaves.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void leaveInsert() {
        Leave leave = new Leave();
        leave.setId(7);
        leave.setLeaveName("Joker");
        leave.setBeginDate("2019-07-05 08:00:00");
        leave.setEndDate("2019-07-05 12:00:00");
        leave.setLeaveReason("回家");
        leave.setLeaveId("22");
        LeaveList leaveList = new LeaveList();
        try {
            assertEquals(true,leaveList.LeaveInsert(leave));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    void query() {
        LeaveList leaveList =new LeaveList();
        try {
            ArrayList<Leave> leaves = leaveList.Query();
            for (int i = 0; i < leaves.size(); i++) {
                assert leaves.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}