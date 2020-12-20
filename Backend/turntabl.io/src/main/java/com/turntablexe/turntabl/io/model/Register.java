package com.turntablexe.turntabl.io.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Register")
public class Register {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "register")
    private ApplicantDatamodel applicantDatamodel;

    public Register(){}

    public Register(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ApplicantDatamodel getApplicantDatamodel() {
        return applicantDatamodel;
    }

    public void setApplicantDatamodel(ApplicantDatamodel applicantDatamodel) {
        this.applicantDatamodel = applicantDatamodel;
    }
}
