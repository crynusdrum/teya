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

    private String accountName;
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
