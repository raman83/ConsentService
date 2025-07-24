package com.consent.repository;

import com.consent.entity.Consent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface ConsentRepository extends JpaRepository<Consent, Long> {
    Optional<Consent> findByClientIdAndUserId(String clientId, String userId);
    List<Consent> findByExpiresAtBefore(Instant instant);

}
