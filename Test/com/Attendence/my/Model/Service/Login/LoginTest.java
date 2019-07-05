package com.Attendence.my.Model.Service.Login;

import com.Attendence.My.Model.Service.Login.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.rmi.runtime.Log;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void loginquery() {
        try {
            Login login = new Login();
//
            String res = login.loginquery("root","123");
//
            assertEquals("登录成功",res);

//

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    void deletLogin() {
        Login login = new Login();
        String username = "root";
        boolean res = login.deletLogin(username);
        assertEquals(true,res);
    }
}