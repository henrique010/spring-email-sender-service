package com.msmail.controllers;

import com.msmail.domain.email.EmailEntity;
import com.msmail.domain.email.dtos.EmailDTO;
import com.msmail.services.EmailService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
@AllArgsConstructor
public class EmailController {
    private final EmailService emailService;
    @PostMapping("/send")
    public ResponseEntity<EmailEntity> send(@RequestBody @Valid EmailDTO data) {
        return ResponseEntity.ok(emailService.sendEmail(data));
    }
}
