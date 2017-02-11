package com.clearsettle.service.usermanagement;

import com.clearsettle.model.authentication.AuthenticationToken;
import com.clearsettle.model.authentication.User;
import com.clearsettle.service.authentication.IAuthenticationServices;
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
 * Created by egucer on 11-Feb-17.
 */
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private IAuthenticationServices authenticationServices;

    @Autowired
    private User user;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getMerchant() throws Exception {

        AuthenticationToken authenticationToken = authenticationServices.login(user);

        mockMvc.perform(get("/merchant").param("transactionId", "529-1438673740-2")
                .header("Authorization", authenticationToken.getToken())).andExpect(jsonPath("merchant").isEmpty());
    }

    @Test
    public void getClient() throws Exception {

        AuthenticationToken authenticationToken = authenticationServices.login(user);

        mockMvc.perform(get("/client").param("transactionId", "529-1438673740-2")
                .header("Authorization", authenticationToken.getToken())).andExpect(jsonPath("customerInfo").isEmpty());
    }
}
