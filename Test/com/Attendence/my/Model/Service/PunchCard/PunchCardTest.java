package com.Attendence.my.Model.Service.PunchCard;

import com.Attendence.My.Model.Entity.PunchCard.PunchCardInsert;
import com.Attendence.My.Model.Service.PunchCard.PunchCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PunchCardTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void punchQuery() {
        PunchCard pc = new PunchCard();
        ArrayList<com.Attendence.My.Model.Entity.PunchCard.PunchCard> punchArr = new ArrayList<>();
        try {
            punchArr = pc.PunchQuery(1);
            for (int i = 0; i < punchArr.size(); i++) {
                assert punchArr.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    void punchUpdate() {
        PunchCard pc = new PunchCard();
        com.Attendence.My.Model.Entity.PunchCard.PunchCard pcModel = new com.Attendence.My.Model.Entity.PunchCard.PunchCard();
        pcModel.setID(14);
        pcModel.setRemarks("24");
        pcModel.setPunchId("34");
        pcModel.setPunchDate("2018-11-11");
        pcModel.setClassId("25");
        pcModel.setUserName("asd");
        int res = pc.PunchUpdate(pcModel);
        assert res > 0;

    }

    @Test
    void punchInsert() {
        PunchCard pc = new PunchCard();
        PunchCardInsert pcModel= new PunchCardInsert();
        pcModel.setId(11);
        pcModel.setRemarks("24");
        pcModel.setPunchId("34");
        pcModel.setPunchDate("2018-11-11");
        pcModel.setClassId("25");
        pcModel.setUserName("asd");
        try {
            assertEquals(true,pc.PunchInsert(pcModel));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    void queryAll() {
        PunchCard pc = new PunchCard();
        try {
            ArrayList<com.Attendence.My.Model.Entity.PunchCard.PunchCard> punchLists = pc.Query();
            for (int i = 0; i < punchLists.size(); i++) {
                assert punchLists.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
