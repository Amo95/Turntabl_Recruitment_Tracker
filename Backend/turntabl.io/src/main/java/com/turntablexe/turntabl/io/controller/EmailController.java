//package com.turntablexe.turntabl.io.controller;
//
//import com.turntablexe.turntabl.io.service.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.AddressException;
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api/turntablexe/email")
//public class EmailController {
//    @Autowired
//    EmailService emailService;
//
//    @PostMapping("/sendmail")
//    public String send() throws MessagingException, IOException {
//        //sendEmail();
//            emailService.sendEmail("joshua.lartey@turntabl.io","Hello Word", "Thank you for declaring an interest in joining Turntabl. Unfortunately, due to the limited number of spaces and the large number of applicants, we are not able to employ you this year.\n" +
//                    "\n" +
//                    "However, we consider you an extremely credible candidate and would like to keep your information on file. Our plans for expansion are always developing and should an opportunity arise we’d like to be able to contact you again. If you would prefer not to be contacted, please just let us know.\n" +
//                    "\n" +
//                    "We wish you all the best in your next venture and hope to see you at Global Code 2021, if not before!");
//        return "Email sent successfully";
//
//    }
//}
