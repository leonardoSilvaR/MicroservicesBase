package com.microservices.order.integration.account;

import com.microservices.order.integration.account.response.AccountResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountIntegration {

    private final RestTemplateBuilder restTemplateBuilder;
    @Value("${integrations.account.host}")
    private String accountHost;
    @Value("${integrations.account.retrieveAccount}")
    private String accountRetrieve;

    public AccountResponse retrieveAccount(@NonNull UUID accountId) {
        log.info("[AccountIntegration] - retrieving account");
        URI uri = UriComponentsBuilder.fromHttpUrl(accountHost + accountRetrieve)
                .buildAndExpand(accountId)
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<AccountResponse> accountResponse = restTemplateBuilder.build().exchange(requestEntity, AccountResponse.class);

        if (!ObjectUtils.isEmpty(accountResponse.getBody())) {
            log.info("[AccountIntegration] - account found {}", accountResponse.getBody().toString());
        }

        return accountResponse.getBody();
    }


}
