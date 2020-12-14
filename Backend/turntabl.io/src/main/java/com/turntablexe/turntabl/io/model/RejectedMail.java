package com.turntablexe.turntabl.io.model;

public class RejectedMail {
    private int id;
    private  String first_name;
    private String email;
    private String subject;


    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }


}
