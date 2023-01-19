package br.com.microservice.statelessanyapi.core.controller;

import br.com.microservice.statelessanyapi.core.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/resource")
public class AppController {

    private final JwtService jwtService;

    @GetMapping
    public HashMap<String, Object> getResource(@RequestHeader String token) {
        jwtService.validateAccessToken(token);
        var data = new HashMap<String, Object>();
        data.put("status", "Ok!");
        data.put("success", true);
        data.put("code", 200);
        var authUser = jwtService.getAuthenticatedUser(token);
        data.put("id", authUser.id());
        data.put("username", authUser.username());
        return data;
    }
}
