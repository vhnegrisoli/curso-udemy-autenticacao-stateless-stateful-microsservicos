package br.com.microservice.statefulanyapi.core.service;

import br.com.microservice.statefulanyapi.core.client.TokenClient;
import br.com.microservice.statefulanyapi.core.dto.AuthUserResponse;
import br.com.microservice.statefulanyapi.infra.exception.AuthenticationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@Slf4j
@Service
@AllArgsConstructor
public class TokenService {

    private final TokenClient tokenClient;

    public void validateToken(String token) {
        try {
            log.info("Sending request for token {}", token);
            var response = tokenClient.validateToken(token);
            log.info("Token is valid: {}", response.toString());
        } catch (Exception ex) {
            throw new AuthenticationException("Auth error: " + ex.getMessage());
        }
    }

    public AuthUserResponse getAuthenticatedUser(String token) {
        try {
            log.info("Sending request for auth user {}", token);
            var response = tokenClient.getAuthenticatedUser(token);
            log.info("Auth user found: {}", response.toString());
            if (isEmpty(response) || isEmpty(response.id())) {
                throw new AuthenticationException("User is not found.");
            }
            return response;
        } catch (Exception ex) {
            throw new AuthenticationException("Error to get authenticated user!");
        }
    }
}
