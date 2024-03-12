package com.example.notificationservice.converter;

import com.example.notificationservice.api.MessageDto;
import com.example.notificationservice.domain.Message;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MessageConverter {

    public List<MessageDto> convert(List<Message> list) {
        return list.stream()
                .map(this::convert)
                .toList();
    }

    public MessageDto convert(Message model) {
        return MessageDto.builder()
                .content(model.getContent())
                .build();
    }

    public Message convert(MessageDto dto) {
        Message message = new Message();
        message.setContent(dto.getContent());
        return message;
    }

}
