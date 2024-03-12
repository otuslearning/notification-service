package com.example.notificationservice.service;

import com.example.notificationservice.api.ListMessagesResponseDto;
import com.example.notificationservice.api.MessageDto;
import com.example.notificationservice.api.MessageService;
import com.example.notificationservice.api.RequestContextService;
import com.example.notificationservice.converter.MessageConverter;
import com.example.notificationservice.domain.Message;
import com.example.notificationservice.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final RequestContextService requestContextService;
    private final MessageConverter messageConverter;

    @Override
    public ListMessagesResponseDto getMessagesForOwner() {
        List<Message> messages = messageRepository.findByAccountGuid(
                requestContextService.getRequestContext().getAccountGuid());
        return ListMessagesResponseDto.builder()
                .content(messageConverter.convert(messages))
                .total(messages.size())
                .build();
    }

    @Override
    @Transactional
    public void sendMessage(String userAccountGuid, MessageDto dto) {
        Message message = messageConverter.convert(dto);
        message.setAccountGuid(userAccountGuid);
        message.setStatus("SEND");
        messageRepository.save(message);
    }

}
