package com.consent.dto;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class ConsentRequest {
    private String clientId;
    private String userId;
    private List<String> scopes;
    private Instant expiresAt;
}
