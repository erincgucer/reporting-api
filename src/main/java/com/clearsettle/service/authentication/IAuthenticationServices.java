package com.clearsettle.service.authentication;

import com.clearsettle.model.authentication.AuthenticationToken;
import com.clearsettle.model.authentication.User;

/**
 * Created by egucer on 09-Feb-17.
 */
public interface IAuthenticationServices {

    public AuthenticationToken login(User user);
}
