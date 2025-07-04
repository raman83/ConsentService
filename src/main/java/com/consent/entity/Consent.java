package com.consent.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientId;
    private String userId;

    @Enumerated(EnumType.STRING)
    private ConsentStatus status;

    private Instant createdAt;
    private Instant expiresAt;

    @OneToMany(mappedBy = "consent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ConsentScope> scopes;
}