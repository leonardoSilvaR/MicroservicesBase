package com.microservices.account.service;

import com.microservices.account.api.request.AccountRequest;
import com.microservices.account.api.response.AccountResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {


  public AccountResponse createAccount(@NonNull final AccountRequest accountRequest) {
    if (accountRequest.getAge() < 18) {
      log.warn("Just a little fool");
    }
    log.info("[Account Service] Account created.");
    return AccountResponse.builder()
        .accountId(UUID.fromString("7c08aa88-529e-4175-baec-c97e0aff30eb"))
        .build();
  }

  public AccountResponse retrieveAccount(@NonNull final UUID accountId) {
    log.info("[Account Service] Searching account {}", accountId);
    return AccountResponse.builder()
        .name("Twisted Insane")
        .document("57659879073")
        .age(26)
        .build();
  }


}
