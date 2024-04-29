package cl.fapp.restapi.security.service;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RateLimitingService {

    private final ConcurrentHashMap<String, ClientRequestInfo> requestTracker = new ConcurrentHashMap<>();

    private static final int MAX_REQUESTS = 3; // Máximo de solicitudes permitidas
    private static final long LIMIT_REFRESH_PERIOD = 10; // Período en segundos

    public boolean isAllowed(String clientIp, String requestPath) {
        String key = clientIp + "@" + requestPath;
        log.debug("Key: {}", key);
        ClientRequestInfo info = requestTracker.computeIfAbsent(key, k -> new ClientRequestInfo());
        synchronized (info) {
            if (LocalDateTime.now().isAfter(info.getLastRequestTime().plusSeconds(LIMIT_REFRESH_PERIOD))) {
                info.resetRequestCount();
            }

            if (info.getRequestCount() < MAX_REQUESTS) {
                info.incrementRequestCount();
                return true;
            } else {
                return false;
            }
        }
    }

    private static class ClientRequestInfo {
        private int requestCount;
        private LocalDateTime lastRequestTime;

        ClientRequestInfo() {
            this.requestCount = 0;
            this.lastRequestTime = LocalDateTime.now();
        }

        void incrementRequestCount() {
            this.requestCount++;
            this.lastRequestTime = LocalDateTime.now();
        }

        void resetRequestCount() {
            this.requestCount = 0;
            this.lastRequestTime = LocalDateTime.now();
        }

        int getRequestCount() {
            return requestCount;
        }

        LocalDateTime getLastRequestTime() {
            return lastRequestTime;
        }
    }
}
