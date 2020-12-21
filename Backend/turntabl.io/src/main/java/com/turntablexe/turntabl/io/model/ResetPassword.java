package com.turntablexe.turntabl.io.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResetPassword {

    private String newPassword;
    private String confirmPassword;
}
