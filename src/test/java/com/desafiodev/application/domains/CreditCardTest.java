package com.desafiodev.application.domains;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.desafiodev.utils.UtilsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

class CreditCardTest extends UtilsTest {

  @Test
  void getInstance() {
    CreditCard creditCard = CreditCard.newInstance("222222222222");
    assertClass(CreditCard.class, creditCard);
    assertEquals("222222222222", creditCard.getNumber());
  }

  @ParameterizedTest
  @EmptySource
  @CsvSource("2222222222")
  void getInstanceWithError(String number) {
    assertThrows(IllegalStateException.class, () -> CreditCard.newInstance(number));
  }
}
