package com.turntablexe.turntabl.io.model;

import com.turntablexe.turntabl.io.validation.ValidEmail;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Register")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

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

    @Builder.Default
    private boolean enabled = false;
}
