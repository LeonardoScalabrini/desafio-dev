package com.desafiodev.application.ports.out;

import com.desafiodev.application.domains.Store;
import com.desafiodev.application.domains.Transaction;

public interface TransactionRepository {

  void save(Transaction transaction, Store store);
}
