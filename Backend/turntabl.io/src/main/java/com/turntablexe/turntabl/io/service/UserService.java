package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.model.Register;
import com.turntablexe.turntabl.io.model.VerificationToken;
import com.turntablexe.turntabl.io.repository.RegistrationRepository;
import com.turntablexe.turntabl.io.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.text.MessageFormat;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    private final EmailSenderService emailSenderService;

    public void sendVerificationEmail(String userMail, String verificationToken){
        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Mail Confirmation Link!");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setText(
                "Thank you for registering. Please click link the below to activate your account." + "http://localhost:8081/register/confirm?token="
                        + verificationToken);

        emailSenderService.sendEmail(mailMessage);
    }

    public void resendVerificationEmail(String userMail, String verificationToken){
        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Resend Verification Mail!");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setText(
                "Thank you for registering. Please click link the below to activate your account." + "http://localhost:8081/register/confirm?token="
                        + verificationToken);

        emailSenderService.sendEmail(mailMessage);
    }

    public void confirmUser(VerificationToken token){
        final Register register = token.getRegister();
        register.setEnabled(true);
        registrationRepository.save(register);
    }


    public void saveUser(Register register){
        registrationRepository.save(register);
    }

    public Optional<Register> fetchUserByEmail(String email){
       return registrationRepository.findByEmail(email);
    }

    public Register getUser(final String verificationToken){
        final VerificationToken token = verificationTokenRepository.getByVerificationToken(verificationToken);

        if (token != null){
            return token.getRegister();
        }
        return null;
    }

    public Register fetchUserByPassword(String password){
        return registrationRepository.findByPassword(password);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        final Optional<Register> optionalUser = registrationRepository.findByEmail(email);


        if (optionalUser.isPresent()) {
            return (UserDetails) optionalUser.get();
        }
        else {

            //if user is not found, throw username not found exception.
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email));
        }
    }
}
