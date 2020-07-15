package com.microservices.account.api.response;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountResponse {

  private UUID accountId;
  private String name;
  private int age;
  private String document;


  public String getDocument() {
    return document.replace(document.substring(document.length() - 5), "*****");
  }
}
