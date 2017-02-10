package com.clearsettle.model.usermanagement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by egucer on 10-Feb-17.
 */
public class Merchant {

    private Integer id;
    private Integer parentId;
    private String name;

    @JsonProperty("3dStatu")
    private String d3Status;

    private String mcc;
    private String ipnUrl;
    private String apiKey;
    private String cpgKey;
    private String type;
    private String descriptor;
    private String secretKey;
    private String comType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getD3Status() {
        return d3Status;
    }

    public void setD3Status(String d3Status) {
        this.d3Status = d3Status;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getIpnUrl() {
        return ipnUrl;
    }

    public void setIpnUrl(String ipnUrl) {
        this.ipnUrl = ipnUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getCpgKey() {
        return cpgKey;
    }

    public void setCpgKey(String cpgKey) {
        this.cpgKey = cpgKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }
}
