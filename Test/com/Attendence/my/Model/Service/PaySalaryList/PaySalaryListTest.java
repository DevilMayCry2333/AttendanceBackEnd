package com.Attendence.my.Model.Service.PaySalaryList;

import com.Attendence.My.Model.Entity.PaySalary.PaySalary;
import com.Attendence.My.Model.Service.PaySalaryList.PaySalaryList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PaySalaryListTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void paySalayList() {
        PaySalaryList paySalaryList = new PaySalaryList();
        ArrayList<PaySalary> arrayList = paySalaryList.PaySalayList();
        for (int i = 0; i < arrayList.size(); i++) {
            assert arrayList.get(i)!=null;
        }
    }
}