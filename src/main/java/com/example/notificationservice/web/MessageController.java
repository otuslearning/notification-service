package com.example.notificationservice.web;

import com.example.notificationservice.api.ListMessagesResponseDto;
import com.example.notificationservice.api.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${application.web.prefix.public}/messages")
public class MessageController {
    private final MessageService messageService;
    @GetMapping
    public ListMessagesResponseDto getMessagesForOwner() {
        return messageService.getMessagesForOwner();
    }

}
