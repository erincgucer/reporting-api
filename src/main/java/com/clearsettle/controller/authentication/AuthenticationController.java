package com.clearsettle.controller.authentication;

import com.clearsettle.model.authentication.AuthenticationToken;
import com.clearsettle.model.authentication.User;
import com.clearsettle.service.authentication.IAuthenticationServices;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by egucer on 09-Feb-17.
 */
@RestController
public class AuthenticationController {

    private static final Log log = LogFactory.getLog(AuthenticationController.class);

    @Autowired
    private IAuthenticationServices authenticationServices;

    @Autowired
    private User user;

    @GetMapping(value = "/login")
    public ResponseEntity login(HttpServletRequest request) {

        try {
            AuthenticationToken authenticationToken = authenticationServices.login(user);
            request.getSession().setAttribute("token", authenticationToken.getToken());
            return new ResponseEntity(authenticationToken, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
