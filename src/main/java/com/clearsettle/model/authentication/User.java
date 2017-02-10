package com.clearsettle.model.authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by egucer on 09-Feb-17.
 */
@Component
public class User {

    @Value("${email}")
    private String email;

    @Value("${password}")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
