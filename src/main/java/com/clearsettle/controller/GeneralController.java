package com.clearsettle.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by egucer on 09-Feb-17.
 */
@RestController
public class GeneralController {

    @RequestMapping("/")
    public String index() {
        return "/login for login operations" + "..." + "/report for transaction report operations"
                + "..." + "/client for client operations" + "..." + "/merchant for merchant operations";
    }
}
