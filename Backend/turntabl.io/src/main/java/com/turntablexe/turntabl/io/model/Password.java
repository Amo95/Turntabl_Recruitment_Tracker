package com.turntablexe.turntabl.io.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Password {
    private String oldPassword;
    private String token;
    private String newPassword;
}
