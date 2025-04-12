package com.happiest.apigateway.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SimpleAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("system"); // fallback name
    }
}

