package com.turntablexe.turntabl.io.controller;

import com.turntablexe.turntabl.io.model.OfferLetterMail;
import com.turntablexe.turntabl.io.service.OfferLetterMailService;
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

public class OfferLetterMailController {
    @Autowired
    private OfferLetterMailService offerLetterMailService;


    @PostMapping("/offerletter")
    public String sendEmail(@RequestBody OfferLetterMail offerLetterMail) throws AddressException, MessagingException, IOException {
        offerLetterMailService.sendoffermail(offerLetterMail);
        return "Email sent successfully";
    }
}
