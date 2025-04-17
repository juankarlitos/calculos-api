package com.Challenge.Backend.calculos.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class CallHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    private String endpoint;

    @Column(columnDefinition = "TEXT")
    private String parameters;

    @Column(columnDefinition = "TEXT")
    private String response;

    private boolean success;
}