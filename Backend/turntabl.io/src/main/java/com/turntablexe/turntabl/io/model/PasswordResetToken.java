package com.turntablexe.turntabl.io.model;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class PasswordResetToken {
    private static final int EXPIRATION = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String token;

    @OneToOne(targetEntity = Register.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "register_id")
    private Register register;

    private Date expiryDate;

    public PasswordResetToken( final String token, final Register register){
        super();

        this.token = token;
        this.register = register;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

}
