package com.consent.service;

import com.consent.dto.ConsentRequest;
import com.consent.dto.ConsentResponse;
import com.consent.entity.Consent;
import com.consent.entity.ConsentStatus;
import com.consent.mapper.ConsentMapper;
import com.consent.repository.ConsentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsentService {

    private final ConsentRepository consentRepository;

    public ConsentResponse grantConsent(ConsentRequest request) {
        Optional<Consent> existing = consentRepository.findByClientIdAndUserId(request.getClientId(), request.getUserId());

        Consent consent = existing.map(c -> {
            c.setScopes(ConsentMapper.toEntity(request).getScopes());
            c.setStatus(ConsentStatus.ACTIVE);
            c.setExpiresAt(request.getExpiresAt());
            return c;
        }).orElseGet(() -> ConsentMapper.toEntity(request));

        return ConsentMapper.toDto(consentRepository.save(consent));
    }

    public Optional<ConsentResponse> getConsent(String clientId, String userId) {
        return consentRepository.findByClientIdAndUserId(clientId, userId)
                .map(ConsentMapper::toDto);
    }
}
