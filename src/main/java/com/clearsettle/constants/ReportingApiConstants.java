package com.clearsettle.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by egucer on 09-Feb-17.
 */
@Component
public class ReportingApiConstants {

    @Value("${urlPrefix}")
    private String urlPrefix;

    @Value("${urlMerchantLogin}")
    private String urlMerchantLogin;

    @Value("${urlTransactionReport}")
    private String urlTransactionReport;

    @Value("${urlGetClient}")
    private String urlGetClient;

    @Value("${urlGetMerchant}")
    private String urlGetMerchant;

    public String getUrlMerchantLogin(){
        return urlPrefix + urlMerchantLogin;
    }

    public String getUrlTransactionReport() {
        return urlPrefix + urlTransactionReport;
    }

    public String getUrlGetClient() {
        return urlPrefix + urlGetClient;
    }

    public String getUrlGetMerchant() {
        return urlPrefix + urlGetMerchant;
    }
}
