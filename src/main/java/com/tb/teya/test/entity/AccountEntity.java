package com.tb.teya.test.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "accountName")
    private String accountName;

    @Column(name = "balance")
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
