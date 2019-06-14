package org.mushare.login.controller.sdk;

import com.google.common.collect.ImmutableMap;
import org.mushare.login.controller.common.BaseController;
import org.mushare.login.controller.common.ErrorCode;
import org.mushare.login.controller.common.Response;
import org.mushare.login.manager.common.Result;
import org.mushare.login.manager.common.ResultCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sdk/login")
public class LoginSDKController extends BaseController {

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public ResponseEntity loginByEmail(@RequestParam String address, @RequestParam String password,
                                       @RequestParam String identifier, @RequestParam String os,
                                       @RequestParam String version, @RequestParam String language,
                                       HttpServletRequest request) {
        Result<String> result = loginManager.loginWithEmail(address, password, identifier, os, version,
                getRemoteIP(request), language, sdkSecret(request));
        if (result.hasError()) {
            return result.errorMapping(sdkSecretErrorMap, ImmutableMap.of(
                    ResultCode.UnknownOS, ErrorCode.ErrorIllegalIDeviceOS,
                    ResultCode.EmailNotExist, ErrorCode.ErrorEmailNotExist,
                    ResultCode.PasswordError, ErrorCode.ErrorPasswordWrong,
                    ResultCode.PersonNotExsit, ErrorCode.ErrorPersonNotFound
            ));
        }
        return Response.success()
                .append("accessToken", result.getData())
                .build();
    }

}
