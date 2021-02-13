package com.citizens.domain.repository;

import com.citizens.infrastructure.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
