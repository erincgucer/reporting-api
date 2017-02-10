package com.clearsettle.model.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by egucer on 10-Feb-17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportRequest {

    @JsonFormat(pattern = "YYYY-MM-DD")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date fromDate;

    @JsonFormat(pattern = "YYYY-MM-DD")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date toDate;

    private Integer merchant;

    private Integer acquirer;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getMerchant() {
        return merchant;
    }

    public void setMerchant(Integer merchant) {
        this.merchant = merchant;
    }

    public Integer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Integer acquirer) {
        this.acquirer = acquirer;
    }

}
