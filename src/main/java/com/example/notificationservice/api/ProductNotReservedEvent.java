package com.example.notificationservice.api;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductNotReservedEvent {
    private String productGuid;
    private String orderGuid;
}
