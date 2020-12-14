package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.model.RejectedMail;
import com.turntablexe.turntabl.io.model.SheduleInterviewMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;

@Service
@Transactional
public class RejectedMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendrejectedmail(RejectedMail rejectedMail) throws AddressException, MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");

        helper.setTo(rejectedMail.getEmail());

        helper.setSubject(rejectedMail.getSubject());
        String bodyText= "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Mailing Service</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +"<div style=\"max-width: 800px; margin: auto; margin-top: 10% \" >\n" +
                "\t<div>\n"+
                "<img src='https://i.ibb.co/q0yLyTD/logo.jpg' style='float:left;width:90px;height:90px;'/>"+
                "\t<div>\n" +
                "\t<h3 align=\"right\">Turntabl Ghana Limited</h3>\n" +
                "\t <p align=\"right\">2nd Floor, Sonnidom House</p>\n" +
                "\t<p align=\"right\">Mile 7</p>\n" +
                "\t<p align=\"right\">Achimota, Accra</p>\n" +
                "\t<p align=\"right\">Monday 14 September 2020</p>\n" +
                "\t</div>\n" +
                "\n" +
                "\t<div align=\"left\">\n" +
                "\t\t<p> Dear " + rejectedMail.getFirst_name() +" ,  </p>\n" +
                "\t</div>\n" +
                "\n" +
                "\t<div align=\"center\">\n" +
                "\t\t<h1> Turntabl Application - Not Employed</h1>\n" +
                "\t</div>\n" +
                "\t<div align=\"left\">\n" +
                "\t\t<p>Thank you for declaring an interest in joining Turntabl. Unfortunately, due to the limited number of spaces and the large number of applicants, we are not able to employ you this year. </p>\n" +
                "\n" +
                "\t\t<p>However, we consider you an extremely credible candidate and would like to keep your information on file. Our plans for expansion are always developing and should an opportunity arise we’d like to be able to contact you again. If you would prefer not to be contacted, please just let us know.</p>\n" +
                "\n" +
                "\t\t<p>If you are happy for us to contact you please reply with your best phone number. If you would prefer we don’t contact you then please let me know.</p>\n" +
                "\t\t<p>We wish you all the best in your next venture and hope to see you in our next in take if not before! </p>\n" +
                "\n" +
                "\t\t<p>Kind regards,</p>\n" +
                "\t\t<p>Stoirm Arnold</p>\n" +
                "\t</div>\n" +
                "\t<div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        helper.setText(bodyText, true);
//        FileSystemResource res = new FileSystemResource(new File("C:/Users/Joshua/Desktop/turntablExe/Turntabl_Recruitment_Tracker/Backend/turntabl.io/src/main/java/com/turntablexe/turntabl/io/service/logo.jpg"));
//        helper.addInline("imagelogo",res);

        javaMailSender.send(msg);



    }

}
