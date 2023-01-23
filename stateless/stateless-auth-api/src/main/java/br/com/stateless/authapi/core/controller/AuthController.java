package br.com.stateless.authapi.core.controller;

import br.com.stateless.authapi.core.dto.AuthRequest;
import br.com.stateless.authapi.core.dto.TokenDTO;
import br.com.stateless.authapi.core.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public TokenDTO validateToken(@RequestHeader String accessToken) {
        return service.validateToken(accessToken);
    }
}
