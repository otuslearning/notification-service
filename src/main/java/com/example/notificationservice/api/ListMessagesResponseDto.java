package com.example.notificationservice.api;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class ListMessagesResponseDto {
    @Builder.Default
    List<MessageDto> content = new ArrayList<>();
    @Builder.Default
    private Integer total = 0;
}
