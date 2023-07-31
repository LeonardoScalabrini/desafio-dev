package com.desafiodev.domains;

import static com.desafiodev.domains.exceptions.IllegalStateExceptionFactory.builder;

import lombok.NonNull;
import lombok.Value;

@Value
public class CreditCard {
  private static final int CREDIT_CARD_LENGTH = 12;
  String number;

  private CreditCard(@NonNull String number) {
    if (number.isEmpty())
      throw builder(getClass())
          .message("Credit Card can't be empty")
          .param("number", number)
          .build();
    if (number.length() != CREDIT_CARD_LENGTH)
      throw builder(getClass())
          .message("Credit Card must has 12 numbers")
          .param("number", number)
          .build();
    this.number = number;
  }

  public static CreditCard getInstance(@NonNull String number) {
    return new CreditCard(number);
  }
}
