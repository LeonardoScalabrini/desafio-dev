package com.desafiodev.domains;

import static com.desafiodev.domains.TransactionType.MovimentType.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public enum TransactionType {
  DEBITO(1, ENTRADA),
  BOLETO(2, SAIDA),
  FINANCIAMENTO(3, SAIDA),

  CREDITO(4, ENTRADA),

  RECEBIMENTO_EMPRESTIMO(5, ENTRADA),

  VENDAS(6, ENTRADA),

  RECEBIMENTO_TED(7, ENTRADA),

  RECEBIMENTO_DOC(8, ENTRADA),

  ALUGUEL(9, SAIDA);

  private static final Map<Integer, TransactionType> map = new HashMap<>();
  private final int cnabPosition;

  static {
    Arrays.stream(TransactionType.values())
        .map(transactionType -> map.put(transactionType.cnabPosition, transactionType));
  }

  private final MovimentType movimentType;

  TransactionType(int cnabPosition, MovimentType movimentType) {
    this.cnabPosition = cnabPosition;
    this.movimentType = movimentType;
  }

  public static Optional<TransactionType> getTransactionType(int cnabPosition) {
    return Optional.ofNullable(map.get(cnabPosition));
  }

  public double getValue(double value) {
    return this.movimentType.getValue(value);
  }

  enum MovimentType {
    ENTRADA((x) -> x),
    SAIDA((x) -> x * -1);

    private final Function<Double, Double> function;

    MovimentType(Function<Double, Double> function) {
      this.function = function;
    }

    double getValue(double value) {
      return function.apply(value);
    }
  }
}
