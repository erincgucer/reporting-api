package com.clearsettle.service.transaction.impl;

import com.clearsettle.constants.ReportingApiConstants;
import com.clearsettle.model.transaction.ReportRequest;
import com.clearsettle.model.transaction.ReportResponse;
import com.clearsettle.service.transaction.ITransactionServices;
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
public class TransactionServicesImpl implements ITransactionServices {

    private static final Log log = LogFactory.getLog(TransactionServicesImpl.class);

    @Autowired
    private ReportingApiConstants reportingApiConstants;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ReportResponse report(ReportRequest reportRequest, String token) {

        try {

            ReportResponse reportResponse = null;

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", token);
            HttpEntity httpEntity = new HttpEntity<>(reportRequest , httpHeaders);

            reportResponse = restTemplate.postForObject(reportingApiConstants.getUrlTransactionReport(), httpEntity, ReportResponse.class);

            return reportResponse;

        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }
}
