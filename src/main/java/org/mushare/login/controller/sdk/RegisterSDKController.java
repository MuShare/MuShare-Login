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
@RequestMapping("/sdk/register")
public class RegisterSDKController extends BaseController {

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public ResponseEntity registerByEmail(@RequestParam String address, @RequestParam String password,
                                          @RequestParam String name, HttpServletRequest request) {
        Result result = registerManager.registerByEmail(address, password, name, sdkSecret(request));
        if (result.hasError()) {
            return result.errorMapping(ImmutableMap.of(
                    ResultCode.SdkSecrectError, ErrorCode.ErrorSdkSecret,
                    ResultCode.EmailExist, ErrorCode.ErrorEmailExist
            ));
        }
        return Response.success().build();
    }

}
