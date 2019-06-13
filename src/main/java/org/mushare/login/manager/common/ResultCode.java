package org.mushare.login.manager.common;

public enum ResultCode {

    Success(901),
    AccessTokenError(902),
    NoPrivilege(903),
    SaveInternalError(904),

    SdkSecrectError(2001),
    EmailExist(2002),
    EmailNotExist(2003);

    public int code;

    private ResultCode(int code) {
        this.code = code;
    }

    public boolean equals(ResultCode code) {
        return this.code == code.code;
    }

    public Result result() {
        return Result.error(this);
    }

}

