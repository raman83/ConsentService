package com.consent.repository;

import com.consent.entity.Consent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsentRepository extends JpaRepository<Consent, Long> {
    Optional<Consent> findByClientIdAndUserId(String clientId, String userId);
}
