package com.Attendence.my.Model.Service.Station;

import com.Attendence.My.Model.Entity.Station.StationList;
import com.Attendence.My.Model.Service.Station.Station;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void stationQuery() {
        Station station = new Station();
        ArrayList<StationList> staLists = new ArrayList<>();
        try {
            staLists = station.StationQuery(1);
            for (int i = 0; i < staLists.size(); i++) {
                assert staLists.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteStation() {
        String id = "27";
        Station station = new Station();
        assertEquals(true,station.DeleteStation(id));
    }

    @Test
    void deleteStation1() {
        String []del = {"19","20"};
        Station station = new Station();
        assertEquals(true,station.DeleteStation(del));
    }

    @Test
    void addSta() {
       Station station = new Station();
       ArrayList<String> strList = new ArrayList<>();
        strList.add("JobId");
        strList.add("Pname");
        strList.add("Adepartment");
        strList.add("Isuperior");
        strList.add("管理类");
        try {
            assertEquals(true,station.AddSta(strList));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateSta() {
        Station station = new Station();
        ArrayList<String> strList = new ArrayList<>();
        strList.add("JobIdd");
        strList.add("Pname");
        strList.add("Adepartment");
        strList.add("Isuperior");
        strList.add("管理类");
        try {
            assertEquals(true,station.AddSta(strList));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    void query() {
        Station station = new Station();
        try {
            ArrayList<StationList> staLists = station.Query();
            for (int i = 0; i < staLists.size(); i++) {
                assert staLists.get(i)!=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}