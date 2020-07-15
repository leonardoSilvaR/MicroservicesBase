package com.microservices.order.integration.account;

import com.microservices.order.integration.account.response.AccountResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountIntegration {

    private final RestTemplateBuilder restTemplateBuilder;

    public AccountResponse retrieveAccount(@NonNull UUID accountId) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/account/v1/accounts/{accountId}")
                .buildAndExpand(accountId)
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        ResponseEntity<AccountResponse> accountResponse = restTemplateBuilder.build().exchange(requestEntity, AccountResponse.class);

        return accountResponse.getBody();
    }


}
