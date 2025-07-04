package com.consent.mapper;

import com.consent.dto.ConsentRequest;
import com.consent.dto.ConsentResponse;
import com.consent.entity.Consent;
import com.consent.entity.ConsentScope;
import com.consent.entity.ConsentStatus;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class ConsentMapper {

    public static Consent toEntity(ConsentRequest request) {
        Consent consent = Consent.builder()
                .clientId(request.getClientId())
                .userId(request.getUserId())
                .status(ConsentStatus.ACTIVE)
                .createdAt(Instant.now())
                .expiresAt(request.getExpiresAt())
                .build();

        List<ConsentScope> scopeEntities = request.getScopes().stream()
                .map(scope -> ConsentScope.builder().scope(scope).consent(consent).build())
                .collect(Collectors.toList());

        consent.setScopes(scopeEntities);
        return consent;
    }

    public static ConsentResponse toDto(Consent consent) {
        ConsentResponse response = new ConsentResponse();
        response.setId(consent.getId());
        response.setClientId(consent.getClientId());
        response.setUserId(consent.getUserId());
        response.setStatus(consent.getStatus().name());
        response.setCreatedAt(consent.getCreatedAt());
        response.setExpiresAt(consent.getExpiresAt());

        List<String> scopes = consent.getScopes().stream()
                .map(ConsentScope::getScope)
                .collect(Collectors.toList());

        response.setScopes(scopes);
        return response;
    }
}
