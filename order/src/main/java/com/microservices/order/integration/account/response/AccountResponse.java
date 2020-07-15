package com.microservices.order.integration.account.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class AccountResponse {

    private UUID accountId;
    private String name;
    private int age;
    private String document;

}
