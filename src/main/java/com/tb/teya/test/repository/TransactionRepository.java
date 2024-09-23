package com.tb.teya.test.repository;

import com.tb.teya.test.entity.AccountEntity;
import com.tb.teya.test.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findByAccountEntity(AccountEntity accountEntity);
}
