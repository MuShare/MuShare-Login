package org.mushare.login.controller.common;

import com.google.common.collect.ImmutableMap;
import org.mushare.login.manager.LoginManager;
import org.mushare.login.manager.RegisterManager;
import org.mushare.login.manager.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BaseController {

    @Autowired
    protected RegisterManager registerManager;

    @Autowired
    protected LoginManager loginManager;

    protected Map sdkSecretErrorMap = ImmutableMap.of(ResultCode.SdkSecrectError, ErrorCode.ErrorSdkSecret);

    public String sdkSecret(HttpServletRequest request) {
        return request.getHeader("sdkSecret");
    }

    protected String getRemoteIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
