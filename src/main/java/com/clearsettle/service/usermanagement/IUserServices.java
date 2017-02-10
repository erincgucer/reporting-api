package com.clearsettle.service.usermanagement;

import com.clearsettle.model.usermanagement.ClientRequest;
import com.clearsettle.model.usermanagement.ClientResponse;
import com.clearsettle.model.usermanagement.MerchantRequest;
import com.clearsettle.model.usermanagement.MerchantResponse;

/**
 * Created by egucer on 10-Feb-17.
 */
public interface IUserServices {

    public MerchantResponse getMerchant(MerchantRequest merchantRequest, String token);
    public ClientResponse getClient(ClientRequest clientRequest, String token);
}
