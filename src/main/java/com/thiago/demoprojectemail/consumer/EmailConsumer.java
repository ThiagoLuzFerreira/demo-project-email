package com.thiago.demoprojectemail.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thiago.demoprojectemail.consumer.dto.EmailDTO;
import com.thiago.demoprojectemail.model.Email;
import com.thiago.demoprojectemail.model.StatusEmail;
import com.thiago.demoprojectemail.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Component
public class EmailConsumer {

    private final Logger logger = Logger.getLogger(EmailConsumer.class.getName());

    private final EmailService service;

    public EmailConsumer(EmailService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${mq.queues.email-queue}")
    public void listenerEmailQueue(@Payload String payload) {
        var parsedEmailDTO = parser(payload, EmailDTO.class);
        Email email = new Email(parsedEmailDTO.id().toString(), "", parsedEmailDTO.email(), parsedEmailDTO.subject(), parsedEmailDTO.text(), LocalDateTime.now(), StatusEmail.SENT);
        service.sendEmail(email);
        logger.info("Sending and saving email info");
        logger.info(email.toString());
    }

    private <T> T parser(String payload, Class<T> type) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(payload, type);
        } catch (JsonProcessingException e){
            logger.warning(e.getMessage());
            return null;
        }
    }
}
