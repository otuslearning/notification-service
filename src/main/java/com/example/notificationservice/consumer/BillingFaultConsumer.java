package com.example.notificationservice.consumer;

import com.example.notificationservice.api.BillDebitFaultEvent;
import com.example.notificationservice.api.MessageDto;
import com.example.notificationservice.api.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BillingFaultConsumer {

    private final ObjectMapper mapper;
    private final MessageService messageService;
    private static final String BILL_VALUE_LESS_NIL = "Insufficient funds in the personal account";
    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${kafka.topics.billing-fault}")
    public void consume(String message) {
        try {
            BillDebitFaultEvent billingSuccessEvent = mapper.readValue(message, BillDebitFaultEvent.class);
            messageService.sendMessage(billingSuccessEvent.getUserAccountGuid(),
                    MessageDto.builder()
                            .content(String.format(BILL_VALUE_LESS_NIL))
                            .build()
                    );
        } catch (JsonProcessingException e) {
            log.error("Error parsing message: {}", message, e);
        }

    }
}
