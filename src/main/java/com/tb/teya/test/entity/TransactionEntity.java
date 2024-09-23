package com.tb.teya.test.entity;

import com.tb.teya.test.enums.TransactionTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TransactionTypeEnum type; //
    private Double amount;
    private String fromAccount;
    private String toAccount;
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;

}
