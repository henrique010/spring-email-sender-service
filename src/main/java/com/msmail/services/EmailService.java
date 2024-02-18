package com.msmail.services;

import com.msmail.domain.email.EmailEntity;
import com.msmail.domain.email.dtos.EmailDTO;
import com.msmail.domain.email.enums.StatusEmail;
import com.msmail.repositories.EmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EmailService {
    private final EmailRepository repository;
    private JavaMailSender javaMailSender;

    public EmailEntity sendEmail(EmailDTO data) {
        EmailEntity emailEntity = new EmailEntity();
        BeanUtils.copyProperties(data, emailEntity);

        emailEntity.setSendDate(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailEntity.getEmailFrom());
            message.setTo(emailEntity.getEmailTo());
            message.setSubject(emailEntity.getSubject());
            message.setText(emailEntity.getContent());

            this.javaMailSender.send(message);

            emailEntity.setStatus(StatusEmail.SENT);
        } catch (MailException exception) {
            emailEntity.setStatus(StatusEmail.ERROR);
        }

        return this.repository.save(emailEntity);
    }
}
