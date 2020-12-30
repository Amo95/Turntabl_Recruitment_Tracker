package com.turntablexe.turntabl.io.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ResetPassword {

    private String newPassword;
    private String confirmPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
