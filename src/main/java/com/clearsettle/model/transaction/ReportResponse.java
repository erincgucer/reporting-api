package com.clearsettle.model.transaction;

/**
 * Created by egucer on 10-Feb-17.
 */
public class ReportResponse {

    private String status;
    private ReportResponseType response;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ReportResponseType getResponse() {
        return response;
    }

    public void setResponse(ReportResponseType response) {
        this.response = response;
    }
}
