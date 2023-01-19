package br.com.microservice.statefulanyapi.core.client;

import br.com.microservice.statefulanyapi.core.dto.AuthUserResponse;
import br.com.microservice.statefulanyapi.core.dto.TokenDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
    url = "http://localhost:8080/api/auth",
    name = "tokenClient",
    contextId = "tokenClient"
)
public interface TokenClient {

    @PostMapping("token/validate")
    TokenDTO validateToken(@RequestHeader String accessToken);

    @GetMapping("user")
    AuthUserResponse getAuthenticatedUser(@RequestHeader String accessToken);
}
