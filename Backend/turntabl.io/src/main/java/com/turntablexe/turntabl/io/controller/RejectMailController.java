package com.turntablexe.turntabl.io.controller;
import com.turntablexe.turntabl.io.model.RejectedMail;
import com.turntablexe.turntabl.io.service.RejectedMailService;

import com.turntablexe.turntabl.io.service.SheduleInterviewMailService;
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
public class RejectMailController {
    @Autowired
    private RejectedMailService rejectedMailService;


    @PostMapping("/rejectedmail")
    public String sendEmail(@RequestBody RejectedMail rejectedMail) throws AddressException, MessagingException, IOException {
        rejectedMailService.sendrejectedmail(rejectedMail);
        return "Email sent successfully";
    }
}
