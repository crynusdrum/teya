package com.tb.teya.test.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private boolean active;

}
