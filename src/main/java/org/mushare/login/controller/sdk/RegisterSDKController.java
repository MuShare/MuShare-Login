package org.mushare.login.controller.sdk;

import org.mushare.login.controller.BaseController;
import org.mushare.login.spec.request.RegisterEmailRequest;
import org.mushare.login.spec.response.OperationResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sdk/register")
public class RegisterSDKController extends BaseController {

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public OperationResponse registerByEmail(@RequestBody RegisterEmailRequest registerEmailRequest, HttpServletRequest request) {
        return registerManager.registerByEmail(registerEmailRequest, sdkSecret(request));
    }

}
