package com.consent.dto;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class ConsentResponse {
    private Long id;
    private String clientId;
    private String userId;
    private List<String> scopes;
    private String status;
    private Instant createdAt;
    private Instant expiresAt;
}
