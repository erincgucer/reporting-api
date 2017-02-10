package com.clearsettle.model.transaction;

/**
 * Created by egucer on 10-Feb-17.
 */
public class ReportResponseType {

    private Integer count;
    private Integer total;
    private String currency;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
