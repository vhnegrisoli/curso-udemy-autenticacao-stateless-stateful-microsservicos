package br.com.stateless.authapi.core.controller;

import br.com.stateless.authapi.core.dto.AuthRequest;
import br.com.stateless.authapi.core.dto.TokenDTO;
import br.com.stateless.authapi.core.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService service;

    @PostMapping("login")
    public TokenDTO login(@RequestBody AuthRequest request) {
        return service.login(request);
    }

    @PostMapping("token/validate")
    public TokenDTO validateToken(@RequestBody TokenDTO tokenRequest) {
        return service.validateToken(tokenRequest);
    }
}
