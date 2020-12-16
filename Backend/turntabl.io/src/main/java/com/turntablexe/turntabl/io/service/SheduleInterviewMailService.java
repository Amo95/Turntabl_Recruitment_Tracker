package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.model.SheduleInterviewMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class SheduleInterviewMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private String generateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy ");
        return LocalDateTime.now().format(formatter);
    }

    public void sendinterviewmail(SheduleInterviewMail sheduleInterviewMail) throws AddressException, MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");

        helper.setTo(sheduleInterviewMail.getEmail());

       helper.setSubject(sheduleInterviewMail.getSubject());
        String bodyText= "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Mailing Service</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div style=\"max-width: 800px; margin: auto; margin-top: 10% \" >\n" +
                "\t<div>\n" +
                "<img src='https://i.ibb.co/q0yLyTD/logo.jpg' style='float:left;width:90px;height:90px;'/>" +
                "\t<h3 align=\"right\">Turntabl Ghana Limited</h3>\n" +
                "\t <p align=\"right\">2nd Floor, Sonnidom House</p>\n" +
                "\t<p align=\"right\">Mile 7</p>\n" +
                "\t<p align=\"right\">Achimota, Accra</p>\n" +
                "\t<p align=\"right\">"+ generateDateTime()+ "</p>\n" +
                "\t</div>\n" +
                "\n" +
                "\t<div align=\"left\">\n" +
                "\t\t<p> Dear " + sheduleInterviewMail.getFirst_name() +" ,  </p>\n" +
                "\t</div>\n" +
                "\n" +
                "\t<div align=\"center\">\n" +
                "\t\t<h1> Turntabl Application - Phone interview</h1>\n" +
                "\t</div>\n" +
                "\t<div align=\"left\">\n" +
                "\t\t<p>Earlier this year, when we were originally recruiting for our TLC program 2020 we had very limited resources and spaces available. When contacting you at the time, we advised that this scenario may change in the near future and that, should an opportunity arise, we would be in touch. </p>\n" +
                "\t\t<p>Well, circumstances have changed and we would like to call you early next week to discuss your availability to potentially work for turntabl, subject to a successful phone interview. If you have already enrolled to do your national service then we are happy to employ you as normal for your first year and enroll you for national service in your second year.</p>\n" +
                "\n" +
                "\t\t<p>If you are happy for us to contact you please reply with your best phone number. If you would prefer we don’t contact you then please let me know.</p>\n" +
                "\t\t<p> We look forward to hopefully speaking to you in the next couple of days.</p>\n" +
                "\t\t<p>Many thanks,</p>\n" +
                "\t\t<p>Stoirm Arnold</p>\n" +
                "\t</div>\n" +
                "\t<div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        helper.setText(bodyText, true);

        javaMailSender.send(msg);



    }


}
