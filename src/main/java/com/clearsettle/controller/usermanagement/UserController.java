package com.clearsettle.controller.usermanagement;

import com.clearsettle.model.usermanagement.ClientRequest;
import com.clearsettle.model.usermanagement.ClientResponse;
import com.clearsettle.model.usermanagement.MerchantRequest;
import com.clearsettle.model.usermanagement.MerchantResponse;
import com.clearsettle.service.usermanagement.IUserServices;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by egucer on 10-Feb-17.
 */
@RestController
public class UserController {

    private static final Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private IUserServices userServices;

    @GetMapping(value = "/merchant")
    public ResponseEntity getMerchant(HttpServletRequest request, @RequestParam("transactionId") String transactionId) {

        try {

            String token = (String) request.getSession().getAttribute("token");
            if (StringUtils.isEmpty(token)) {
                new ResponseEntity(token, HttpStatus.UNAUTHORIZED);
            }

            MerchantRequest merchantRequest = new MerchantRequest();
            merchantRequest.setTransactionId(transactionId);

            MerchantResponse merchantResponse = userServices.getMerchant(merchantRequest, token);

            return new ResponseEntity(merchantResponse, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/client")
    public ResponseEntity getClient(HttpServletRequest request, @RequestParam("transactionId") String transactionId) {

        try {

            String token = (String) request.getSession().getAttribute("token");
            if (StringUtils.isEmpty(token)) {
                new ResponseEntity(token, HttpStatus.UNAUTHORIZED);
            }

            ClientRequest clientRequest = new ClientRequest();
            clientRequest.setTransactionId(transactionId);

            ClientResponse clientResponse = userServices.getClient(clientRequest, token);

            return new ResponseEntity(clientResponse, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
