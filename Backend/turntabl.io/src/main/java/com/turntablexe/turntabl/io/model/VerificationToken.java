package com.turntablexe.turntabl.io.model;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class VerificationToken {
    private static final int EXPIRATION = 60;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String verificationToken;

    @OneToOne(targetEntity = Register.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "register_id")
    private Register register;
    private Date expiryDate;


    public VerificationToken(final Register register) {
        super();

        this.verificationToken = UUID.randomUUID().toString();
        this.register = register;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public void updateToken(final String verificationToken) {
        this.verificationToken = verificationToken;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }
}
