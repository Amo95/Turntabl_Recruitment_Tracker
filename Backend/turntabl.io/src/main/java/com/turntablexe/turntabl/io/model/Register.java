package com.turntablexe.turntabl.io.model;


import com.turntablexe.turntabl.io.validation.ValidEmail;
import lombok.*;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Register")
public class Register {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;


    @ValidEmail
    @NotNull
    @Size(min = 2)
    private String email;

    @NotNull
    private String password;

    @Transient
    @NotNull
    @Size(min = 2)
    private String confirmPassword;

    @OneToOne(mappedBy = "register")
    private ApplicantDatamodel applicantDatamodel;


    @Builder.Default
    private boolean enabled = false;



    public void setPassword(String password) {
        this.password = password;
    }

    public ApplicantDatamodel getApplicantDatamodel() {
        return applicantDatamodel;
    }

    public void setApplicantDatamodel(ApplicantDatamodel applicantDatamodel) {
        this.applicantDatamodel = applicantDatamodel;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
