package org.mushare.login.spec.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse extends OperationResponse {

    private String idToken;

}
