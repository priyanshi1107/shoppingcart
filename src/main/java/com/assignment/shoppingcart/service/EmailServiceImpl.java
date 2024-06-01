package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.dto.UserDto;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

@Service
public class EmailServiceImpl implements EmailService {
    private final TemplateEngine templateEngine;

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public String sendMail(UserDto userDto) throws MessagingException {
        Context context = new Context();
        context.setVariable("userDto", userDto);
        String process = templateEngine.process("emails/email", context);
        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("Order Successful. Thank You for shopping " + userDto.getFirstName());
        helper.setText(process, true);
        helper.setTo(userDto.getEmail());
        System.out.println(userDto.getEmail());
        javaMailSender.send(mimeMessage);
        return "index";
    }
}
