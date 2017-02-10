package com.clearsettle.service.transaction;

import com.clearsettle.model.transaction.ReportRequest;
import com.clearsettle.model.transaction.ReportResponse;

/**
 * Created by egucer on 10-Feb-17.
 */
public interface ITransactionServices {

    public ReportResponse report(ReportRequest reportRequest, String token);
}
