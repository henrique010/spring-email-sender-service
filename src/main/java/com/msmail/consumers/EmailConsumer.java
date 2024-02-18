package com.msmail.consumers;

import com.msmail.domain.email.EmailEntity;
import com.msmail.domain.email.dtos.EmailDTO;
import com.msmail.services.EmailService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmailConsumer {
    private final EmailService emailService;
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void processMessage(@Payload @Valid EmailDTO data) {
        emailService.sendEmail(data);
    }
}
