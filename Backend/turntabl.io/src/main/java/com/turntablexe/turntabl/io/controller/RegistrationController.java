package com.turntablexe.turntabl.io.controller;

import com.turntablexe.turntabl.io.exception.UserAlreadyExistException;
import com.turntablexe.turntabl.io.exception.WrongPasswordException;
import com.turntablexe.turntabl.io.model.Register;
import com.turntablexe.turntabl.io.model.ResetPassword;
import com.turntablexe.turntabl.io.model.VerificationToken;
import com.turntablexe.turntabl.io.service.PasswordSecurityService;
import com.turntablexe.turntabl.io.service.UserService;
import com.turntablexe.turntabl.io.service.VerificationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordSecurityService passwordSecurityService;

    @Autowired
    private final VerificationTokenService verificationTokenService;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public void registerUser(@RequestBody Register register) throws Exception {

        if (register.getPassword().equals(register.getConfirmPassword())){
            String tempEmail = register.getEmail();
            final String encryptedPassword = bCryptPasswordEncoder.encode(register.getPassword());
            register.setPassword(encryptedPassword);

            if (userService.emailExists(tempEmail)){
                throw new UserAlreadyExistException("These email "+tempEmail+" already exits");
            }

            userService.saveUser(register);

            final VerificationToken verificationToken = new VerificationToken(register);
            verificationTokenService.saveVerificationToken(verificationToken);
            userService.sendVerificationEmail(register.getEmail(), verificationToken.getVerificationToken());
        }else {
            throw new WrongPasswordException("ResetPassword don't match");
        }

    }

    @GetMapping("/register/confirm")
    String confirmEmail(@RequestParam("token") String token){
        String result = verificationTokenService.validateVerificationToken(token);

        if (result.equals("invalidToken")){
            return "User token is not found";
        }

        if (result.equals("expired")){
            return "Token has expired";
        }

        Optional<VerificationToken> optionalVerificationToken = verificationTokenService.findVerificationToken(token);
        optionalVerificationToken.ifPresent(userService::confirmUser);
        return "user confirmed";

    }

    @PostMapping("/login")
    public Object loginUser(@RequestBody Register register) throws Exception {

        Optional<String> errorMessage = Optional.of("Wrong username/password");


        Optional<Register> userDetails = userService.fetchUserByEmail(register.getEmail());

        if (userDetails.isPresent()){
            Register userInfoInDB = userDetails.get();

            if(!userInfoInDB.isEnabled()){
                throw new Exception("User account is not enabled");
            }else {
                if (bCryptPasswordEncoder.matches(register.getPassword(), userInfoInDB.getPassword())) {
                    return userDetails;
                }
            }


        }
        return errorMessage;
    }

    @PostMapping("/resetPassword")
    String resetPassword(@RequestParam("email") final String  userMail){
        final Register register = userService.findUserByEmail(userMail);
        if (register != null){
            final String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(register, token);
            userService.resetPasswordMailToken(register.getEmail(), token);
            return "change password page";
        }
        return null;
    }


    @PostMapping("/user/updatePassword")
    public String changeUserPassword(@RequestBody ResetPassword password, @RequestParam("email") String userMAil, @RequestParam("token") String  token){
        final String result = passwordSecurityService.validatePasswordResetToken(token);

        if (result != null){
            return result;
        }

        Optional<Register> register = userService.getRegisterByPasswordResetToken(token);

        if (register.isPresent()){
            if (password.getNewPassword().equals(password.getConfirmPassword())){
                userService.changeUserPassword(register.get(), password.getNewPassword());
                return "Password changed successfully";
            }else {
                return "Mismatch password";
            }
        }
        return "Invalid token/email";

    }



    @GetMapping("/user/resendVerificationToken")
    public String resendVerificationToken(@RequestParam("token") String existingToken){
        final VerificationToken newToken = verificationTokenService.generateNewVerificationToken(existingToken);
        final Register register = userService.getUser(newToken.getVerificationToken());
        userService.resendVerificationEmail(register.getEmail(), newToken.getVerificationToken());

        return "Mail resend";
    }


}

