package com.turntablexe.turntabl.io.controller;

import com.turntablexe.turntabl.io.model.Register;
import com.turntablexe.turntabl.io.model.VerificationToken;
import com.turntablexe.turntabl.io.service.UserService;
import com.turntablexe.turntabl.io.service.VerificationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private final VerificationTokenService verificationTokenService;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public void registerUser(@RequestBody Register register) throws Exception {
        String tempEmail = register.getEmail();
        final String encryptedPassword = bCryptPasswordEncoder.encode(register.getPassword());
        register.setPassword(encryptedPassword);

//        if (tempEmail != null && !"".equals(tempEmail)){
//            Optional<User> oldEmail =  registrationService.fetchUserByEmail(tempEmail);
//
//            if (oldEmail != null){
//                throw new Exception("User already exist");
//            }
//        }
        userService.saveUser(register);

        final VerificationToken verificationToken = new VerificationToken(register);
        verificationTokenService.saveVerificationToken(verificationToken);
        userService.sendVerificationEmail(register.getEmail(), verificationToken.getVerificationToken());
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
    public Optional<Register> loginUser(@RequestBody Register register) throws Exception {


        Optional<Register> userDetails = userService.fetchUserByEmail(register.getEmail());

        if (userDetails.isPresent()){
            Register userInfoInDB = userDetails.get();

            if(!userInfoInDB.isEnabled()){
                throw new Exception("User account is enabled");
            }else {
                if (bCryptPasswordEncoder.matches(register.getPassword(), userInfoInDB.getPassword())) {
                    return userDetails;
                }
            }


        }


        return null;
    }

    @GetMapping("/user/resendVerificationToken")
    public String resendVerificationToken(@RequestParam("token") String existingToken){
        final VerificationToken newToken = verificationTokenService.generateNewVerificationToken(existingToken);
        final Register register = userService.getUser(newToken.getVerificationToken());
        userService.resendVerificationEmail(register.getEmail(), newToken.getVerificationToken());

        return "Mail resend";
    }


}

