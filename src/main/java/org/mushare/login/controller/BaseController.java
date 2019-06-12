package org.mushare.login.controller;

import org.mushare.login.manager.RegisterManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    @Autowired
    protected RegisterManager registerManager;

    public String sdkSecret(HttpServletRequest request) {
        return request.getHeader("sdkSecret");
    }

}
