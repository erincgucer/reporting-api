package com.clearsettle.service.usermanagement.impl;

import com.clearsettle.constants.ReportingApiConstants;
import com.clearsettle.model.usermanagement.ClientRequest;
import com.clearsettle.model.usermanagement.ClientResponse;
import com.clearsettle.model.usermanagement.MerchantRequest;
import com.clearsettle.model.usermanagement.MerchantResponse;
import com.clearsettle.service.usermanagement.IUserServices;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by egucer on 10-Feb-17.
 */
@Service
public class UserServicesImpl implements IUserServices {

    private static final Log log = LogFactory.getLog(UserServicesImpl.class);

    @Autowired
    private ReportingApiConstants reportingApiConstants;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public MerchantResponse getMerchant(MerchantRequest merchantRequest, String token) {
        try {

            MerchantResponse merchantResponse = null;

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", token);
            HttpEntity httpEntity = new HttpEntity<>(merchantRequest , httpHeaders);

            merchantResponse = restTemplate.postForObject(reportingApiConstants.getUrlGetMerchant(), httpEntity, MerchantResponse.class);

            return merchantResponse;

        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }

    @Override
    public ClientResponse getClient(ClientRequest clientRequest, String token) {
        try {

            ClientResponse clientResponse = null;

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", token);
            HttpEntity httpEntity = new HttpEntity<>(clientRequest , httpHeaders);

            clientResponse = restTemplate.postForObject(reportingApiConstants.getUrlGetClient(), httpEntity, ClientResponse.class);

            return clientResponse;

        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }
}
