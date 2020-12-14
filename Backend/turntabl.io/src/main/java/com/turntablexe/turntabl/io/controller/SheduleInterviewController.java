package com.turntablexe.turntabl.io.controller;

import com.turntablexe.turntabl.io.model.SheduleInterviewMail;
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
public class SheduleInterviewController {
    @Autowired
    private SheduleInterviewMailService sheduleInterviewMailService;

    @PostMapping("/sheduleinterview")
    public String sendEmail(@RequestBody SheduleInterviewMail sheduleInterviewMail) throws AddressException, MessagingException, IOException {
        sheduleInterviewMailService.sendinterviewmail(sheduleInterviewMail);
        return "Email sent successfully";
    }
}
