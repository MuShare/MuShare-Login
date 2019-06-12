package org.mushare.login.spec.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationResponse {

    private boolean succeed;
    private int code;
    private String message;

    public static OperationResponse success() {
        return OperationResponse.builder().succeed(true).code(200).build();
    }

    public static OperationResponse errorSavingObject() {
        return OperationResponse.builder().succeed(false).code(801).build();
    }

    public static OperationResponse errorSecretKey() {
        return OperationResponse.builder()
                .succeed(false)
                .code(2001)
                .message("App secret key error")
                .build();
    }

}
