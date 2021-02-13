package com.citizens.statement.repository;


import com.citizens.statement.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query(value = "SELECT transaction_id, transaction_code, transaction_status, transaction_from_account, " +
            "transaction_to_account, transaction_desc, transaction_amount, transaction_add_dtg " +
            "FROM public.transaction where transaction_from_account=:transaction_from", nativeQuery = true)
    List<Map<String, Object>> findStatementDetailsByPayee(@Param("transaction_from") String payee);

}
