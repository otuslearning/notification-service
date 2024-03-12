package com.example.notificationservice.api;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequestContextDto {
    private String accountGuid;
}
