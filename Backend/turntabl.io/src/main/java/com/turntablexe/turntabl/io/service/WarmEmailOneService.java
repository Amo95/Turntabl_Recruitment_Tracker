package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.model.WarmEmailOne;
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
public class WarmEmailOneService {


    @Autowired
    private JavaMailSender javaMailSender;

    private String generateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy ");
        return LocalDateTime.now().format(formatter);
    }
    public void sendwarmEmailOnemail(WarmEmailOne warmEmailOne) throws AddressException, MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");

        helper.setTo(warmEmailOne.getEmail());

        helper.setSubject("Turntabl Application - Starting Date");
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
                "\t<p align=\"right\">" +generateDateTime() + "</p>\n" +
                "\t</div>\n" +
                "\n" +
                "\t<div align=\"left\">\n" +
                "\t\t<p> Hi " + warmEmailOne.getFirst_name() +" ,  </p>\n"  +
                "\t</div>\n" +
                "\n" +
                "\t<div align=\"center\">\n" +
                "\t\t<h1> Turntabl Application - Start Date</h1>\n" +
                "\t</div>\n" +
                "\t<div align=\"left\">\n" +
                "\t\t<p>We’re looking forward to you finally being a part of the team! In a couple of weeks, on "  + warmEmailOne.getStarting_date() +" our TLC training program will begin at 09:00, and so will your journey with turntabl. We recommend you arrive at least 15 minutes before which will allow you to familiarise yourself with the office and get yourself comfortable. </p>\n" +
                "\n" +
                "\t\t<p>The training will be performed at our office at Mile 7, Achimota. A fundamental part of our culture is built during the training, it’s an interactive experience which is far more effective and enjoyable in person. However, if government guidance changes in relation to COVID-19 then we will act accordingly. There will be social distancing as well as sufficient sanitiser available. The full address is:</p>\n" +
                "\n" +
                "\t \t<p align=\"left\">2nd Floor, Sonnidom House</p>\n" +
                "\t\t<p align=\"left\">Mile 7</p>\n" +
                "\t\t<p align=\"left\">Achimota, Accra</p>\n" +
                "\n" +
                "\n" +
                "\t\t<p>You are not required to bring anything on your first day, all we ask is that you’re on time and you bring a smile! All equipment is provided.</p>\n" +
                "\n" +
                "\t\t<p>If you are enrolled for national service, you will be able to get your placement endorsed on your first day. We have spoken to the National Service Secretariat and they have confirmed this is ok. Ibrahim will be available to stamp the relevant documents during your lunch break</p>\n" +
                "\t\t<p>Prior to starting, we will need some updated details from you. We require the following:</p>\n" +
                "\n" +
                "\t\t<p> <i>Mobile number</i> - confirmation of the best number to contact you</p>\n" +
                "\n" +
                "\t\t<p><i>Whatsapp number</i> - if different to above</p>\n" +
                "\t\t<p><i>Family name</i> - Your full family name</p>\n" +
                "\t\t<p><i>Official name</i> - The name which appears on official documents ie passport, ID card</p>\n" +
                "\t\t<p><i>Known as name</i> - If you have several names and prefer to be known by a specific one, please specify a singular name</p>\n" +
                "\t\t<p><i>Chosen email address</i> - all our email addresses appear like this: <strong>inusa.ibrahim@turntabl.io</strong>, first name then surname. If you have multiple given names, please choose which first name and surname you would like to use. On the form there’s no need to write @turntabl.io, eg inusa.ibrahim</p>\n" +
                "\t\t<p><i>Address</i> - Please provide your full residential address</p>\n" +
                "\t\t<p><i>Tax ID</i> - only for non-national service</p>\n" +
                "\t\t<p><i>SSNIT number</i> - only for non-national service</p>\n" +
                "\t\t<p><i>Bank details</i> - Must be provided for you to be paid</p>\n" +
                "\n" +
                "\t\t<p>Please complete the below form. Some of this information you will have already provided, make sure you use the same email address you used before so you don’t have to enter it twice.</p>\n" +
                "\t\t<a href=\"https://www.google.com\"> <button style=\"background-color: green; color: white;\">Applicant Detail Form</button></a>" +
                "\t\t<p>If you are unsure of how to get to the office, please let me know and I’ll put you in touch with one of our current employees who will be able to advise you accordingly</p>\n" +
                "\n" +
                "\t\t<p>If you have any further questions please don’t hesitate to contact me. An official offer letter will be issued prior to your start date confirming pay, benefits and company policies.</p>\n" +
                "\n" +
                "\t\t<p>We look forward to seeing you in a couple of weeks!</p>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t<p>Best regards,</p>\n" +
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
