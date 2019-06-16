package org.mushare.login.controller.sdk;

import org.mushare.login.controller.common.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sdk/person")
public class PersonSDKController {

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ResponseEntity myInfo(HttpServletRequest request) {

        return Response.success().build();
    }

    @RequestMapping(value = "/avatar/upload", method = RequestMethod.POST)
    public ResponseEntity uploadAvatar(HttpServletRequest request) {

        return Response.success().build();
    }


}
