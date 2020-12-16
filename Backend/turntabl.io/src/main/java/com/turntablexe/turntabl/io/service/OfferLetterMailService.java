package com.turntablexe.turntabl.io.service;

import com.itextpdf.text.DocumentException;
import com.turntablexe.turntabl.io.model.OfferLetterMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.XMLResource;


import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
;
import javax.mail.internet.MimeMessage;

import javax.transaction.Transactional;
import java.io.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
;
@Service
@Transactional
public class OfferLetterMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private String generateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy ");
        return LocalDateTime.now().format(formatter);
    }

    public void sendoffermail(OfferLetterMail offerLetterMail) throws AddressException, MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");

        helper.setTo(offerLetterMail.getEmail());

        helper.setSubject(offerLetterMail.getSubject());
        String bodyText = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Mailing Service</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div style=\"max-width: 800px; margin: auto; margin-top: 10% \" >\n" +
                "\t<div>\n" +
                "<img src='https://i.ibb.co/q0yLyTD/logo.jpg' style='float:left;width:90px;height:90px;'/>\n" +
                "\t<p align=\"right\"><strong>Turntabl Ghana Limited</strong></p>\n" +
                "\t <p align=\"right\">2nd Floor, Sonnidom House</p>\n" +
                "\t<p align=\"right\">Mile 7</p>\n" +
                "\t<p align=\"right\">Achimota, Accra</p>\n" +
                "\t<p align=\"right\">" + generateDateTime()+ "</p>\n" +
                "\t</div>\n" +
                "\n" +
                "\t<div align=\"left\">\n" +
                "\t\t<p> Dear " + offerLetterMail.getFirst_name() +" ,  </p>\n" +
                "\t</div>\n" +
                "\n" +
                "\t<div align=\"center\">\n" +
                "\t\t<h1> Offer Letter - " + offerLetterMail.getSubject() +" </h1>\n" +
                "\t</div>\n" +
                "\t<div align=\"left\">\n" +
                "\t\t<p>Turntabl is delighted to offer you the position of "+ offerLetterMail.getSubject() +", starting on " + offerLetterMail.getStarting_date() +". Standard working hours are 09:00 - 18:00 with a 1 hour lunch break. The working\n" +
                "\t\thours may vary depending on business requirements. During the training, the start time will be 08:45. Your place of work will be: </p>\n" +
                "\n" +
                "\t \t<p align=\"left\">2nd Floor, Sonnidom House</p>\n" +
                "\t\t<p align=\"left\">Mile 7</p>\n" +
                "\t\t<p align=\"left\">Achimota, Accra</p>\n" +
                "\n" +
                "\n" +
                "\t\t<p>Your full-time employment as a turntabl Analyst starts on" + offerLetterMail.getStarting_date() +", when our TLC training program begins, which will run for approximately 3 months. Following successful completion of the training you will be a full-time turntabl Associate.</p>\n" +
                "\n" +
                "\t\t<p>Your starting wage will be " + offerLetterMail.getSalary() +". This is due to increase once you complete the training, the exact amount will be confirmed nearer the time. Wages are paid monthly on 7th / 21st of the month. Your first salary will be paid on " + offerLetterMail.getFirst_salary_date() +" for the period " +  offerLetterMail.getFirst_salary_period() +". Your next pay will be on " + offerLetterMail.getNext_salary_date() +" for the period "+ offerLetterMail.getNext_salary_period() +".</p>\n" +
                "\t\t<p>You will receive comprehensive healthcare as part of your package </p>\n" +
                "\t\t<p> All employment policies will be available to access on Github on your first day. We will contact you for any further information that is required. We ask that all information is returned as swiftly as possible to ensure a smooth onboarding process.</p>\n" +
                "\n" +
                "\t\t<p>Please let me know if you have any questions or I can provide any additional information.</p>\n" +
                "\t\t<p>We look forward to you welcoming you as part of the team!</p>\n" +
                "\n" +
                "\n" +
                "\t\t<p>Kind regards,</p>\n" +
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

        // trying to convert xhtml to PDF
        ByteArrayResource htmlBytes = new ByteArrayResource(bodyText.getBytes());
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        org.w3c.dom.Document document = XMLResource.load(new ByteArrayInputStream(bodyText.getBytes())).getDocument();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument( document, null );
        renderer.layout();
        try {
            renderer.createPDF(byteArrayOutputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        renderer.finishPDF();
        byteArrayOutputStream.close();
        helper.addAttachment(offerLetterMail.getFirst_name() + ".pdf", new ByteArrayResource(byteArrayOutputStream.toByteArray()));

        javaMailSender.send(msg);




}
}
