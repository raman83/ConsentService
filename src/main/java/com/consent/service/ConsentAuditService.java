package com.consent.service;

import org.springframework.stereotype.Service;

import com.consent.entity.ConsentStatus;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsentAuditService {


    public void logConsentAction(String userId, String clientId, ConsentStatus status) {
        log.info("Consent for user: {} with client: {} updated to status: {}", userId, clientId, status);
    }
}
