package org.mushare.login.controller.common;

public enum ErrorCode {

    ErrorUnknown(800, "Unknown error."),
    ErrorNoSession(801, "Session is none or timeout."),
    ErrorNoPrivilge(802, "No privilege to invoke this method."),
    ErrorObjecId(803, "Object cannot be found by the object id."),
    ErrorSavingObject(804, "Internal error saving object."),

    ErrorSdkSecret(2001, "Sdk secret error!"),
    ErrorEmailExist(2011, "This email has been registered."),
    ErrorIllegalIDeviceOS(2021, "Device OS identifier should be web, iOs or android."),
    ErrorEmailNotExist(2022, "This email is not exsit."),
    ErrorPersonNotFound(2023, "Person not found with this email."),
    ErrorPasswordWrong(2024, "Password is wrong.");

    public int code;
    public String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
