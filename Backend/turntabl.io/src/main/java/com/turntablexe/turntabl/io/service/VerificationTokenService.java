package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.model.Register;
import com.turntablexe.turntabl.io.model.VerificationToken;
import com.turntablexe.turntabl.io.repository.RegistrationRepository;
import com.turntablexe.turntabl.io.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VerificationTokenService {

    public static final String TOKEN_INVALID = "invalidToken";
    public static final String TOKEN_EXPIRED = "expired";
    public static final String TOKEN_VALID = "valid";


    @Autowired
    private final VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private final RegistrationRepository registrationRepository;

    public void saveVerificationToken(VerificationToken token) {
        verificationTokenRepository.save(token);
    }

    public Optional<VerificationToken> findVerificationToken(String token) {
        return verificationTokenRepository.findByVerificationToken(token);
    }

    public String validateVerificationToken(String token){
        final VerificationToken verificationToken =  verificationTokenRepository.getByVerificationToken(token);


        if (verificationToken == null){
            return TOKEN_INVALID;
        }

        final Register register = verificationToken.getRegister();
        final Calendar calendar = Calendar.getInstance();

        if ((
                verificationToken.getExpiryDate().getTime()
                - calendar.getTime().getTime()
                )<=0)
        {
            verificationTokenRepository.delete(verificationToken);
            return TOKEN_EXPIRED;

        }
        register.setEnabled(true);
        registrationRepository.save(register);
        return TOKEN_VALID;
    }

    public VerificationToken generateNewVerificationToken(final  String existingVerificationToken){
        VerificationToken token = verificationTokenRepository.getByVerificationToken(existingVerificationToken);
        token.updateToken(UUID.randomUUID().toString());
        token = verificationTokenRepository.save(token);
        return token;
    }
}
