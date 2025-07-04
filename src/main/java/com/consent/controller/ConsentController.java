package com.consent.controller;

import com.consent.dto.ConsentRequest;
import com.consent.dto.ConsentResponse;
import com.consent.service.ConsentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/consents")
@RequiredArgsConstructor
public class ConsentController {

    private final ConsentService consentService;

    @PostMapping
    public ResponseEntity<ConsentResponse> createOrUpdateConsent(@RequestBody ConsentRequest request) {
        return ResponseEntity.ok(consentService.grantConsent(request));
    }

    @GetMapping
    public ResponseEntity<ConsentResponse> getConsent(
            @RequestParam("clientId") String clientId,
            @RequestParam("userId") String userId) {
        return consentService.getConsent(clientId, userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
