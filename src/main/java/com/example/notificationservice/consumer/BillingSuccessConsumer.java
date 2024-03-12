package com.example.notificationservice.consumer;

import com.example.notificationservice.api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BillingSuccessConsumer {

    private final ObjectMapper mapper;
    private final MessageService messageService;
    private static final String ORDER_GUID_PAID = "Order guid: %s is paid";
    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${kafka.topics.billing-success}")
    public void consume(String message) {
        try {
            BillDebitSuccessEvent billingSuccessEvent = mapper.readValue(message, BillDebitSuccessEvent.class);
            messageService.sendMessage(billingSuccessEvent.getUserAccountGuid(),
                    MessageDto.builder()
                            .content(String.format(ORDER_GUID_PAID, billingSuccessEvent.getOrderGuid()))
                            .build()
                    );
        } catch (JsonProcessingException e) {
            log.error("Error parsing message: {}", message, e);
        }

    }
}
