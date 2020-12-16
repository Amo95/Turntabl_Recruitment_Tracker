package com.turntablexe.turntabl.io.controller;

import com.turntablexe.turntabl.io.model.WarmEmailOne;
import com.turntablexe.turntabl.io.model.WarmEmailTwo;
import com.turntablexe.turntabl.io.service.WarmEmailOneService;
import com.turntablexe.turntabl.io.service.WarmEmailTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

@RestController
@RequestMapping("/api/turntablexe/email")
public class WarmEmailTwoController {

    @Autowired
    private WarmEmailTwoService warmEmailTwoService;


    @PostMapping("/warmemailtwo")
    public String sendEmail(@RequestBody WarmEmailTwo warmEmailTwo) throws AddressException, MessagingException, IOException {
        warmEmailTwoService.sendwarmEmailTwomail(warmEmailTwo);
        return "Email sent successfully";
    }

}
