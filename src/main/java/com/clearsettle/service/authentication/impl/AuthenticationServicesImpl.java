package com.clearsettle.service.authentication.impl;

import com.clearsettle.constants.ReportingApiConstants;
import com.clearsettle.model.authentication.AuthenticationToken;
import com.clearsettle.model.authentication.User;
import com.clearsettle.service.authentication.IAuthenticationServices;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by egucer on 09-Feb-17.
 */
@Service
public class AuthenticationServicesImpl implements IAuthenticationServices {

    private static final Log log = LogFactory.getLog(AuthenticationServicesImpl.class);

    @Autowired
    private ReportingApiConstants reportingApiConstants;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public AuthenticationToken login(User user) {

        try {

            AuthenticationToken authenticationToken = restTemplate.postForObject(reportingApiConstants.getUrlMerchantLogin(), user, AuthenticationToken.class);
            return authenticationToken;

        } catch (Exception e) {
            log.error(e);
            throw e;
        }

    }
}
