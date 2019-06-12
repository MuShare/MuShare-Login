package org.mushare.login.spec.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationResponse {

    private boolean succeed;
    private int code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object object;

    public static OperationResponse success() {
        return OperationResponse.builder().succeed(true).code(200).build();
    }

    public static OperationResponse errorSavingObject() {
        return OperationResponse.builder().succeed(false).code(801).build();
    }

}
