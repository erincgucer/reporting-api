package com.clearsettle.controller.transaction;

import com.clearsettle.model.transaction.ReportRequest;
import com.clearsettle.model.transaction.ReportResponse;
import com.clearsettle.service.transaction.ITransactionServices;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by egucer on 10-Feb-17.
 */
@RestController
public class TransactionController {

    private static final Log log = LogFactory.getLog(TransactionController.class);

    @Autowired
    private ITransactionServices transactionServices;

    @GetMapping(value = "/report")
    public ResponseEntity report(HttpServletRequest request,
                                 @RequestParam("fromDate") String fromDate,  @RequestParam("toDate") String toDate,
                                 @RequestParam("merchant") Integer merchant,  @RequestParam("acquirer") Integer acquirer) {

        try {

            String token = (String) request.getSession().getAttribute("token");
            if(StringUtils.isEmpty(token)){
                new ResponseEntity(token, HttpStatus.UNAUTHORIZED);
            }

            ReportRequest reportRequest = new ReportRequest();
            DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
            reportRequest.setFromDate(format.parse(fromDate));
            reportRequest.setToDate(format.parse(toDate));
            reportRequest.setAcquirer(acquirer);
            reportRequest.setMerchant(merchant);

            ReportResponse reportResponse = transactionServices.report(reportRequest, token);

            return new ResponseEntity(reportResponse, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
