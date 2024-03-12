package com.example.notificationservice.api;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BillDebitFaultEvent {
    private String userAccountGuid;
    private String personalAccountGuid;
    private String orderGuid;
}
