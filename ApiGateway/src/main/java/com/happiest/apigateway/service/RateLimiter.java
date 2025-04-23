/*
package com.happiest.apigateway.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.concurrent.TimeUnit;

@Component
public class RateLimiter extends AbstractGatewayFilterFactory<RateLimiter.Config> {

    @Autowired
    private final HazelcastInstance hazelcastInstance;

    public RateLimiter(HazelcastInstance hazelcastInstance) {
        super(Config.class);
        this.hazelcastInstance = hazelcastInstance;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String clientIp = getClientIp(exchange);
            IMap<String, Integer> rateLimitMap = hazelcastInstance.getMap("rate-limit-map");
            Integer requestCount = rateLimitMap.get(clientIp);

            if (requestCount == null) {
                rateLimitMap.put(clientIp, 1, 1, TimeUnit.MINUTES);
            } else if (requestCount >= config.getRateLimit()) {
                exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
                return exchange.getResponse().setComplete();
            } else {
                rateLimitMap.put(clientIp, requestCount + 1, 15, TimeUnit.SECONDS);
            }
            return chain.filter(exchange);
        };
    }

    private String getClientIp(ServerWebExchange exchange) {
        String xForwardedForHeader = exchange.getRequest().getHeaders().getFirst("X-Forwarded-For");
        if (xForwardedForHeader != null) {
            return xForwardedForHeader.split(",")[0];
        }
        return exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
    }

    @Getter
    @Setter
    public static class Config {
        private int rateLimit;
    }
}
*/
