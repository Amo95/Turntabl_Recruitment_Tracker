package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.model.PasswordResetToken;
import com.turntablexe.turntabl.io.model.Register;
import com.turntablexe.turntabl.io.model.VerificationToken;
import com.turntablexe.turntabl.io.repository.PasswordResetTokenRepository;
import com.turntablexe.turntabl.io.repository.RegistrationRepository;
import com.turntablexe.turntabl.io.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private HttpServletRequest request;

    private final EmailSenderService emailSenderService;

    public void sendVerificationEmail(String userMail, String verificationToken){
        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Mail Confirmation Link!");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setText(
                "Thank you for registering. Please click link the below to activate your account." +
                        "http://"+request.getServerName()+":"+
                        request.getServerPort()+"/register/confirm?token="
                        + verificationToken
        );

        emailSenderService.sendEmail(mailMessage);
    }

    public void resendVerificationEmail(String userMail, String verificationToken){
        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Resend Verification Mail!");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setText(
                "Thank you for registering. Please click link the below to activate your account." +
                        "http://"+request.getServerName()+":"+
                        request.getServerPort()+"/register/confirm?token="
                        + verificationToken
        );

        emailSenderService.sendEmail(mailMessage);
    }

    public void resetPasswordMailToken(String userMail, String verificationToken){

        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Reset Password!");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setText(

                "Click the link below to reset your password." + "http://"+request.getServerName()+":"+
                        request.getServerPort()+"/changePassword?token="
                        + verificationToken +"&"+
                        "email="+userMail
        );

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

    public  Register findUserByEmail(String email){
        return registrationRepository.getByEmail(email);
    }

    public Register getUser(final String verificationToken){
        final VerificationToken token = verificationTokenRepository.getByVerificationToken(verificationToken);

        if (token != null){
            return token.getRegister();
        }
        return null;
    }

    public boolean emailExists(final String email){
        return registrationRepository.findByEmail(email).isPresent();
    }


    public void changeUserPassword(final Register register, final String password){
        register.setPassword(passwordEncoder.encode(password));
        registrationRepository.save(register);
    }

    public boolean checkIfValidOldPassword(final Register register, final String oldPassword){
        return passwordEncoder.matches(oldPassword, register.getPassword());
    }

    public void createPasswordResetTokenForUser(final Register register, String token){
        final PasswordResetToken myToken = new PasswordResetToken(token, register);
        passwordResetTokenRepository.save(myToken);
    }

    public Optional<Register> getRegisterByPasswordResetToken(final String token){
        return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getRegister());
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
