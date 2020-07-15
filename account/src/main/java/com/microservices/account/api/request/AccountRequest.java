package com.microservices.account.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {

  private String name;
  private int age;
  private String document;

}
