package com.turntablexe.turntabl.io.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPassword {

    private String newPassword;
    private String confirmPassword;
}
