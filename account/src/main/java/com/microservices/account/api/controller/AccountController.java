package com.microservices.account.api.controller;

import com.microservices.account.api.request.AccountRequest;
import com.microservices.account.api.response.AccountResponse;
import com.microservices.account.service.AccountService;
import java.net.URI;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

  private final AccountService accountService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createAccount(@RequestBody AccountRequest accountRequest, UriComponentsBuilder uriComponentsBuilder) {
    URI location = uriComponentsBuilder.path("/accounts/{accountId}")
        .buildAndExpand(accountService.createAccount(accountRequest).getAccountId())
        .toUri();
    log.info("[Account Controller] Account Created.");
    return ResponseEntity.created(location)
        .build();
  }

  @GetMapping(value = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AccountResponse> retrieveAccountById(@PathVariable("accountId") final UUID accountId) {
    AccountResponse response = accountService.retrieveAccount(accountId);
    log.info("[Account Controller] Account found.");
    return ResponseEntity.ok(response);
  }

}
