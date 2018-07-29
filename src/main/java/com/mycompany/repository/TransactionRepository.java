package com.mycompany.repository;

import com.mycompany.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TransactionRepository extends JpaRepository<Transaction, Long>, QuerydslPredicateExecutor<Transaction> {
}
