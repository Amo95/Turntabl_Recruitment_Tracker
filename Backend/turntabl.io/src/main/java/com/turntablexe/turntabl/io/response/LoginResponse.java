package com.turntablexe.turntabl.io.response;

public class LoginResponse {

    private String id;
    private String email;
    private boolean enable;


    public LoginResponse(String id, String email, boolean enable) {
        this.id = id;
        this.email = email;
        this.enable = enable;
    }


    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEnable() {
        return enable;
    }
}
