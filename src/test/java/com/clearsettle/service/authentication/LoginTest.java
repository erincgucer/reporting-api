package com.clearsettle.service.authentication;

import com.clearsettle.model.authentication.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by egucer on 09-Feb-17.
 */
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {

    @Autowired
    private User user;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void login() throws Exception {

        mockMvc.perform(get("/login").param("email", user.getEmail()).param("password", user.getPassword())).andExpect(jsonPath("token").isNotEmpty());
    }

}
