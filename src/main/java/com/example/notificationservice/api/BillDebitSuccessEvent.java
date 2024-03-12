package com.example.notificationservice.api;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BillDebitSuccessEvent {
    private String userAccountGuid;
    private String orderGuid;
}
