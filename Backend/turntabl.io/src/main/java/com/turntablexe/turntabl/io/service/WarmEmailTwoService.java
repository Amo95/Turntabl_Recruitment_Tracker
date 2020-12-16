package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.model.WarmEmailTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class WarmEmailTwoService {
    @Autowired
    private JavaMailSender javaMailSender;

    private String generateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy ");
        return LocalDateTime.now().format(formatter);
    }
    public void sendwarmEmailTwomail(WarmEmailTwo warmEmailTwo) throws AddressException, MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");

        helper.setTo(warmEmailTwo.getEmail());

        helper.setSubject("Turntabl Application - Welcome to Turntabl");
        String bodyText = "<!DOCTYPE html>\n" +
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
                "\t<p align=\"right\">" +generateDateTime() + "</p>\n" +
                "\t</div>\n" +
                "\n" +
                "\t<div align=\"left\">\n" +
                "\t\t<p> Hi " + warmEmailTwo.getFirst_name() +" ,  </p>\n" +
                "\t</div>\n" +
                "\n" +
                "\t<div align=\"center\">\n" +
                "\t\t<h1> Turntabl Application - Welcome to turntabl</h1>\n" +
                "\t</div>\n" +
                "\t<div align=\"left\">\n" +
                "\t\t<p>Congratulations on your successful application to work for turntabl!</p>\n" +
                "\n" +
                "\t\t<p>Our target start date is "  + warmEmailTwo.getStarting_date() +", which is when the 3-month TLC training program shall commence. Prior to starting we ask that you complete the below form, providing us with relevant contact information and bank details</p>\n" +
                "\t\t<a href=\"https://www.google.com\"> <button style=\"background-color: green; color: white;\">Applicant Detail Form</button></a>" +
                "\t\n" +
                "\t\t<p>We process payroll twice a month, meaning you will either be paid on 7th or 21st of the month, which day will be confirmed when you start. We are still working on starting salaries, however last year the gross salary per month was 2,100 GHS, increasing to 2,500 GHS once the training program was completed. This figure may vary slightly for National Service employees.</p>\n" +
                "\n" +
                "\t\t<p>If you are looking to do your National Service with us, and you haven't already provided your NS number, please email it to me. If you have been posted for your National Service we may also need the details of where you were being posted so we can get you transferred. If it's not possible for you to do your National Service with us this year due to deadlines, we would still like to employ you this year and will have you do your National Service with us next year.</p>\n" +
                "\n" +
                "\t\t\n" +
                "\t\t<p>I imagine you will have plenty of questions, so please don’t hesitate to email me at any time, or if you’d prefer to call or Whatsapp my number is +44 7771 711664. In the next couple of weeks we’ll give you a call to check in, it’ll be a good opportunity to introduce myself formally if I haven't already!</p>\n" +
                "\n" +
                "\t\t\n" +
                "\n" +
                "\t\t<p>I look forward to speaking to you soon</p>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t<p>Thanks,</p>\n" +
                "\n" +
                "\t\t<p>Stoirm Arnold</p>\n" +
                "\t\t<p>COO</p>\n" +
                "\t\t<p>Turntabl</p>\n" +
                "\t</div>\n" +
                "\t</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        helper.setText(bodyText, true);
        javaMailSender.send(msg);
    }

}
