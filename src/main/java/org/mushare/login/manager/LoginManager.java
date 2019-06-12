package org.mushare.login.manager;

import org.mushare.login.domain.App;
import org.mushare.login.spec.request.LoginEmailRequest;
import org.mushare.login.spec.response.LoginResponse;
import org.mushare.login.spec.response.OperationResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginManager extends BaseManager {

    OperationResponse loginWithEmail(LoginEmailRequest loginEmailRequest, String sdkSecret) {
        App app = appDao.getBySdkSecret(sdkSecret);
        if (app == null) {
            return LoginResponse.errorSecretKey();
        }

        return LoginResponse.builder().build();
    }

}
