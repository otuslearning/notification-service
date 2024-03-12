package com.example.notificationservice.api;


public interface MessageService {
    ListMessagesResponseDto getMessagesForOwner();
    void sendMessage(String userAccountGuid, MessageDto message);
}
