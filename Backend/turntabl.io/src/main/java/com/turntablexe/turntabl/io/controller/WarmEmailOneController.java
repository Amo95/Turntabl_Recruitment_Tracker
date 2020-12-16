package com.turntablexe.turntabl.io.controller;

import com.turntablexe.turntabl.io.model.RejectedMail;
import com.turntablexe.turntabl.io.model.WarmEmailOne;
import com.turntablexe.turntabl.io.service.RejectedMailService;
import com.turntablexe.turntabl.io.service.WarmEmailOneService;
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
public class WarmEmailOneController {

    @Autowired
    private WarmEmailOneService warmEmailOneService;


    @PostMapping("/warmemailone")
    public String sendEmail(@RequestBody WarmEmailOne warmEmailOne) throws AddressException, MessagingException, IOException {
        warmEmailOneService.sendwarmEmailOnemail(warmEmailOne);
        return "Email sent successfully";
    }
}
