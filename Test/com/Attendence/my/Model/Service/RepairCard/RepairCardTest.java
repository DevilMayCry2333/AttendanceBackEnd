package com.Attendence.my.Model.Service.RepairCard;

import com.Attendence.My.Model.Entity.RepairCard.RepairInsert;
import com.Attendence.My.Model.Service.RepairCard.RepairCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RepairCardTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void repairQuery() {
        RepairCard rc = new RepairCard();
        ArrayList<com.Attendence.My.Model.Entity.RepairCard.RepairCard> rcArr = new ArrayList<>();
        try {
            rcArr = rc.RepairQuery(1);
            for (int i = 0; i < rcArr.size(); i++) {
                assert rcArr.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void repairUpdate() {
        RepairCard rc = new RepairCard();
        com.Attendence.My.Model.Entity.RepairCard.RepairCard rcModel = new com.Attendence.My.Model.Entity.RepairCard.RepairCard();
        rcModel.setId(2);
        rcModel.setReason("24");
        rcModel.setRepairId("34");
        rcModel.setRepairDate("2018-11-11");
        rcModel.setClassId("25");
        rcModel.setUserName("asd");
        assertEquals(true,rc.RepairUpdate(rcModel));
    }

    @Test
    void repairInsert() {
        RepairCard rc = new RepairCard();
        RepairInsert rcModel = new RepairInsert();
        rcModel.setId(2);
        rcModel.setReason("24");
        rcModel.setRepairId("34");
        rcModel.setRepairDate("2018-11-11");
        rcModel.setRepairId("25");
        rcModel.setUserName("asd");
        try {
            assertEquals(true,rc.RepairInsert(rcModel));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void query() {
        RepairCard rc = new RepairCard();
        ArrayList<com.Attendence.My.Model.Entity.RepairCard.RepairCard> rcArr = new ArrayList<>();
        try {
            rcArr = rc.Query();
            for (int i = 0; i < rcArr.size(); i++) {
                assert rcArr.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}